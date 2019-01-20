package com.yellowpages.log.annotation;

import com.yellowpages.log.eventtype.LogEventType;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Ruksad siddiqui on 30/1/18
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.METHOD})
public @interface Trace {
  LogEventType type() default LogEventType.REQUEST;
}
