package com.saurabh.sample.springmvc.service;

import java.util.List;

import com.saurabh.sample.springmvc.entity.GenreEntity;
import com.saurabh.sample.springmvc.json.object.Genres;

public interface GenreManagementService {

	GenreEntity addGenres(Genres genres);

	void deleteGenre(Genres genres);

	List<GenreEntity> getAllGenre();

}
