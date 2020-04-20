package io.batch.multithreading.batchmultithreadingservice.model;

import java.util.List;

public class MovieSummary {

	private Integer id;
	private String title;
	private String original_language;
	private String release_date;
	private String revenue;
	private String imdb_id;
	private String popularity;
	private String tagline;
	private List<MovieGenres> genres;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getOriginal_language() {
		return original_language;
	}
	public void setOriginal_language(String original_language) {
		this.original_language = original_language;
	}
	public String getRelease_date() {
		return release_date;
	}
	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}
	public String getRevenue() {
		return revenue;
	}
	public void setRevenue(String revenue) {
		this.revenue = revenue;
	}
	public String getImdb_id() {
		return imdb_id;
	}
	public void setImdb_id(String imdb_id) {
		this.imdb_id = imdb_id;
	}
	public String getPopularity() {
		return popularity;
	}
	public void setPopularity(String popularity) {
		this.popularity = popularity;
	}
	public String getTagline() {
		return tagline;
	}
	public void setTagline(String tagline) {
		this.tagline = tagline;
	}
	public List<MovieGenres> getGenres() {
		return genres;
	}
	public void setGenres(List<MovieGenres> genres) {
		this.genres = genres;
	}
	@Override
	public String toString() {
		return "MovieSummary [id=" + id + ", title=" + title + ", original_language=" + original_language
				+ ", release_date=" + release_date + ", revenue=" + revenue + ", imdb_id=" + imdb_id + ", popularity="
				+ popularity + ", tagline=" + tagline + ", genres=" + genres + "]";
	}
}
