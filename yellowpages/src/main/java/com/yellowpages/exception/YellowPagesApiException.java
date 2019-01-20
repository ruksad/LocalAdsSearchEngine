package com.yellowpages.exception;

import com.yellowpages.utils.ErrorCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 * Created by Ruksad siddiqui on 30/1/18
 */
@Getter
@Setter
public class YellowPagesApiException extends RuntimeException {

  private  HttpStatus errorCode;


  public YellowPagesApiException(HttpStatus errorCode, String message) {
    super(message);
    this.errorCode = errorCode;
  }

  public YellowPagesApiException(ErrorCode errorCode, Throwable cause) {
    super(errorCode.getMessage(), cause);
  }
}
