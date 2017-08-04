package com.saurabh.sample.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.saurabh.sample.springmvc.entity.GenreEntity;
import com.saurabh.sample.springmvc.json.object.Books;
import com.saurabh.sample.springmvc.json.object.GenericResponse;
import com.saurabh.sample.springmvc.json.object.Genres;
import com.saurabh.sample.springmvc.service.BooksManagementService;
import com.saurabh.sample.springmvc.service.GenreManagementService;
import com.saurabh.sample.springmvc.util.EntityToJsonGenerator;

@RestController
@RequestMapping(value = "/bms")
public class Controller {

	@Autowired
	private BooksManagementService booksManagementService;

	@Autowired
	private GenreManagementService genreManagementService;

	/*
	 * @RequestMapping(value = "/getMessage/{name}", method = RequestMethod.GET)
	 * public String getMessage(@PathVariable String name, ModelMap model) { String
	 * greet = " Hello !!!" + name + " How are You?"; model.addAttribute("greet",
	 * greet); System.out.println(greet); return greet; }
	 */

	@RequestMapping(value = "/checkServerStatus", method = RequestMethod.GET)
	public String getMessage() {
		String message = "Service Up and Running";
		System.out.println(message);
		return message;
	}

	@RequestMapping(value = "/books", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public GenericResponse createBooks(@RequestBody Books books) {
		long startTime = System.currentTimeMillis();
		booksManagementService.createBooks(books);
		String message = "Books : Creation Successful";
		return getResponse(startTime, message);
	}

	@RequestMapping(value = "/genres", method = RequestMethod.POST)
	public GenericResponse createGenre(@RequestBody Genres genres) {
		long startTime = System.currentTimeMillis();
		genreManagementService.addGenres(genres);
		String message = "Genres : Creation Successful";
		return getResponse(startTime, message);
	}

	@RequestMapping(value = "/genres", method = RequestMethod.DELETE)
	public GenericResponse deleteGenre(@RequestBody Genres genres) {
		long startTime = System.currentTimeMillis();
		genreManagementService.deleteGenres(genres);
		String message = "Genres : Deletion Successful";
		return getResponse(startTime, message);
	}

	@RequestMapping(value = "/genres", method = RequestMethod.GET)
	public Genres getAllGenres() {
		List<GenreEntity> genreEntityList = genreManagementService.getAllGenre();
		return EntityToJsonGenerator.generateGenresJson(genreEntityList);
	}

	private GenericResponse getResponse(Long startTime, String message) {
		GenericResponse genericResponse = new GenericResponse();
		genericResponse.setResultCode("OK-200");
		genericResponse.setResultDescription(message);
		genericResponse.setExecutionTime(new Long(System.currentTimeMillis()- startTime).intValue());
		return genericResponse;
	}

}
