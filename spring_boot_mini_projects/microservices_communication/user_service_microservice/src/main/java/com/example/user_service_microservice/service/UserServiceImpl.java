package com.example.user_service_microservice.service;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.example.user_service_microservice.entity.UserEntity;
import com.example.user_service_microservice.exception.ResourceNotFoundException;
import com.example.user_service_microservice.model.RatingModel;
import com.example.user_service_microservice.model.UserModel;
import com.example.user_service_microservice.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public UserModel addNewUser(UserModel userModel) {
		UserEntity newUserEntity = modelToEntityMapper(userModel);
		userRepository.save(newUserEntity);
		return entityToModelMapper(newUserEntity);
	}

	@Override
	public UserModel updateUser(UserModel userModel, Long userId) {
		UserEntity userEntity = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User id doesnot exists"));
		userEntity.setUserSummary(userModel.getUserSummary());
		userEntity.setUserEmail(userModel.getUserEmail());
		userRepository.save(userEntity);
		return entityToModelMapper(userEntity);
	}

	@Override
	public List<UserModel> getAllUsers() {
		List<UserEntity> allUsersList = userRepository.findAll();
		List<UserModel> userModelList = allUsersList.stream().map((user) -> entityToModelMapper(user))
				.collect(Collectors.toList());
		return userModelList;
	}

	@Override
	public UserModel getUserByUserId(Long userId) {
		ResponseEntity<RatingModel>ratingListByUserResponse = null;
		// TODO Auto-generated method stub
		UserEntity userEntity = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User id doesnot exists"));
		String url = "http://localhost:8084/get-rating/${userId}";
		try {
			ratingListByUserResponse = restTemplate.getForEntity(new URI(url), RatingModel.class);
		} catch (RestClientException | URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("The rating model is :{} for the userId is :{}", ratingListByUserResponse,userId);

		return entityToModelMapper(userEntity);
	}

	@Override
	public void deleteUser(Long userId) {
		UserEntity userEntity = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User id doesnot exists"));
		userRepository.delete(userEntity);
	}

	private UserEntity modelToEntityMapper(UserModel userModel) {
		UserEntity userEntity = new UserEntity();
		userEntity.setUserSummary(userModel.getUserSummary());
		userEntity.setLastName(userModel.getUserLastName());
		userEntity.setFirstName(userModel.getUserFirstName());
		userEntity.setUserEmail(userModel.getUserEmail());
		return userEntity;
	}

	private UserModel entityToModelMapper(UserEntity userEntity) {
		UserModel userModel = new UserModel();
		userModel.setUserEmail(userEntity.getUserEmail());
		userModel.setUserFirstName(userEntity.getFirstName());
		userModel.setUserLastName(userEntity.getLastName());
		userModel.setUserSummary(userEntity.getUserSummary());
		return userModel;

	}

}
