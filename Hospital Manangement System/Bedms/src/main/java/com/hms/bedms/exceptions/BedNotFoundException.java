package com.hms.bedms.exceptions;

public class BedNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -2858733899147715939L;

	public BedNotFoundException(String id) {
		super("Bed not found for id: " + id);
	}
}
