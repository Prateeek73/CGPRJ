package com.exception;

public class InvalidTicketException extends Exception{
	public InvalidTicketException(String msg) {
		super(msg);
	}
}