package com.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

//include the appropriate annotation to change the status

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class CourseNotFoundException extends RuntimeException {
	// include a one argument constructor of type String and write the code to pass
	// the message to the super class
	public CourseNotFoundException(String msg) {
		super(msg);
	}
}