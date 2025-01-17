package com.example.rating_service_microservice.service;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.rating_service_microservice.entity.RatingEntity;
import com.example.rating_service_microservice.exception.RatingNotFoundException;
import com.example.rating_service_microservice.model.RatingModel;
import com.example.rating_service_microservice.repository.RatingRepository;

@Service
public class RatingServiceImpl implements RatingService {
	
	private  Logger ratingLogger =  
           LoggerFactory.getLogger(RatingServiceImpl.class);
	
	@Autowired
	RatingRepository ratingRepository;

	@Override
	public RatingModel createRating(RatingModel ratingModel) {
		RatingEntity ratingEntity = modelToEntityMapper(ratingModel);
		ratingRepository.save(ratingEntity);
		return entityToModelMapper(ratingEntity);
	}

	@Override
	public List<RatingModel> getAllRatings() {
		List<RatingEntity> ratingEntityList = ratingRepository.findAll();
		List<RatingModel> ratingModelList = ratingEntityList.stream()
				.map((ratingEntity) -> entityToModelMapper(ratingEntity)).collect(Collectors.toList());
		return ratingModelList;
	}

	@Override
	public List<RatingModel> getRatingByUserId(Long userId) {
		ratingLogger.info("The user id is {}", userId);
		List<RatingEntity> ratingEntityList = ratingRepository.findRatingEntityByUserId(userId)
				.orElseThrow(() -> new RatingNotFoundException("Hotel id not found"));
		List<RatingModel> ratingModelFoundList = ratingEntityList.stream().map((ratingEntity) -> {
			return entityToModelMapper(ratingEntity);
		}).collect(Collectors.toList());
		return ratingModelFoundList;
	}

	@Override
	public List<RatingModel> getRatinngByHotelId(Long hotelId) {
		ratingLogger.info("The hotel id is {}", hotelId);
		List<RatingEntity> ratingEntityList = ratingRepository.findRatingEntityByHotelId(hotelId)
				.orElseThrow(() -> new RatingNotFoundException("Hotel id not found"));
		System.out.println("Rating entity is ::" + ratingEntityList);
		List<RatingModel> ratingModelFoundList = ratingEntityList.stream().map((ratingEntity) -> {
			return entityToModelMapper(ratingEntity);
		}).collect(Collectors.toList());
		return ratingModelFoundList;
	}

	private RatingEntity modelToEntityMapper(RatingModel ratingModel) {
		RatingEntity ratingEntity = new RatingEntity();
		ratingEntity.setFeedBack(ratingModel.getFeedBack());
		ratingEntity.setHotelId(ratingModel.getHotelId());
		ratingEntity.setRating(ratingModel.getRating());
		ratingEntity.setUserId(ratingModel.getUserId());
		return ratingEntity;
	}

	private RatingModel entityToModelMapper(RatingEntity hotelEntity) {
		RatingModel ratingModel = new RatingModel();
		ratingModel.setFeedBack(hotelEntity.getFeedBack());
		ratingModel.setHotelId(hotelEntity.getHotelId());
		ratingModel.setRating(hotelEntity.getRating());
		ratingModel.setUserId(hotelEntity.getUserId());
		return ratingModel;

	}

}
