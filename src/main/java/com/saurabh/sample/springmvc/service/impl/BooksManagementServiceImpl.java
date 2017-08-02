package com.saurabh.sample.springmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saurabh.sample.springmvc.dao.BooksRepository;
import com.saurabh.sample.springmvc.entity.BookEntity;
import com.saurabh.sample.springmvc.json.object.Books;
import com.saurabh.sample.springmvc.service.BooksManagementService;
import com.saurabh.sample.springmvc.util.JsonToEntityGenerator;

@Service
public class BooksManagementServiceImpl implements BooksManagementService {

	@Autowired
	private BooksRepository booksRepository;
	
	@Override
	public void createBooks(Books books) {
		List<BookEntity> booksEntityList = JsonToEntityGenerator.generateBookEntityList(books);
		booksRepository.save(booksEntityList);
	}

}
