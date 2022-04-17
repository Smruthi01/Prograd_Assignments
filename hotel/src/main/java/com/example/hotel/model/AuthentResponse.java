package com.example.hotel.model;

public class AuthentResponse {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String jwt;
	public AuthentResponse(String jwt) {
		this.jwt = jwt;
	}
	public String getJwt() {
		return jwt;
	}
}
