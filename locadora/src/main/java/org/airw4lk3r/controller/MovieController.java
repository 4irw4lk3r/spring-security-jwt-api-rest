package org.airw4lk3r.controller;

import java.util.List;

import org.airw4lk3r.model.Movie;
import org.airw4lk3r.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movie")
public class MovieController {
	
	@Autowired
	MovieService movieService;

	@GetMapping("/findAllAvailable")
	List<Movie> findAllMovieAvailable(){
		return movieService.findAllMovieAvailable();
	}
	
	@GetMapping("/findByTitle/{title}")
	Movie findByTitle(@PathVariable String title) {
		return movieService.findByTitle(title);
	}
	
	@PostMapping("/rent/{id}")
	public void RentAMovie(@PathVariable(value="id") Long id) {
		this.movieService.rentAMovie(id);
	}
	
	@PostMapping("/return/{id}")
	public void ReturnAMovie(@PathVariable(value="id") Long id) {
		this.movieService.returnAMovie(id);
	}
}
