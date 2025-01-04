package com.example.hotel_service_microservice.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.example.hotel_service_microservice.model.HotelCommonResponse;

@RestControllerAdvice
public class HotelGlobalException {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<HotelCommonResponse>handleResourceNotFoundException(ResourceNotFoundException ex){
		HotelCommonResponse hotelResourceNotFoundResponse = new HotelCommonResponse();
		hotelResourceNotFoundResponse.setResponseMessage(ex.getMessage());
		hotelResourceNotFoundResponse.setStatusCode(String.valueOf(HttpStatus.NOT_FOUND.value()));
		hotelResourceNotFoundResponse.setResponseData("Not found any hotel with the id");
		return ResponseEntity.ok(hotelResourceNotFoundResponse);
		
	}

}
