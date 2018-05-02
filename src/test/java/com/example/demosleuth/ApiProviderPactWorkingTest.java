package com.example.demosleuth;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
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
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, properties = { "server.port=8080" })
public class ApiProviderPactWorkingTest {

	@TestTarget
	public final Target target = new HttpTarget(8080);
	private static ConfigurableApplicationContext application;

	@BeforeClass
	public static void startSpring() {
		application = SpringApplication.run(MainApp.class);
	}

	@State({ "default" })
	public void toCreatePersonState() {
	}
}