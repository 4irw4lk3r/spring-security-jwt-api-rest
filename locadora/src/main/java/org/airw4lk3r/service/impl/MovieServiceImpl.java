package org.airw4lk3r.service.impl;

import java.util.List;

import org.airw4lk3r.model.Movie;
import org.airw4lk3r.repository.MovieRepository;
import org.airw4lk3r.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	MovieRepository movieRepository;
	
	@Override
	public void rentAMovie(Long id) {
		 movieRepository.rentAMovie(id);		
	}

	@Override
	public void returnAMovie(Long id) {
		movieRepository.returnAMovie(id);		
	}

	@Override
	public List<Movie> findAllMovieAvailable() {
		return movieRepository.findAllAvaiableMovie();		
	}

	@Override
	public Movie findByTitle(String title) {
		return movieRepository.findByTitle(title);
	}
	
}
