package com.kyd.javawebbook.entity;

import java.util.List;

public class BookBean {

	private String total;
	private List<Book> books;
	
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
}

