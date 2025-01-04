package com.example.user_service_microservice.service;

import java.util.List;

import com.example.user_service_microservice.model.UserModel;

public interface UserService {

	// Create
	public UserModel addNewUser(UserModel userModel);

	// Update
	public UserModel updateUser(UserModel userModel,Long userId);

	//Get Single User
	public List<UserModel> getAllUsers();

	//Get List of the User
	public UserModel getUserByUserId(Long userId);

	// Delete
	public void deleteUser(Long userId);

}
