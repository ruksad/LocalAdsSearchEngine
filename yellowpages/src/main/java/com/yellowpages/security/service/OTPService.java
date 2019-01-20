package com.yellowpages.security.service;

/**
 * Created by Ruksad siddiqui on 8/4/18
 */
public interface OTPService {

    String generateOTP(String key);
    int getOtp(String key);
    void clearOTP(String key);
}
