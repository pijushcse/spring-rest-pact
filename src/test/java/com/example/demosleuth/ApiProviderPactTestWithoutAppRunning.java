package com.example.demosleuth;

import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.RestPactRunner;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;

@RunWith(RestPactRunner.class)
@Provider("phx-ev-svc-provider")
@PactFolder("C:\\Users\\Debnatp\\Downloads\\demo-sleuth\\")
public class ApiProviderPactTestWithoutAppRunning {
	
	@Mock
	DemoRepository dpr;
	
	@InjectMocks
	EligibilityServiceController svc;

	@TestTarget
	public final Target target = new HttpTarget(8080);
 
	private static ConfigurableApplicationContext application;

	@BeforeClass
	public static void startSpring() {
		application = SpringApplication.run(MainApp.class);
	}

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		when(dpr.returnStatus()).thenReturn("Ping success2");
	}
	
	@State({ "default" })
	public void toCreatePersonState() {
		
	}
}