package com.example.rating_service_microservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.rating_service_microservice.entity.RatingEntity;

@Repository
public interface RatingRepository extends JpaRepository<RatingEntity,Long> {
	
	@Query("Select ratingEntity from RatingEntity ratingEntity where ratingEntity.hotelId = :hotelId")
	public Optional<List<RatingEntity>> findRatingEntityByHotelId(@Param("hotelId")Long hotelId);
	
	@Query("Select ratingEntity from RatingEntity ratingEntity where ratingEntity.userId = :userId")
	public Optional<List<RatingEntity>> findRatingEntityByUserId(@Param("userId")Long userId);


}
