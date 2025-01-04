package com.example.user_service_microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.user_service_microservice.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

}
