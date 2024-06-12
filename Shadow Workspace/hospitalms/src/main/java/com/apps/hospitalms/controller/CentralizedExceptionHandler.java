package com.apps.hospitalms.controller;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import com.apps.hospitalms.exceptions.HospitalNotFoundException;
import com.apps.hospitalms.exceptions.InvalidHospitalTypeException;

@RestControllerAdvice
public class CentralizedExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(HospitalNotFoundException.class)
    public String handleHospitalNotFound(HospitalNotFoundException e) {
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({
            InvalidHospitalTypeException.class,
            MethodArgumentNotValidException.class,
            ConstraintViolationException.class
    })
    public String handleInvalid(Exception e) {
        return e.getMessage();
    }
}
