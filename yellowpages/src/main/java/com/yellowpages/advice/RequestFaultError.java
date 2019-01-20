package com.yellowpages.advice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Ruksad siddiqui on 11/2/18
 */
@Getter
@Setter
@AllArgsConstructor
public class RequestFaultError {

    private String errorCode;
    private String errorDescription;
}
