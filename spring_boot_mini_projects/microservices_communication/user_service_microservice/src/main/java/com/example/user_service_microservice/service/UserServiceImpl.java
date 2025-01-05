package com.example.user_service_microservice.service;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.user_service_microservice.entity.UserEntity;
import com.example.user_service_microservice.exception.ResourceNotFoundException;
import com.example.user_service_microservice.model.UserModel;
import com.example.user_service_microservice.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

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
		// TODO Auto-generated method stub
		UserEntity userEntity = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User id doesnot exists"));

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
