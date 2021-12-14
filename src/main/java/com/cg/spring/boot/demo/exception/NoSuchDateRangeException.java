package com.cg.spring.boot.demo.exception;

public class NoSuchDateRangeException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public NoSuchDateRangeException(String message) {
		super(message);
	}

}
