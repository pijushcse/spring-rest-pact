package com.example.demosleuth;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class User {

	private String name;
	private String id;
	
	public User() {
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	} 
	
	@Override
	public String toString() {
		ObjectMapper m = new ObjectMapper();
		try {
			return m.writeValueAsString(this);
		} catch (JsonProcessingException e) {
		}
		return null;
	}
}
