package com.yellowpages.security.exception;

/**
 * Created by Ruksad siddiqui on 7/4/18
 */
public class AuthenticationException extends RuntimeException {
    public AuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }
}
