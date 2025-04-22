package com.example.user_service_microservice.entity;

import java.util.ArrayList;
import java.util.List;

import com.example.user_service_microservice.model.RatingModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity(name = "UserEntity")
@Table(name = "user_info_tbl")
public class UserEntity {

	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	@Column(name = "user_email")
	private String userEmail;

	@Column(name = "user_summary")
	private String userSummary;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Transient
	private List<RatingModel> userRatingModelList = new ArrayList<>();

	public UserEntity(Long userId, String userEmail, String userSummary, String firstName, String lastName,
			List<RatingModel> userRatingModelList) {
		super();
		this.userId = userId;
		this.userEmail = userEmail;
		this.userSummary = userSummary;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userRatingModelList = userRatingModelList;
	}

	public UserEntity() {
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<RatingModel> getUserRatingModelList() {
		return userRatingModelList;
	}

	public void setUserRatingModelList(List<RatingModel> userRatingModelList) {
		this.userRatingModelList = userRatingModelList;
	}

	@Override
	public String toString() {
		return "UserEntity [userId=" + userId + ", userEmail=" + userEmail + ", userSummary=" + userSummary
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", userRatingModelList=" + userRatingModelList
				+ "]";
	}

}
