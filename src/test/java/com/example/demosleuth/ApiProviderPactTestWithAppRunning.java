package com.example.demosleuth;

import org.junit.runner.RunWith;

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
public class ApiProviderPactTestWithAppRunning {

	@TestTarget
	public final Target target = new HttpTarget(8080);
 
	@State({ "default" })
	public void toCreatePersonState() {}
}