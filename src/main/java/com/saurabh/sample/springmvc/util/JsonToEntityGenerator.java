package com.saurabh.sample.springmvc.util;

import java.util.ArrayList;
import java.util.List;

import com.saurabh.sample.springmvc.entity.BookEntity;
import com.saurabh.sample.springmvc.json.object.Book;
import com.saurabh.sample.springmvc.json.object.Books;

public class JsonToEntityGenerator {

	public static BookEntity generateBookEntity(Book book) {
		BookEntity bookEntity = new BookEntity();
		return bookEntity;
	}

	public static List<BookEntity> generateBookEntityList(Books books) {
		List<BookEntity> booksEntityList = new ArrayList<>();
		for (Book book : books.getBooks()) {
			booksEntityList.add(generateBookEntity(book));
		}
		return booksEntityList;
	}

}
