package com.cg.spring.boot.demo.exception;

public class NoSuchMobileNumberException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public NoSuchMobileNumberException(String message) {
		super(message);
	}

}
