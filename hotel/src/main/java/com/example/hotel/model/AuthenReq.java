package com.example.hotel.model;

//searialize - changr to byte to have copy of a obj to save the state of obj in a file
public class AuthenReq {
	
	//here create a list of alll users from db
	//create a method to get all the users...and this method is later called in thr controller
	private String name;
	private String password;
	
	
	public AuthenReq() {
		
	}


	public AuthenReq(String name,String password) {
		this.setName(name);
		this.setPassword(password);
	}


	public String getUsername() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
}
