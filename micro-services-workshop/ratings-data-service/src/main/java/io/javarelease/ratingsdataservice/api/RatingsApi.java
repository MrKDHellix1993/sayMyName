package io.javarelease.ratingsdataservice.api;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.javarelease.ratingsdataservice.model.Rating;
import io.javarelease.ratingsdataservice.model.UserRating;

@RestController
@RequestMapping("/ratingsdata/")
public class RatingsApi {
	
	@Autowired
	private UserRating userRating;

	@RequestMapping("/{movieId}")
	public ResponseEntity<Rating> getCatalog(@PathVariable("movieId") String movieId) {
		return ResponseEntity.ok(new Rating(movieId, 8.5));
	}
	
	@RequestMapping("users/{userId}")
	public ResponseEntity<UserRating> getUserRatings(@PathVariable("userId") String userId){
		Rating rating1 = new Rating("550", 8.5);
		Rating rating2 = new Rating("551", 7.5);
		Rating rating3 = new Rating("552", 6.2);

		List<Rating> ratingList = Arrays.asList(rating1, rating2, rating3);
		userRating.setUserId(userId);
		userRating.setRatingList(ratingList);
		return ResponseEntity.ok(userRating);
	}

}
