package com.saurabh.sample.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.saurabh.sample.springmvc.json.object.Books;
import com.saurabh.sample.springmvc.service.BooksManagementService;

@RestController
@RequestMapping(value = "/bms", produces = MediaType.APPLICATION_JSON_VALUE)
public class Controller {

	@Autowired
	private BooksManagementService booksManagementService;
	
	@RequestMapping(value = "/getMessage/{name}")
	public String getMessage(@PathVariable String name, ModelMap model) {
		String greet = " Hello !!!" + name + " How are You?";
		model.addAttribute("greet", greet);
		System.out.println(greet);
		return greet;
	}

	@RequestMapping(value = "/books", method = RequestMethod.POST)
	public String createBooks(@RequestBody Books books) {
		booksManagementService.createBooks(books);
		return "Success";
	}

}
