package com.cg.spring.boot.demo.exception;

public class InvalidLoginCredentialException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private String message;
	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public InvalidLoginCredentialException(String message) {
		super(message);
	}
}
