package com.apps.bookingms.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

import com.apps.bookingms.exceptions.BookingNotFoundException;

import java.net.UnknownHostException;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class CentralizedExceptionHandler {

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler({ BookingNotFoundException.class })
	public String handleBookingNotFound(Exception e) {
		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = { NullPointerException.class,
			MethodArgumentNotValidException.class, ConstraintViolationException.class, UnknownHostException.class,
			HttpClientErrorException.class })
	public String handleInvalid(Exception e) {
		return e.getMessage();

	}
}
