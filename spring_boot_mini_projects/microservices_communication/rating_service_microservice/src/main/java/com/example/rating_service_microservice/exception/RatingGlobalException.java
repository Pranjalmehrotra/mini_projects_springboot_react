package com.example.rating_service_microservice.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.example.rating_service_microservice.model.RatingCommonResponse;

@RestControllerAdvice
public class RatingGlobalException {

	@ExceptionHandler(HotelNotFoundException.class)
	public ResponseEntity<RatingCommonResponse> handleRespourceNotFoundException(HotelNotFoundException ex) {
		RatingCommonResponse ratingErrorReponse = new RatingCommonResponse();
		ratingErrorReponse.setResponseMessage(ex.getMessage());
		ratingErrorReponse.setStatusCode(String.valueOf(HttpStatus.NOT_FOUND.value()));
		ratingErrorReponse.setResponseData("Not found any rating with the id");
		return ResponseEntity.ok(ratingErrorReponse);

	}

}
