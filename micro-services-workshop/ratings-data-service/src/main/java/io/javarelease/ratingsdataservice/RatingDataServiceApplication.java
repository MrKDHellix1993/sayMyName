package io.javarelease.ratingsdataservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import io.javarelease.ratingsdataservice.model.UserRating;

@EnableEurekaClient
@SpringBootApplication
public class RatingDataServiceApplication {

	@Bean
	UserRating getUserRatingObj() {
		return new UserRating();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(RatingDataServiceApplication.class, args);
	}

}
