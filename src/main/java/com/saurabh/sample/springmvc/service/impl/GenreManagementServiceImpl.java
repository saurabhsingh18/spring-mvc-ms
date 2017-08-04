package com.saurabh.sample.springmvc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saurabh.sample.springmvc.dao.GenresRepository;
import com.saurabh.sample.springmvc.entity.GenreEntity;
import com.saurabh.sample.springmvc.json.object.Genre;
import com.saurabh.sample.springmvc.json.object.Genres;
import com.saurabh.sample.springmvc.service.GenreManagementService;
import com.saurabh.sample.springmvc.util.JsonToEntityGenerator;

@Service
public class GenreManagementServiceImpl implements GenreManagementService {

	@Autowired
	private GenresRepository genresRepository;

	@Override
	public List<GenreEntity> addGenres(Genres genres) {
		List<GenreEntity> genreEntityList = genresRepository
				.save(JsonToEntityGenerator.generateGenreEntityList(genres));
		return genreEntityList;
	}

	@Override
	public void deleteGenres(Genres genres) {
		List<String> genreNames = new ArrayList<>();
		for (Genre genre : genres.getGenres()) {
			genreNames.add(genre.getName());
		}
		List<GenreEntity> genreEntityList = genresRepository.findByGenreName(genreNames);
		genresRepository.delete(genreEntityList);
	}

	@Override
	public List<GenreEntity> getAllGenre() {
		return genresRepository.findAll();
	}

}
