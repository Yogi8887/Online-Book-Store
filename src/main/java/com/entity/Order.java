package com.entity;

public class Order {
	private int id;
	private int orderid;
	private String customerName;
	private String bookName;
	private String address;
	private String price;
	
	
	public Order() {
		super();
	}
	

	public Order(int orderid, String customerName, String bookName, String address, String price) {
		super();
		this.orderid = orderid;
		this.customerName = customerName;
		this.bookName = bookName;
		this.address = address;
		this.price = price;
	}


	public Order(int id, int orderid, String customerName, String bookName, String address, String price) {
		super();
		this.id = id;
		this.orderid = orderid;
		this.customerName = customerName;
		this.bookName = bookName;
		this.address = address;
		this.price = price;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getOrderid() {
		return orderid;
	}


	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getBookName() {
		return bookName;
	}


	public void setBookName(String bookName) {
		this.bookName = bookName;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}
		
	

}
