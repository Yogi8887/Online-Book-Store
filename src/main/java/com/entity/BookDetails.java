package com.entity;

public class BookDetails {
	private int bookId;
	private String bookname;
	private String author;
	private String price;
	private String photo;
	
	
	public BookDetails() {
		super();
	}
	public BookDetails(String bookname, String author, String price, String photo) {
		super();
		this.bookname = bookname;
		this.author = author;
		this.price = price;
		this.photo = photo;
	}
	public BookDetails(int bookId, String bookname, String author, String price, String photo) {
		super();
		this.bookId = bookId;
		this.bookname = bookname;
		this.author = author;
		this.price = price;
		this.photo = photo;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	@Override
	public String toString() {
		return "BookDetails [bookId=" + bookId + ", bookname=" + bookname + ", author=" + author + ", price=" + price
				+ ", photo=" + photo + "]";
	}
	
	
	
}
