package com.pack1;

import java.io.Serializable;

public class BookBean implements Serializable{
	private String BookId;
	private String BookName;
	private String BookAuthor;
	private int price;
	
	
	public BookBean() {}
	public String getBookId() {
		return BookId;
	}
	public void setBookId(String bookId) {
		BookId = bookId;
	}
	public String getBookName() {
		return BookName;
	}
	public void setBookName(String bookName) {
		BookName = bookName;
	}
	public String getBookAuthor() {
		return BookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		BookAuthor = bookAuthor;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "BookBean [BookId=" + BookId + ", BookName=" + BookName + ", BookAuthor=" + BookAuthor + ", price="
				+ price + "]";
	}
	
	
	
	

}
