package com.saurabh.sample.springmvc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BOOKS")
public class BookEntity {

	/** bookId */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BOOKID")
	private long bookId;

	// @Column(name= "TITLE", nullable = false, unique = true, length = 15)
	// @Column(name= "AUTHOR", precision = 1, scale = 0)
	@Column(name = "TITLE")
	private String title;

	@Column(name = "AUTHOR")
	private String author;

	@Column(name = "PRICE")
	private long price;

	@Column(name = "TAGS")
	private String tags;

/*	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	private BookPropertiesEntity properties;*/

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

/*	public BookPropertiesEntity getProperties() {
		return properties;
	}

	public void setProperties(BookPropertiesEntity properties) {
		this.properties = properties;
	}*/

}
