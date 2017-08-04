package com.saurabh.sample.springmvc.util;

import java.util.ArrayList;
import java.util.List;

import com.saurabh.sample.springmvc.entity.BookEntity;
import com.saurabh.sample.springmvc.entity.GenreEntity;
import com.saurabh.sample.springmvc.entity.StaffEntity;
import com.saurabh.sample.springmvc.json.object.Book;
import com.saurabh.sample.springmvc.json.object.Books;
import com.saurabh.sample.springmvc.json.object.Genre;
import com.saurabh.sample.springmvc.json.object.Genres;
import com.saurabh.sample.springmvc.json.object.Staff;
import com.saurabh.sample.springmvc.json.object.StaffMembers;

public class JsonToEntityGenerator {

	public static BookEntity generateBookEntity(Book book) {
		BookEntity bookEntity = new BookEntity();
		// bookEntity.setBookId(bookId);
		bookEntity.setTitle(book.getTitle());
		bookEntity.setAuthor(book.getAuthor());
		bookEntity.setPrice(book.getPrice());
		bookEntity.setTags(book.getTags());
		return bookEntity;
	}

	public static List<BookEntity> generateBookEntityList(Books books) {
		List<BookEntity> booksEntityList = new ArrayList<>();
		for (Book book : books.getBooks()) {
			booksEntityList.add(generateBookEntity(book));
		}
		return booksEntityList;
	}

	public static GenreEntity generateGenreEntity(Genre genre) {
		GenreEntity genreEntity = new GenreEntity();
		// genreEntity.setGenreId(genreId);
		genreEntity.setGenreName(genre.getName());
		return genreEntity;
	}

	public static List<GenreEntity> generateGenreEntityList(Genres genres) {
		List<GenreEntity> genreEntityList = new ArrayList<>();
		for (Genre genre : genres.getGenres()) {
			genreEntityList.add(generateGenreEntity(genre));
		}
		return genreEntityList;
	}

	public static StaffEntity generateStaffEntity(Staff staff) {
		StaffEntity staffEntity = new StaffEntity();
		// staffEntity.setStaffId(staffId);
		staffEntity.setName(staff.getName());
		staffEntity.setRole(staff.getRole());
		staffEntity.setAddress(staff.getAddress());
		staffEntity.setContactNumber(staff.getContactnumber());
		return staffEntity;
	}

	public static List<StaffEntity> generateStaffEntityList(StaffMembers staffMembers) {
		List<StaffEntity> staffEntityList = new ArrayList<>();
		for (Staff staff : staffMembers.getStaffmembers()) {
			staffEntityList.add(generateStaffEntity(staff));
		}
		return staffEntityList;
	}

}
