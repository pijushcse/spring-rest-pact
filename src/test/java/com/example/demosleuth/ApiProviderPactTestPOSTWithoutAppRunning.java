package com.example.demosleuth;

import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
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
@Provider("phx-create-ev-svc-provider")
@PactFolder("C:\\Users\\Debnatp\\Downloads\\demo-sleuth\\")
public class ApiProviderPactTestPOSTWithoutAppRunning {
	
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
		User u = new User();
		u.setId("100");
		u.setName("ServiceName");
		when(dpr.createUser(Matchers.any())).thenReturn(u);
	}
	
	@State({ "default" })
	public void toCreatePersonState() {
		
	}
}