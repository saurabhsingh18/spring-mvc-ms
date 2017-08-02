package com.saurabh.sample.springmvc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PROPERTIES")
public class BookPropertiesEntity {
	
	@Id
	@Column(name= "BOOKID")
	private long bookId;
	
	@Column(name= "STATUS")
	private String status;
	
	@Column(name= "LANGUAGE")
	private String language;
	
	@Column(name= "TYPE")
	private String type;

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
}
