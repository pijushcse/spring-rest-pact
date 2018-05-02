package com.example.demosleuth;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EligibilityServiceController {

	//@Autowired
	DemoRepository dpr = new DemoRepository();

	@GetMapping("/test/{id}")
	public @ResponseBody String getTest(@PathVariable("id") Integer id) throws InterruptedException {

		System.out.println("Request received id- " + id + ", at- " + new Date().toString());
		Thread.sleep(3000);
		return "Ping Success!! " + new Date().toString();
	}

	@GetMapping(path = "/eligibility", produces = "application/json")
	public @ResponseBody String getPactTest() {
		System.out.println("Request Received.");

		return "{\"status\": \"" + dpr.returnStatus() + "\" } ";
	}

}
