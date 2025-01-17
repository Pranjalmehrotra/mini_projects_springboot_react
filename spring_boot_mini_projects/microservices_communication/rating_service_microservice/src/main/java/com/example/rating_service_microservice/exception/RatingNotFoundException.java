package com.example.rating_service_microservice.exception;

public class RatingNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RatingNotFoundException(String message) {
		super(message);
	}

}
