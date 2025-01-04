package com.example.rating_service_microservice.exception;

public class HotelNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HotelNotFoundException(String message) {
		super(message);
	}

}
