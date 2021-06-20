package com.daniel.model;

import java.util.Date;

public class User {

	private int userid;
	private String id;
	private String pw;
	private String name;
	private Date dob;
	private String address;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", id=" + id
				+ ", pw=" + pw + ", name=" + name 
				+ ", dob=" + dob + ", address=" + address + "]";
	}
	
}
