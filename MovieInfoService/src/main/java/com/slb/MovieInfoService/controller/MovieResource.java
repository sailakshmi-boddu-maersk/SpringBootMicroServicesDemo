package com.slb.MovieInfoService.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slb.MovieInfoService.model.Movie;

@RestController
public class MovieResource {
	
	@RequestMapping("/movies/{movieId}")
	public Movie getMovieInfo(@PathVariable("movieId") String movieId) {
		return new Movie(movieId,"moviename","desc1");
	}
	
}
