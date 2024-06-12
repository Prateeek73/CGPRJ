package com.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//Write appropriate annotation
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class PropertyInvalidException extends RuntimeException{
	//Write a single argument constructor with message
	public PropertyInvalidException(String msg) {
		super(msg);
	}
}
