package com.example.user_service_microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UserServiceMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceMicroserviceApplication.class, args);
	}

}
