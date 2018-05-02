package com.example.demosleuth;

import org.springframework.stereotype.Component;

@Component
public class DemoRepository {

	public String returnStatus() {
		return "Ping Success";
	}

	
}
