package org.airw4lk3r.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "movies")
public class Movie {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(length=60)
	private String title;
	
	@Column(length=60)
	private String directorName;
	
	@NotNull
	private Integer numberOfCopiesMax;
		
	@NotNull
	private Integer numberOfCopiesAvailable;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDirectorName() {
		return directorName;
	}

	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}

	public Integer getNumberOfCopiesMax() {
		return numberOfCopiesMax;
	}

	public void setNumberOfCopiesMax(Integer numberOfCopiesMax) {
		this.numberOfCopiesMax = numberOfCopiesMax;
	}

	public Integer getNumberOfCopiesAvailable() {
		return numberOfCopiesAvailable;
	}

	public void setNumberOfCopiesAvailable(Integer numberOfCopiesAvailable) {
		this.numberOfCopiesAvailable = numberOfCopiesAvailable;
	}
	

}
