package com.yellowpages.exception;


import lombok.Getter;
import lombok.Setter;
import com.yellowpages.utils.ErrorCode;

/**
 * Created by Ruksad siddiqui on 10/2/18
 */
@Getter
@Setter
public class RequestFaultException extends RuntimeException {
    protected String code;
    protected String errorDescription;


    public RequestFaultException() {
        super();
    }

    public RequestFaultException(String code, String errorDescription) {
        super(errorDescription);
        setFields(code, errorDescription);
    }

    public RequestFaultException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        setFields(errorCode.getCode(), errorCode.getMessage());
    }

    public RequestFaultException(ErrorCode errorCode, Throwable cause) {
        super(errorCode.getMessage(), cause);
    }


    private void setFields(String code, String description){
        this.code = code;
        this.errorDescription = description;
    }
    @Override
    public String toString() {
        return "EniException [code=" + code + ", errorDescription=" +errorDescription+"]";
    }

}
