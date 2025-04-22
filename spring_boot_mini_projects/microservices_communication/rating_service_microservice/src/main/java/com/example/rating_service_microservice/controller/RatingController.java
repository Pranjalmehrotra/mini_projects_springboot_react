package com.example.rating_service_microservice.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.rating_service_microservice.model.RatingCommonResponse;
import com.example.rating_service_microservice.model.RatingModel;
import com.example.rating_service_microservice.service.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {

	@Autowired
	RatingService ratingService;

	@PostMapping("/register-new-rating")
	public ResponseEntity<RatingCommonResponse> createNewHotel(@RequestBody RatingModel ratingModel) {
		RatingCommonResponse createNewRatingResponse = new RatingCommonResponse();
		try {
			if (!ObjectUtils.isEmpty(ratingModel)) {
				RatingModel newUserModel = ratingService.createRating(ratingModel);
				createNewRatingResponse.setStatusCode("201");
				createNewRatingResponse.setResponseMessage("User Created Successfully");
				createNewRatingResponse.setResponseData(newUserModel);

			} else {
				createNewRatingResponse.setStatusCode("500");
				createNewRatingResponse.setResponseMessage("User not created!Please enter details in correct format");
				createNewRatingResponse.setResponseData(null);
			}
		} catch (Exception e) {
			createNewRatingResponse.setStatusCode("500");
			createNewRatingResponse.setResponseMessage("Exception in creating the user!!");
			createNewRatingResponse.setResponseData(e);
		}
		return ResponseEntity.ok(createNewRatingResponse);

	}

	@GetMapping("/get-all-ratings")
	public ResponseEntity<RatingCommonResponse> getlistOfRatings() {
		RatingCommonResponse hotelListResponse = new RatingCommonResponse();
		try {
			List<RatingModel> ratingModelList = ratingService.getAllRatings();
			hotelListResponse.setStatusCode("200");
			hotelListResponse.setResponseMessage("List of all Ratings");
			hotelListResponse.setResponseData(ratingModelList);
		} catch (Exception e) {
			hotelListResponse.setStatusCode("500");
			hotelListResponse.setResponseMessage("Exception in getting the user details!!");
			hotelListResponse.setResponseData(e);
		}
		return ResponseEntity.ok(hotelListResponse);

	}

	//@GetMapping(value = "/get-rating/{hotelId}")
	@GetMapping(value = "/get-rating")
	//public ResponseEntity<RatingCommonResponse> getSingleRatingByHotelId(@PathVariable("hotelId") Long hotelId) {

	public ResponseEntity<RatingCommonResponse> getSingleRatingByHotelId(@RequestParam(name = "hotelId") Long hotelId) {
		RatingCommonResponse ratingResponse = new RatingCommonResponse();
		try {
			System.out.println("The hotel id is ::" + hotelId);
			List<RatingModel> hotelListDetailsByHotelId = ratingService.getRatinngByHotelId(hotelId);
			ratingResponse.setStatusCode("200");
			ratingResponse.setResponseMessage("Rating details fetched successfully");
			ratingResponse.setResponseData(hotelListDetailsByHotelId);

		} catch (Exception e) {
			ratingResponse.setStatusCode("500");
			ratingResponse.setResponseMessage("Exception in fetching hotel detail");
			ratingResponse.setResponseData("Exception in fetching hotel detail");
		}
		return ResponseEntity.ok(ratingResponse);

	}

	@GetMapping(value = "/get-rating/{userId}")
	public ResponseEntity<RatingCommonResponse> getSingleRatingByUserlId(@PathVariable("userId") Long userId) {
		RatingCommonResponse ratingResponse = new RatingCommonResponse();
		try {
			List<RatingModel> hotelListDetailsByUserId = ratingService.getRatingByUserId(userId);
			ratingResponse.setStatusCode("200");
			ratingResponse.setResponseMessage("Rating details fetched successfully");
			ratingResponse.setResponseData(hotelListDetailsByUserId);

		} catch (Exception e) {
			ratingResponse.setStatusCode("500");
			ratingResponse.setResponseMessage("Exception in fetching hotel detail");
			ratingResponse.setResponseData("User id not found!!Please enter correct userId");
		}
		return ResponseEntity.ok(ratingResponse);

	}

}
