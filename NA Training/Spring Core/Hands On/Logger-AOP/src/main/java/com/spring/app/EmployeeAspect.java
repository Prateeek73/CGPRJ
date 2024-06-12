package com.spring.app;

import java.util.Date;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class EmployeeAspect {

	final static Logger logger = Logger.getLogger("EmployeeAspect.class");

	@AfterReturning(pointcut = "execution(* com.spring.app.Company.registerEmployee(..))", returning = "result")
    public void logRegistrationStatus(boolean result) {
        if (result) {
            String date = (new Date()).toString();
            logger.info(date + " - " + "Registration Successful");
        }
    }
}