package com.example.user_service_microservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.example.user_service_microservice.model.UserCommonResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<UserCommonResponse> handleResourceNotFoundException(ResourceNotFoundException ex) {
		UserCommonResponse errorResponse = new UserCommonResponse();
		errorResponse.setResponseMessage(ex.getMessage());
		errorResponse.setStatusCode(String.valueOf(HttpStatus.NOT_FOUND.value()));
		errorResponse.setResponseData("Resource not found exception");
		return ResponseEntity.ok(errorResponse);

	}

}
