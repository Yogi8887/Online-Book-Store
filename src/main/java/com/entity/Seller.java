package com.entity;

public class Seller {
	private int id;
	private String name;
	private String email;
	private String phno;
	private String password;
	
	
	public Seller() {
		super();
	}
	public Seller(String name, String email, String phno, String password) {
		super();
		this.name = name;
		this.email = email;
		this.phno = phno;
		this.password = password;
	}
	public Seller(int id, String name, String email, String phno, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phno = phno;
		this.password = password;
	}
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhno() {
		return phno;
	}
	public void setPhno(String phno) {
		this.phno = phno;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Seller [id=" + id + ", name=" + name + ", email=" + email + ", phno=" + phno + ", password=" + password
				+ "]";
	}

}
