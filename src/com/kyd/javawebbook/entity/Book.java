package com.kyd.javawebbook.entity;

public class Book {
	private int id;//书的编号
	private String name;//书的名字
	private String author;//书的作者
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
}
