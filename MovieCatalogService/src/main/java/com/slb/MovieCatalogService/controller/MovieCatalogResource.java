package com.slb.MovieCatalogService.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.slb.MovieCatalogService.model.CatalogItem;
import com.slb.MovieCatalogService.model.Movie;
import com.slb.MovieCatalogService.model.UserRating;
import java.util.stream.Stream;

@RestController
public class MovieCatalogResource {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	WebClient.Builder webClientBuilder;
	
	@RequestMapping("/catalog/{userId}")
	List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
		
		UserRating ratings=restTemplate.getForObject("http://rating-data-service/ratings/users/"+userId,UserRating.class);
		
		return ratings.getUserRating().stream().map(rating->{
			Movie movie =restTemplate.getForObject("http://movie-info-service/movies/"+rating.getMovieId(),Movie.class);
			return new CatalogItem(movie.getName(),movie.getDesc(),rating.getRating());
		}).collect(Collectors.toList());
	}
}

//using webclient instead of rest template

//UserRating ratings=webClientBuilder.build()
//	.get()
//	.uri("http://rating-data-service/ratings/users/"+userId)
//	.retrieve()
//	.bodyToMono(UserRating.class)
//	.block();

//Movie movie=webClientBuilder.build()
//	.get()
//	.uri("http://movie-info-service/movies/"+rating.getMovieId())
//	.retrieve()
//	.bodyToMono(Movie.class)
//	.block();