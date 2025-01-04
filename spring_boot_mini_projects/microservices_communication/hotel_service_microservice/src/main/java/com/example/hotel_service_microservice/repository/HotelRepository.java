package com.example.hotel_service_microservice.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.hotel_service_microservice.entity.HotelEntity;

@Repository
public interface HotelRepository extends JpaRepository<HotelEntity,Long> {

}
