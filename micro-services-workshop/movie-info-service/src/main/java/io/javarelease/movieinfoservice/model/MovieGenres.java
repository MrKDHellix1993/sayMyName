package io.javarelease.movieinfoservice.model;

public class MovieGenres {

	private String id;
	private String name;
	
	
	public MovieGenres() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MovieGenres(String movieId, String movieName) {
		super();
		this.id = movieId;
		this.name = movieName;
	}
	public String getMovieId() {
		return id;
	}
	public void setMovieId(String movieId) {
		this.id = movieId;
	}
	public String getMovieName() {
		return name;
	}
	public void setMovieName(String movieName) {
		this.name = movieName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MovieGenres other = (MovieGenres) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	/*
	 * public CatlougeItem() { }
	 */

}
