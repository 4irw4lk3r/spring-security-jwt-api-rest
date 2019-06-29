package org.airw4lk3r.service;

import java.util.List;

import org.airw4lk3r.model.Movie;
import org.springframework.stereotype.Service;

@Service
public interface MovieService {
	void rentAMovie(Long id);

	void returnAMovie(Long id);

	List<Movie> findAllMovieAvailable();

	Movie findByTitle(String title);
}
