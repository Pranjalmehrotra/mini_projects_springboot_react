package com.example.rating_service_microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.rating_service_microservice.entity.RatingEntity;

@Repository
public interface RatingRepository extends JpaRepository<RatingEntity,Long> {

}
