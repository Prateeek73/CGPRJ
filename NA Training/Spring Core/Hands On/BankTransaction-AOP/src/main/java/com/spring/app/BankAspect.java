package com.spring.app;


import org.apache.log4j.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Aspect
// @EnableAspectJAutoProxy
public class BankAspect {
	
	final static Logger logger = Logger.getLogger("BankAspect.class");
	
	@Around("execution(public boolean com.spring.app.Bank.withDraw(int, float))")
    public Object logTransactionStatus(ProceedingJoinPoint pjp) throws Throwable {
        logger.info("Before Method Called");
        Object result = pjp.proceed();
        logger.info("status" + result);
        return result;
    }
}