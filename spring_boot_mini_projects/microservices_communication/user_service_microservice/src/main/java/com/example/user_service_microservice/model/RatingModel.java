package com.example.user_service_microservice.model;

public class RatingModel {

	private Long userId;

	private Long hotelId;

	private Integer rating;

	private String feedBack;

	private HotelModel hotelModel;

	public RatingModel() {

	}

	public RatingModel(Long userId, Long hotelId, Integer rating, String feedBack, HotelModel hotelModel) {
		super();
		this.userId = userId;
		this.hotelId = hotelId;
		this.rating = rating;
		this.feedBack = feedBack;
		this.hotelModel = hotelModel;
	}

	public HotelModel getHotelModel() {
		return hotelModel;
	}

	public void setHotelModel(HotelModel hotelModel) {
		this.hotelModel = hotelModel;
	}

	public Long getUserId() {
		return userId;
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
