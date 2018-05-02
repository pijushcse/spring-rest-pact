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

public class ApiConsumerPactVerificationTest {
	
    @Rule
    public PactProviderRuleMk2 provider = new PactProviderRuleMk2("phx-ev-svc-provider", "localhost", 8080, this);
    
    @Pact(provider = "phx-ev-svc-provider", consumer = "lca-touch-consumer")
    public RequestResponsePact createFragment(PactDslWithProvider builder) {
        Map<String, String> headers = new HashMap<>();
        headers.put("content-type", "application/json");

        
        return builder
                .given("default")
                .uponReceiving("P")
                .path("/eligibility")
                .method("GET")
                .willRespondWith()
                .status(200)
                .headers(headers)
                .body("{ \"status\": \"Ping Success\" } ")
                .toPact();
    }

    @Test
    @PactVerification("phx-ev-svc-provider")
    public void runTest() throws IOException {
        final RestTemplate call = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);               
        
        call.exchange(provider.getConfig().url()+"/eligibility", 
        		HttpMethod.GET,  
        		entity, 
        		String.class);
    }
}
