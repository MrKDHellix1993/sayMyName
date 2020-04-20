package io.javarelease.moviecatlogue.model;

public class CatlougeItem {

	private String name;
	private String desc;
	private double ratings;

	/*
	 * public CatlougeItem() { }
	 */

	public CatlougeItem(String name, String desc, double ratings) {
		super();
		this.name = name;
		this.desc = desc;
		this.ratings = ratings;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public double getRatings() {
		return ratings;
	}

	public void setRatings(double ratings) {
		this.ratings = ratings;
	}


}
