package org.airw4lk3r.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.airw4lk3r.model.Movie;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, Long> {
	
	Movie findByTitle(String title);
	
	@Transactional
	@Modifying
	@Query("update Movie m set m.numberOfCopiesAvailable = m.numberOfCopiesAvailable - 1 where m.id = :id")
	void rentAMovie(Long id);
	
	@Transactional
	@Modifying
	@Query("update Movie m set m.numberOfCopiesAvailable = m.numberOfCopiesAvailable + 1 where m.id = :id")
	void returnAMovie(Long id);
	
	@Query("from Movie m where m.numberOfCopiesAvailable > 0")
	List<Movie> findAllAvaiableMovie();

}
