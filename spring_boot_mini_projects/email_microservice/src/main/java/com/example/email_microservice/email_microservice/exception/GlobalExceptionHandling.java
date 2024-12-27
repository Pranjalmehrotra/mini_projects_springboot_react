package com.example.email_microservice.email_microservice.exception;

import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;

@RestControllerAdvice
public class GlobalExceptionHandling {

	@ExceptionHandler(InvalidDefinitionException.class)
	public ResponseEntity<ErrorObject> handleInvalidDefinitionExcpetion(InvalidDefinitionException ex,
			WebRequest request) {
		ErrorObject errorObject = new ErrorObject();
		errorObject.setMessage(ex.getMessage());
		errorObject.setStatusCode(HttpStatus.CONFLICT.value());
		errorObject.setTimestamp(new Date());
		return ResponseEntity.ok(errorObject);

	}

	@ExceptionHandler(HttpMediaTypeNotSupportedException.class)
	public ResponseEntity<ErrorObject> handleHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException ex,
			WebRequest request) {
		ErrorObject errorObject = new ErrorObject();
		errorObject.setMessage(ex.getMessage());
		errorObject.setStatusCode(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value());
		errorObject.setTimestamp(new Date());
		return ResponseEntity.ok(errorObject);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ErrorObject> handleIllegalArgumentException(IllegalArgumentException ex, WebRequest request) {
		ErrorObject errorObject = new ErrorObject();
		errorObject.setMessage(ex.getMessage());
		errorObject.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorObject.setTimestamp(new Date());
		return ResponseEntity.ok(errorObject);

	}

}
