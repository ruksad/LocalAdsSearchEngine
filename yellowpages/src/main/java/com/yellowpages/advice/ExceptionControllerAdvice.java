package com.yellowpages.advice;

import com.yellowpages.exception.RequestFaultException;
import com.yellowpages.exception.YellowPagesApiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by Ruksad siddiqui on 26/1/18
 */
@Slf4j
@ControllerAdvice
public class ExceptionControllerAdvice {

  /*
   * catching all unhandled exceptions from Controllers
   */
  @ExceptionHandler(Exception.class)
  public ResponseEntity<RestErrorResponse> processException(Exception ex) {
    log.error("Exception caught: ", ex);
    ResponseEntity responseEntity = new ResponseEntity<>(
        new RestErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR,
            ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);

    return responseEntity;
  }

  /**
   * method to handle HttpMessageNotReadableException
   */
  @ExceptionHandler(value = {HttpMessageNotReadableException.class,
      MissingServletRequestParameterException.class})
  private ResponseEntity<RestErrorResponse> processBadRequestException(Exception ex) {
    log.error(ex.getClass().getName() + " caught", ex);
    ResponseEntity responseEntity = new ResponseEntity<>(
        new RestErrorResponse(HttpStatus.BAD_REQUEST,
            ex.getMessage()), HttpStatus.BAD_REQUEST);

    return responseEntity;
  }


  /**
   * Method to handle RestAPIException
   */
  @ExceptionHandler(YellowPagesApiException.class)
  private ResponseEntity<RestErrorResponse> processRestAPIException(YellowPagesApiException ex) {
    if (!HttpStatus.NOT_FOUND.equals(ex.getErrorCode())) {
      log.error("RestAPIException caught: {} ", ex);
    }
    ResponseEntity responseEntity;
    if (ex.getErrorCode().equals(HttpStatus.NOT_FOUND)) {
      responseEntity = new ResponseEntity<>(
          new RestErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage()),
          HttpStatus.NOT_FOUND);
    } else if (ex.getErrorCode().equals(HttpStatus.BAD_REQUEST)) {
      responseEntity = new ResponseEntity<>(
          new RestErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage()),
          HttpStatus.BAD_REQUEST);
    } else {

      responseEntity = new ResponseEntity<>(new RestErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR,
          ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return responseEntity;
  }

  @ExceptionHandler(RequestFaultException.class)
  private ResponseEntity<RestErrorResponse> processRequestFaultException(RequestFaultException ex) {
    ResponseEntity  responseEntity = new ResponseEntity<>(new RequestFaultError(ex.getCode(),ex.getErrorDescription()),HttpStatus.BAD_REQUEST);
    return responseEntity;
  }
}
