package com.example.rating_service_microservice.service;

import java.util.List;

import com.example.rating_service_microservice.model.RatingModel;

public interface RatingService {
	
	public RatingModel createRating(RatingModel ratingModel);
	
	public List<RatingModel> getAllRatings();
	
	public RatingModel getRatingByUserId(Long userId);
	
	public RatingModel getRatinngByHotelId(Long hotelId);
	

}
