package com.aakashcreator.exception;

public class ResourceNotFoundException extends RuntimeException {

	public ResourceNotFoundException() {
		super("user is not found !");
	}
	
	public ResourceNotFoundException(String msg) {
		super(msg);
	}
	
}
