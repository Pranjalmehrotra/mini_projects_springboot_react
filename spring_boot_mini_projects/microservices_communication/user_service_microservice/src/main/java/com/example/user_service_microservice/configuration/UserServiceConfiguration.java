package com.example.user_service_microservice.configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class UserServiceConfiguration {

    @Bean()
    RestTemplate restTemplate() {

		return new RestTemplate();
	}

}
