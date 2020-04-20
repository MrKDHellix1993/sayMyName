package io.javarelease.moviecatlogue.api;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
//import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient;

import io.javarelease.moviecatlogue.model.CatlougeItem;
import io.javarelease.moviecatlogue.model.MovieSummary;
import io.javarelease.moviecatlogue.model.Rating;
import io.javarelease.moviecatlogue.model.UserRating;
//import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/getCatalog")
public class MovieCatlogueApi {

	@Autowired
	private RestTemplate restTemp;

	@Autowired
	private WebClient.Builder webClient;

	/* Micro Service with RestTemplate way but it's going to be @Depcrated */
	@RequestMapping("restTemplate/{userId}")
	public ResponseEntity<List<CatlougeItem>> getCatalog(@PathVariable("userId") String userId) {

		/*
		 * Steps to perform
		 * 
		 * 1. get all rated movies IDs 2. for each movie id call movie nfo service & get
		 * details
		 */

		List<Rating> ratingList = null;

		/*
		 * UserRating userRating =
		 * restTemp.getForObject("http://localhost:8083/ratingsdata/users/" + userId,
		 * UserRating.class);
		 */
		UserRating userRating = restTemp.getForObject("http://ratings-data-service/ratingsdata/users/" + userId,
				UserRating.class);
		List<CatlougeItem> catList = null;
		if (null != userRating) {
			ratingList = userRating.getRatingList();
			catList = ratingList.stream().map(rating -> {
				/*
				 * Movie movieObj = restTemp.getForObject("http://localhost:8082/getMovieInfo/"
				 * + rating.getMovieId(), Movie.class);
				 */
				MovieSummary movieObj = restTemp.getForObject(
						"http://movie-info-service/getMovieInfo/" + rating.getMovieId(), MovieSummary.class);
				return new CatlougeItem(movieObj.getTitle(), movieObj.getTagline(), rating.getRating());
			}).collect(Collectors.toList());
		}
		return ResponseEntity.ok(catList);
	}

	/* Micro Service with Web Client way Async RxJava */

	@RequestMapping("webClient/{userId}")
	public ResponseEntity<List<CatlougeItem>> getCatalogWebClient(@PathVariable("userId") String userId) {

		/*
		 * Steps to perform
		 * 
		 * 1. get all rated movies IDs 2. for each movie id call movie nfo service & get
		 * details
		 */

		/*
		 * Rating rating1 = new Rating("100", 8.5); Rating rating2 = new Rating("101",
		 * 7.5); Rating rating3 = new Rating("102", 6.2);
		 * 
		 * List<Rating> ratingList = Arrays.asList(rating1, rating2, rating3);
		 */
		UserRating userRating = webClient.build().get().uri("http://ratings-data-service/ratingsdata/users/" + userId)
				.retrieve().bodyToMono(UserRating.class).block();
		List<Rating> ratingList = null;
		List<CatlougeItem> catList = null;
		if (null != userRating) {
			ratingList = userRating.getRatingList();
			catList = ratingList.stream().map(rating -> {
				MovieSummary movie = webClient.build().get()
						.uri("http://movie-info-service/getMovieInfo/" + rating.getMovieId()).retrieve()
						.bodyToMono(MovieSummary.class).block();
				return new CatlougeItem(movie.getTitle(), movie.getTagline(), rating.getRating());
			}).collect(Collectors.toList());
		}
		return ResponseEntity.ok(catList);
	}

	@RequestMapping(value = "/getMoviePurshaseDetails")
	public ResponseEntity<String> getMoviePurshaseDetails(
			@RequestParam(value = "orderId", required = true) String orderId, @RequestParam(value = "placeOfPurchase", required = false) String placeOfPurchase) {
		if (null != orderId) {
			return ResponseEntity.ok(" Here is your Movie Purshase Details " + placeOfPurchase);
		}
		return ResponseEntity.ok(" Order Id can't be null" + placeOfPurchase);
	}
}
