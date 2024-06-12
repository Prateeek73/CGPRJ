package com.spring.dao;

import org.aspectj.lang.annotation.Pointcut;

public class PointCutDemo {
	@Pointcut("execution(* com.spring.dao.FlightDAO.bookFlight(..))")
	public void bookFlightPointcut() {
	}
}