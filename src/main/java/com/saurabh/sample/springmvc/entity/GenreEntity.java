package com.saurabh.sample.springmvc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GENRE")
public class GenreEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "GENREID")
	private long genreId;

	@Column(name = "GENRENAME")
	private String genreName;

	public long getGenreId() {
		return genreId;
	}

	public void setGenreId(long genreId) {
		this.genreId = genreId;
	}

	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}

}
