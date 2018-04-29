package com.cucumber.TestSteps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.AssertJUnit;

import com.cucumber.Test.TestRunnerA;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import frameworkcore.webdriverFactory.DriverManager;

public class TestStepDefinitions {
	
	private static Logger logger = LoggerFactory.getLogger(TestStepDefinitions.class);
	
	
	@Given("^open Yahoo$")
	public void open_Yahoo(){
		logger.info("Open Google");
		DriverManager.getDriver().get("https://google.com");
	}

	@When("^Login to Yahoo$")
	public void login_to_Yahoo(){
		logger.info("Login to Google");
	}
	
	@Given("^open Gmail$")
	public void open_Gmail(){
		
		logger.info("Open Gmail");
		DriverManager.getDriver().get("https://accounts.google.com");
	}

	@When("^Login to Gmail$")
	public void login_to_Gmail(){
		
		logger.info("Login to Gmail");
	}

	@Then("^Login Successful$")
	public void login_Successful(){
		logger.info("Login Successful");
		AssertJUnit.assertTrue("This Step Failed", false);
	}
	
	
	
}
