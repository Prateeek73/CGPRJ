package com.recruitment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CandidateAlreadyExistsException extends Exception{
	public CandidateAlreadyExistsException(String msg) {
		super(msg);
	}
}
