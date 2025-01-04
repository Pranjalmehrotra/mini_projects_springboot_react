package com.example.rating_service_microservice.service;


import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.rating_service_microservice.entity.RatingEntity;
import com.example.rating_service_microservice.exception.HotelNotFoundException;
import com.example.rating_service_microservice.model.RatingModel;
import com.example.rating_service_microservice.repository.RatingRepository;

@Service
public class RatingServiceImpl implements RatingService {

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
	public RatingModel getRatingByUserId(Long userId) {
		RatingEntity ratingEntity = ratingRepository.findById(userId).orElseThrow(()->new HotelNotFoundException("Hotel id not found"));
		RatingModel ratingModelFound = entityToModelMapper(ratingEntity);
		return ratingModelFound;
	}

	@Override
	public RatingModel getRatinngByHotelId(Long hotelId) {
		RatingEntity ratingEntity = ratingRepository.findById(hotelId).orElseThrow(()->new HotelNotFoundException("Hotel id not found"));
		RatingModel ratingModelFound = entityToModelMapper(ratingEntity);
		return ratingModelFound;
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
