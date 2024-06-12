package com.recruitment.exception;

import java.time.LocalDate;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(
				LocalDate.now(),
				ex.getMessage(),
				request.getDescription(false),
				HttpStatus.NOT_FOUND.toString()
				);
		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(CandidateAlreadyExistsException.class)
	public final ResponseEntity<ExceptionResponse> handleNotFoundException(CandidateAlreadyExistsException ex,
			WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(
				LocalDate.now(),
				ex.getMessage(),
				request.getDescription(false),
				HttpStatus.NOT_FOUND.toString()
				);
		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,

			HttpHeaders headers, HttpStatusCode status, WebRequest request) {

		StringBuilder details = new StringBuilder("validation fails ");
		ex.getBindingResult().getFieldErrors().forEach(errors -> details.append(errors.getDefaultMessage()).append(", "));
		
		ExceptionResponse exceptionResponse = new ExceptionResponse(
				LocalDate.now(),
				details.toString(),
				request.getDescription(false),
				HttpStatus.NOT_FOUND.toString()
				);
		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
	}

}