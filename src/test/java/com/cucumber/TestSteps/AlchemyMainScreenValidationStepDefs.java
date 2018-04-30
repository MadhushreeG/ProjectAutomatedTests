package com.cucumber.TestSteps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.AssertJUnit;
import alchemypages.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import frameworkcore.webdriverFactory.DriverManager;

public class AlchemyMainScreenValidationStepDefs {
	
	private static Logger logger = LoggerFactory.getLogger(TestStepDefinitions.class);
	WebDriver driver=null;
	LoginPage loginPage=null;
	
	public AlchemyMainScreenValidationStepDefs() {
		driver = DriverManager.getDriver();
		loginPage = PageFactory.initElements(driver,LoginPage.class);
	}
	
	@Given("^open Alchemy$")
	public void open_Alchemy(){
		logger.info("Launch Alchemy Website");
		driver.get("https://alchemy-marketing-app-qa.gale.agency/login");
	}
	
	@When("^Login to Alchemy$")
	public void login_to_Alchemy(){
		logger.info("Login to Alchemy with valid user name and password");
		loginPage.Login("asfasf","asfasf");
	}
	
	@Then("^Login Successful$")
	public void login_Successful(){
		logger.info("Login Successful");
		AssertJUnit.assertTrue("This Step Failed", false);
	}
}
