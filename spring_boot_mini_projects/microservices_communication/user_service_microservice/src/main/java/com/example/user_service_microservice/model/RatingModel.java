package com.example.user_service_microservice.model;

public class RatingModel {

	private Long userId;

	private Long hotelId;

	private Integer rating;

	private String feedBack;

	public Long getUserId() {
		return userId;
	}

	public RatingModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RatingModel(Long userId, Long hotelId, Integer rating, String feedBack) {
		super();
		this.userId = userId;
		this.hotelId = hotelId;
		this.rating = rating;
		this.feedBack = feedBack;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getHotelId() {
		return hotelId;
	}

	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getFeedBack() {
		return feedBack;
	}

	public void setFeedBack(String feedBack) {
		this.feedBack = feedBack;
	}
}
