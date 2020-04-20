package io.javarelease.moviecatlogue.model;

import java.util.List;



public class UserRating {

	private String userId;
	private List<Rating> ratingList;
	public UserRating() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserRating(String userId, List<Rating> ratingList) {
		super();
		this.userId = userId;
		this.ratingList = ratingList;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public List<Rating> getRatingList() {
		return ratingList;
	}
	public void setRatingList(List<Rating> ratingList) {
		this.ratingList = ratingList;
	}
	
	
	
}
