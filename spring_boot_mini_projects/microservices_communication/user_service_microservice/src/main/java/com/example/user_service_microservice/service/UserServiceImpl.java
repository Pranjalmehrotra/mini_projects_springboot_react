package com.example.user_service_microservice.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.example.user_service_microservice.entity.UserEntity;
import com.example.user_service_microservice.exception.ResourceNotFoundException;
import com.example.user_service_microservice.model.HotelModel;
import com.example.user_service_microservice.model.RatingModel;
import com.example.user_service_microservice.model.UserModel;
import com.example.user_service_microservice.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
		ResponseEntity<String> ratingListByUserResponse = null;
		UserEntity userEntity = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User id doesnot exists"));
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		String url = "http://localhost:8084/get-rating/" + userId;
		String hotelUrlSample = "http://localhost:8083/get-hotel/1";
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			ratingListByUserResponse = restTemplate.getForEntity(new URI(url), String.class);
			String ratingResponseString = ratingListByUserResponse.getBody();
			/*
			 * ResponseEntity<String> hotelByUserIdSample =
			 * restTemplate.getForEntity(hotelUrlSample, String.class); String
			 * hotelResponseString = hotelByUserIdSample.getBody();
			 * logger.info("The hotel response string is {}", hotelResponseString);
			 */
			Object jsonObject = new JSONParser().parse(ratingResponseString);
			JSONObject ratingJson = (JSONObject) jsonObject;
			logger.info("The response body :{}", ratingResponseString);
			// List<RatingModel> ratingModelList =
			// (List<RatingModel>)ratingJson.get("responseData");
			List<RatingModel> ratingModelList = objectMapper.convertValue(ratingJson.get("responseData"),
					ArrayList.class);
			/*
			 * JSONObject hotelJson = (JSONObject) new
			 * JSONParser().parse(hotelResponseString); String hotelModelString =
			 * hotelJson.get("responseData").toString();
			 * logger.info("The String value of the hotelModelResponse is {}"
			 * ,hotelModelString); //HotelModel hotelModelResponse = (HotelModel)
			 * hotelJson.get("responseData");
			 * 
			 * HotelModel hotelModelResponse =
			 * objectMapper.readValue(hotelJson.get("responseData").toString(),
			 * HotelModel.class);;
			 */
			
			//logger.info("The hotel model response is {}", hotelModelResponse);
//			
			  List<RatingModel> updatedRatingModelList =
						ratingModelList.stream().map(eachRating -> {
							Long hotelId = eachRating.getHotelId();
							String hotelUrl = "http://localhost:8083/get-hotel/" + hotelId;
							ResponseEntity<String> hotelByUserId = restTemplate.getForEntity(hotelUrl, String.class);
							try {
								JSONObject hotelJson = (JSONObject) new JSONParser().parse(hotelByUserId.getBody());
								String hotelModelString = hotelJson.get("responseData").toString();
								logger.info("The String value of the hotelModelResponse is {}",hotelModelString);
								//HotelModel hotelModelResponse = (HotelModel) hotelJson.get("responseData");
								
								HotelModel hotelModelResponse = objectMapper.readValue(hotelJson.get("responseData").toString(), HotelModel.class);;

								eachRating.setHotelModel(hotelModelResponse);
							} catch (ParseException |JsonProcessingException e ) {
								e.printStackTrace();
							}
							return eachRating;

						}).collect(Collectors.toList());
			 

			/*
			 * ratingModelList.forEach(eachRating->{ Long hotelId = eachRating.getHotelId();
			 * String hotelUrl = "http://localhost:8083/get-hotel/" + hotelId;
			 * ResponseEntity<String>hotelByUserId = restTemplate.getForEntity(hotelUrl,
			 * String.class); try { JSONObject hotelJson = (JSONObject)new
			 * JSONParser().parse(hotelByUserId.getBody()); HotelModel hotelModelResponse =
			 * (HotelModel)hotelJson.get("responseData");
			 * eachRating.setHotelModel(hotelModelResponse); } catch (ParseException e) {
			 * e.printStackTrace(); }
			 * 
			 * 
			 * });
			 */
			logger.info("The ratingModelList is {}", ratingModelList.toString());
			// ratingListByUserResponseByGetForObject,userId);
			// userEntity.setUserRatingModelList(updatedRatingModelList);
			userEntity.setUserRatingModelList(updatedRatingModelList);

			logger.info("The jsonObject is {}", jsonObject);
		} catch (RestClientException | URISyntaxException | ParseException e) {
			e.printStackTrace();
		}

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
		userModel.setUserRating(userEntity.getUserRatingModelList());
		return userModel;

	}

	private ArrayList<Object> convertJSONArrayToList(JSONArray jArr) {
		ArrayList<Object> list = new ArrayList<Object>();
		try {
			for (int i = 0, l = jArr.size(); i < l; i++) {
				list.add(jArr.get(i));
			}
		} catch (Exception e) {
		}

		return list;
	}

}
