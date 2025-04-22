package com.example.user_service_microservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.user_service_microservice.model.UserCommonResponse;
import com.example.user_service_microservice.model.UserModel;
import com.example.user_service_microservice.service.UserService;

@RestController

@RequestMapping("/users")
public class UserControllerMicroservices {

	@Autowired
	private UserService userService;

	// @RequestMapping(value ="/register-new-user",method = RequestMethod.POST)
	@PostMapping(value = "/register-new-user")
	public ResponseEntity<UserCommonResponse> createNewUser(@RequestBody UserModel userModel) {
		UserCommonResponse createNewUserResponse = new UserCommonResponse();
		try {
			System.out.println("The userModel is ::" + userModel.toString());

			if (!ObjectUtils.isEmpty(userModel)) {
				System.out.println("The userModel is ::" + userModel.toString());
				UserModel newUserModel = userService.addNewUser(userModel);
				createNewUserResponse.setStatusCode("201");
				createNewUserResponse.setResponseMessage("User Created Successfully");
				createNewUserResponse.setResponseData(newUserModel);

			} else {
				createNewUserResponse.setStatusCode("500");
				createNewUserResponse.setResponseMessage("User not created!Please enter details in correct format");
				createNewUserResponse.setResponseData(null);
			}
		} catch (Exception e) {
			createNewUserResponse.setStatusCode("500");
			createNewUserResponse.setResponseMessage("Exception in creating the user!!");
			createNewUserResponse.setResponseData(e);
		}
		return ResponseEntity.ok(createNewUserResponse);

	}

	@PatchMapping(value = "/update-user/{userId}")
	public ResponseEntity<UserCommonResponse> updateUser(@RequestBody UserModel userModel, @PathVariable("userId") Long userId) {
		UserCommonResponse updatingUserResponse = new UserCommonResponse();
		try {
			if (!ObjectUtils.isEmpty(userModel)) {
				UserModel newUserModel = userService.updateUser(userModel, userId);
				updatingUserResponse.setStatusCode("200");
				updatingUserResponse.setResponseMessage("User Updated Successfully");
				updatingUserResponse.setResponseData(newUserModel);

			} else {
				updatingUserResponse.setStatusCode("500");
				updatingUserResponse.setResponseMessage("User details not updated!Please enter details in correct format");
				updatingUserResponse.setResponseData(null);
			}
		} catch (Exception e) {
			updatingUserResponse.setStatusCode("500");
			updatingUserResponse.setResponseMessage("Exception in updating the user details!!");
			updatingUserResponse.setResponseData(e);
		}
		return ResponseEntity.ok(updatingUserResponse);

	}

	@PostMapping(value = "/delete-user/{userId}")
	public ResponseEntity<UserCommonResponse> deleteUser(@PathVariable("userId") Long userId) {
		UserCommonResponse deletingUserResponse = new UserCommonResponse();
		try {
			userService.deleteUser(userId);
			deletingUserResponse.setStatusCode("200");
			deletingUserResponse.setResponseMessage("User deleted successfully");
			deletingUserResponse.setResponseData("Deletion occurs");

		} catch (Exception e) {
			deletingUserResponse.setStatusCode("500");
			deletingUserResponse.setResponseMessage("Exception in deleting the user details!!");
			deletingUserResponse.setResponseData(e);
		}
		return ResponseEntity.ok(deletingUserResponse);

	}

	@PostMapping(value = "/get-all-users")
	public ResponseEntity<UserCommonResponse> listOfAllUsers() {
		UserCommonResponse userListResponse = new UserCommonResponse();
		try {
			List<UserModel> userModelist = userService.getAllUsers();
			userListResponse.setStatusCode("200");
			userListResponse.setResponseMessage("List of all users");
			userListResponse.setResponseData(userModelist);

		} catch (Exception e) {
			userListResponse.setStatusCode("500");
			userListResponse.setResponseMessage("Exception in fetching all user list");
			userListResponse.setResponseData(e);
		}
		return ResponseEntity.ok(userListResponse);

	}
	
	@GetMapping(value = "/get-user/{userId}")
	public ResponseEntity<UserCommonResponse> singleUserByUserId(@PathVariable("userId")Long userId) {
		UserCommonResponse userListResponse = new UserCommonResponse();
		try {
			UserModel singleUser = userService.getUserByUserId(userId);
			userListResponse.setStatusCode("200");
			userListResponse.setResponseMessage("User detail fetched successfully");
			userListResponse.setResponseData(singleUser);

		} catch (Exception e) {
			userListResponse.setStatusCode("500");
			userListResponse.setResponseMessage("Exception in fetching User detail");
			userListResponse.setResponseData(e);
		}
		return ResponseEntity.ok(userListResponse);

	}
}
