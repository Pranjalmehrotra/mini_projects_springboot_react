package com.example.user_service_microservice.model;

import java.util.ArrayList;
import java.util.List;

public class UserModel {

	private String userEmail;
	private String userSummary;
	private String userFirstName;
	private String userLastName;
	private List<UserRatingModel> userRating = new ArrayList<>();

	public UserModel() {
	}

	public UserModel(String userEmail, String userSummary, String userFirstName, String userLastName,
			List<UserRatingModel> userRating) {
		super();
		this.userEmail = userEmail;
		this.userSummary = userSummary;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userRating = userRating;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserSummary() {
		return userSummary;
	}

	public void setUserSummary(String userSummary) {
		this.userSummary = userSummary;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public List<UserRatingModel> getUserRating() {
		return userRating;
	}

	public void setUserRating(List<UserRatingModel> userRating) {
		this.userRating = userRating;
	}

}
