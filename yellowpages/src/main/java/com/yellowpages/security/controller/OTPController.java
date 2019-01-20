package com.yellowpages.security.controller;

import com.yellowpages.log.annotation.Trace;
import com.yellowpages.log.eventtype.LogEventType;
import com.yellowpages.security.model.JwtAuthenticationResponse;
import com.yellowpages.security.service.CustomUserDetailsService;
import com.yellowpages.security.service.OTPServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Ruksad siddiqui on 8/4/18
 */
@Api
@RestController
@Slf4j
@RequestMapping(value = OTPController.BASE_URL, produces = { MediaType.APPLICATION_JSON_VALUE})
@CrossOrigin(origins = "*")
public class OTPController {

    public static final String BASE_URL = "/api/yellow-pages/v1/otp";


    private OTPServiceImpl otpService;
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    OTPController(OTPServiceImpl otpService,CustomUserDetailsService customUserDetailsService){
       this.otpService=otpService;
       this.customUserDetailsService=customUserDetailsService;
       this.otpService.loadCache();
    }

    @ApiOperation(value = "Generate and send OTP", nickname = "Generate OTP")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @Trace(type = LogEventType.CONTROLLER)
    @RequestMapping(value = "/generateOtp",method = RequestMethod.GET)
    public ResponseEntity<String> generateOtp(@RequestParam("phoneNumber") String phoneNUmber){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
       // String username = auth.getName();
        String generateOTP = otpService.generateOTP(phoneNUmber);
        log.info("OTP : "+generateOTP);
        return ResponseEntity.status(HttpStatus.OK).body(generateOTP);
    }

    @ApiOperation(value = "Verify sent OPT", nickname = "Verify OTP")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @Trace(type = LogEventType.CONTROLLER)
    @RequestMapping(value = "/validateOtp", method = RequestMethod.GET)
    public ResponseEntity<String> validateOtp(@RequestParam("otpnum") int otpnum, @RequestParam("phoneNumber") String phoneNUmber) {

        final String SUCCESS = "Entered Otp is valid";
        final String FAIL = "Entered Otp is NOT valid. Please Retry!";
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String status;
 //       String username = auth.getName();
        log.info(" Otp Number : " + otpnum);

        if (otpnum >= 0) {
            int serverOtp = otpService.getOtp(phoneNUmber);
            if (serverOtp > 0) {
                if (otpnum == serverOtp) {
                    otpService.clearOTP(phoneNUmber);
                    status=SUCCESS;
                } else {
                    status=FAIL;
                }
            } else {
                status= FAIL;
            }
        } else {
            status= FAIL;
        }
        return ResponseEntity.status(HttpStatus.OK).body(status);
    }

}
