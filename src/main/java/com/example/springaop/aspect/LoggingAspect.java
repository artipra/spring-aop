package com.example.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.example.springaop.service.EmployeeService.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        logger.info("Calling method: " + joinPoint.getTarget().hashCode()+" started "+new Date());
        logger.info("Calling method: " + joinPoint.getThis().hashCode()+" started "+new Date());
    }

    @AfterReturning(pointcut = "execution(* com.example.springaop.service.EmployeeService.*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        logger.info("Method returned: " + result);
    }

    @AfterThrowing(pointcut = "execution(* com.example.springaop.service.EmployeeService.*(..))", throwing = "exception")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable exception) {
        logger.error("Exception in method: " + joinPoint.getSignature().getName(), exception);
    }
}