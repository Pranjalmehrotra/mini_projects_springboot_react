package com.example.user_service_microservice.model;

public class UserRatingModel {

	private Integer ratingId;
	private Integer userId;
	private Integer hotelId;
	private Integer userRating;
	private String userFeedBack;

	public UserRatingModel() {
	}

	public UserRatingModel(Integer ratingId, Integer userId, Integer hotelId, Integer userRating, String userFeedBack) {
		super();
		this.ratingId = ratingId;
		this.userId = userId;
		this.hotelId = hotelId;
		this.userRating = userRating;
		this.userFeedBack = userFeedBack;
	}

	public Integer getRatingId() {
		return ratingId;
	}

	public void setRatingId(Integer ratingId) {
		this.ratingId = ratingId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getHotelId() {
		return hotelId;
	}

	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}

	public Integer getUserRating() {
		return userRating;
	}

	public void setUserRating(Integer userRating) {
		this.userRating = userRating;
	}

	public String getUserFeedBack() {
		return userFeedBack;
	}

	public void setUserFeedBack(String userFeedBack) {
		this.userFeedBack = userFeedBack;
	}

	@Override
	public String toString() {
		return "UserRatingModel [ratingId=" + ratingId + ", userId=" + userId + ", hotelId=" + hotelId + ", userRating="
				+ userRating + ", userFeedBack=" + userFeedBack + "]";
	}
}
