package com.example.demosleuth;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Rule;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;

public class ApiConsumerPactPOSTVerificationTest {
	
    @Rule
    public PactProviderRuleMk2 provider = new PactProviderRuleMk2("phx-create-ev-svc-provider", "localhost", 8080, this);
    
    @Pact(provider = "phx-create-ev-svc-provider", consumer = "lca-touch-create-consumer")
    public RequestResponsePact createFragment(PactDslWithProvider builder) {
        Map<String, String> headers = new HashMap<>();
        headers.put("content-type", "application/json");

        
        return builder
                .given("default")
                .uponReceiving("Create User Request")
                .path("/create")
                .method("POST")
                .headers(headers)
                .body("{ \"id\" : \"100\",     \"name\" : \"Pijush\" }")
                .willRespondWith()
                .status(200)
                .headers(headers)
                .body("{ \"id\" : \"100\",     \"name\" : \"ServiceName\" }")
                .toPact();
    }
    
    @Test
    @PactVerification("phx-create-ev-svc-provider")
    public void runTest() throws IOException {
        final RestTemplate call = new RestTemplate();
         
        User body = new User();
        body.setId("100");
        body.setName("Pijush");
        
        HttpEntity<User> entity = new HttpEntity<User>(body);
        
        
        call.exchange(provider.getConfig().url()+"/create", 
        		HttpMethod.POST,  
        		entity, 
        		User.class);
    }
}
