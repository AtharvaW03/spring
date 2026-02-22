package com.sprint;

import org.apache.commons.logging.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
@Component
@Order(2) //can add @Order annotation to specify execution position
public class LoggingAspect {
    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Around("@annotation(ToLog)")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable{

        logger.info("Logging aspect: Calling the intercepted method");

        Object returnedValue = joinPoint.proceed();

        logger.info("Method executed and returned " + returnedValue);

        return returnedValue;
    }
}
