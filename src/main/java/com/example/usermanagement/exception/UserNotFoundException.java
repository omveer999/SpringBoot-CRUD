package com.example.usermanagement.exception;

public class UserNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -461750840913916678L;

	public UserNotFoundException(String message) {
		super(message);
	}
}
