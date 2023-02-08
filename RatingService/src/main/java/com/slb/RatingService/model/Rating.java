package com.slb.RatingService.model;

public class Rating {

	String movieId;
	int Rating;
	
	public Rating() {
		super();
	}

	public Rating(String movieId, int rating) {
		super();
		this.movieId = movieId;
		Rating = rating;
	}
	
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public int getRating() {
		return Rating;
	}
	public void setRating(int rating) {
		Rating = rating;
	}
	
	
}
