package com.cucumber.TestSteps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import alchemypages.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import frameworkcore.webdriverFactory.DriverManager;

public class TestStepDefinitions {
	
	private static Logger logger = LoggerFactory.getLogger(TestStepDefinitions.class);
	WebDriver driver=null;
	LoginPage loginPage=null;
	
	public TestStepDefinitions() {
		driver = DriverManager.getDriver();
		loginPage = PageFactory.initElements(driver,LoginPage.class);
	}
	
	@Given("^open Gmail$")
	public void open_Gmail(){
		
		logger.info("Open Gmail");
		driver.get("https://accounts.google.com");
	}

	@When("^Login to Gmail$")
	public void login_to_Gmail(){
		
		logger.info("Login to Gmail");
	}
}
