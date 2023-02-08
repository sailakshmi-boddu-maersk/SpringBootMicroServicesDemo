package com.slb.RatingService.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slb.RatingService.model.Rating;
import com.slb.RatingService.model.UserRating;

@RestController
@RequestMapping("/ratings")
public class RatingResource {
	
	@RequestMapping("/{movieId}")
	public Rating getRating(@PathVariable("movieId")String movieId) {
		return new Rating(movieId,4);
	}

	@RequestMapping("users/{userId}")
	public UserRating getAllRatings(String userIdId) {
		List<Rating> ratingList =new ArrayList<>();
		ratingList.add(new Rating("8048",4));
		ratingList.add(new Rating("8050",3));
		UserRating userRating=new UserRating();
		userRating.setUserRating(ratingList);
		return userRating;
	}
}
