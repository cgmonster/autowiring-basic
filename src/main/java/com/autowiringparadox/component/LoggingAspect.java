package com.autowiringparadox.component;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static Logger logger = LoggerFactory.getLogger(LoggingAspect.class);


    @Around("execution(public * com.autowiringparadox.service.*.*(..))")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = point.proceed();
        logger.info("Method called - {}({}) Its result - {} Time to execute : {} ms", MethodSignature.class.cast(point.getSignature()).getMethod().getName(),
                point.getArgs(), result, System.currentTimeMillis() - start);
        return result;
    }
}
