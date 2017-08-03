package com.saurabh.sample.springmvc.util;

import java.util.List;

import com.saurabh.sample.springmvc.entity.GenreEntity;
import com.saurabh.sample.springmvc.json.object.Genre;
import com.saurabh.sample.springmvc.json.object.Genres;

public class EntityToJsonGenerator {

	public static Genre generateGenreJson(GenreEntity genreEntity) {
		Genre genre = new Genre();
		genre.setName(genreEntity.getGenreName());
		return genre;
	}

	public static Genres generateGenresJson(List<GenreEntity> genreEntityList) {
		Genres genres = new Genres();
		for (GenreEntity genreEntity : genreEntityList) {
			genres.getGenres().add(generateGenreJson(genreEntity));
		}
		return genres;
	}

}
