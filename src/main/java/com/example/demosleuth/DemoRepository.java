package com.example.demosleuth;

import javax.annotation.PostConstruct;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class DemoRepository {
	
	@PostConstruct
	public void init() {
		System.out.println("Creating Demo Repository");
	}

	public String returnStatus() {
		return "Ping Success";
	}

	public User createUser(User u) {
		u.setName("ServiceName");
		return u;
	}

	
}
