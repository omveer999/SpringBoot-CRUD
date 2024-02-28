package com.example.usermanagement.exception;

public class InvalidRequestException  extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -265309185893196261L;

	public InvalidRequestException(String message){
		super(message);
	}
}
