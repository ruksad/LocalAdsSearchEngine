package com.yellowpages.security.service;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.yellowpages.exception.RequestFaultException;
import com.yellowpages.exception.YellowPagesApiException;
import com.yellowpages.utils.CommonUtils;
import com.yellowpages.utils.ErrorCode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ruksad siddiqui on 8/4/18
 */
@Service
public class OTPServiceImpl implements OTPService {



    @Value("${OTP.expire.mins}")
    private Integer EXPIRE_MINS;

    @Value("${OTP.suffix_message}")
    private String OTPSuffixMessage;
    @Value("${OTP.sender}")
    private String OTPSender;
    @Value("${OTP.api_key}")
    private String OTPApiKey;

    private LoadingCache<String, Integer> otpCache;

    public void loadCache(){
        otpCache= CacheBuilder.newBuilder().
                expireAfterWrite(EXPIRE_MINS, TimeUnit.MINUTES)
                .build(new CacheLoader<String, Integer>() {
                    public Integer load(String key) {
                        return 0;
                    }
                });
    }

    //This method is used to push the opt number against Key. Rewrite the OTP if it exists
    //Using user id  as key
    @Override
    public String generateOTP(String key) {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000);
        otpCache.put(key, otp);
        String sendOTPToNumber = sendOTPToNumber(key, otp);
        return sendOTPToNumber;
    }


    @Override
    public int getOtp(String key) {
        try{
            return otpCache.get(key);
        }catch (Exception e){
            return 0;
        }
    }

    @Override
    public void clearOTP(String key) {
        otpCache.invalidate(key);
    }

    private String sendOTPToNumber(String number,int otp)  {

        if (CommonUtils.validatePhoneNumber(number)) {

            HttpURLConnection conn = null;
            try {
                conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();

                String buildOtpMessage = buildOtpMessage(number, otp);
                conn.setDoOutput(true);
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Length", Integer.toString(buildOtpMessage.length()));
                conn.getOutputStream().write(buildOtpMessage.getBytes("UTF-8"));


                final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                final StringBuffer stringBuffer = new StringBuffer();
                String line;

                while ((line = rd.readLine()) != null) {
                    stringBuffer.append(line);
                }
                rd.close();
                return stringBuffer.toString();
            } catch (IOException e) {
                throw new YellowPagesApiException(ErrorCode.ERROR_WHILE_SENDING_OPT,e.getCause());
            }

        } else {
            throw new RequestFaultException(ErrorCode.PHONE_NUMBER_IS_NOT_VALID);
        }
    }

    private String buildOtpMessage(String number,int otp){
        StringBuffer stringBuffer = new StringBuffer()
                .append("apikey="+OTPApiKey)
                .append("&numbers="+number)
                .append("&message="+String.valueOf(otp) + " " + OTPSuffixMessage)
                .append("&sender="+OTPSender);
        return stringBuffer.toString();
    }
}
