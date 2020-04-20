package io.javarelease.movieinfoservice.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import io.javarelease.movieinfoservice.model.MovieSummary;

@RestController
@RequestMapping("/getMovieInfo")
public class MovieInfoServiceApi {
	
	@Value("${api_key}")
	private String apiKey;
	
	@Value("${api_url}")
	private String apiUrl;
	
	@Autowired
	private RestTemplate restTemp;

	@RequestMapping("/{movieId}")
	public ResponseEntity<MovieSummary> getCatalog(@PathVariable("movieId") String movieId) {
		String movieDBUrl = apiUrl+ movieId + "?api_key=" + apiKey;
		MovieSummary movieSummary = restTemp.getForObject(movieDBUrl, MovieSummary.class);
		return ResponseEntity.ok(movieSummary);
	}

}
