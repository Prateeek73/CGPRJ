package com.apps.bedms.controller;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

import com.apps.bedms.exceptions.BedNotFoundException;
import com.apps.bedms.exceptions.InvalidBedCategory;
import com.apps.bedms.exceptions.InvalidBedStatus;

import java.net.UnknownHostException;
import java.time.format.DateTimeParseException;

@RestControllerAdvice
public class CentralizedExceptionHandler {

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(BedNotFoundException.class)
	public String handleBedNotFound(BedNotFoundException e) {
		return e.getMessage();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler({ InvalidBedCategory.class, InvalidBedStatus.class, InvalidBedCategory.class, ConstraintViolationException.class,
			MethodArgumentNotValidException.class, UnknownHostException.class, HttpClientErrorException.class, DateTimeParseException.class })
	public String handleInvalid(Exception e) {
		return e.getMessage();
	}
}