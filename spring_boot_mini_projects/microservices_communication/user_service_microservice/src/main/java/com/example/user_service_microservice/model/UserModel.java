package com.example.user_service_microservice.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserModel {
	@JsonProperty("userEmail")
	private String userEmail;
	@JsonProperty("userSummary")
	private String userSummary;
	@JsonProperty("userFirstName")
	private String userFirstName;
	@JsonProperty("userLastName")
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

	@Override
	public String toString() {
		return "UserModel [userEmail=" + userEmail + ", userSummary=" + userSummary + ", userFirstName=" + userFirstName
				+ ", userLastName=" + userLastName + ", userRating=" + userRating + "]";
	}

}
