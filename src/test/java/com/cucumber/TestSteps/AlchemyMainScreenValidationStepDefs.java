/**
 * Core Framework
 * Author : Deepak Tiwari
 * Creation Date : 27 Apr 2018
 * Modified Date : 
 * Modified By : 
 */
package com.cucumber.TestSteps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import com.cucumber.listener.Reporter;
import alchemypages.LoginPage;
import alchemypages.DashboardPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import frameworkcore.excelReader.InputDataReaderImpl;
import frameworkcore.frameworkUtils.UserActions;
import frameworkcore.webdriverFactory.DriverManager;

public class AlchemyMainScreenValidationStepDefs {
	
	private static Logger logger = LoggerFactory.getLogger(TestStepDefinitions.class);
	WebDriver driver=null;
	LoginPage loginPage=null;
	DashboardPage mainLandingPage = null;
	
	public AlchemyMainScreenValidationStepDefs() {
		driver = DriverManager.getDriver();
		loginPage = PageFactory.initElements(driver,LoginPage.class);
		mainLandingPage = PageFactory.initElements(driver,DashboardPage.class);
	}
	
	@Given("^open ApplicationUrl$")
	public void open_ApplicationUrl(){
		String AppUrl = InputDataReaderImpl.GetDataValue("Environment_Config.AppUrl.URL");
		logger.info("Launch Website -- " + AppUrl);
		Reporter.addStepLog("Launching Website -- " + AppUrl);
		driver.get(AppUrl);
		
		if(UserActions.VerifyElementIsPresent(loginPage.Img_AlchemyLogo)) {
			logger.info("Pass!!! Application is Launched Successfully");
			Reporter.addStepLog("Pass!!! Application is Launched Successfully");
			Assert.assertTrue(true);
			}
		else {
			logger.info("Fail!!! User Logged out");
			Reporter.addStepLog("Fail!!! Application is Launched Successfully");
			Assert.assertTrue(false);
		}
	}
	

	@When("^Login to Website with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void login_to_Website_with_and(String UserName, String Password)  {
		logger.info("Entering User Name" + UserName + " and Password " + Password + "to Login");
		Reporter.addStepLog("Entering User Name --  " + InputDataReaderImpl.GetDataValue(UserName) + " and Password --  " + InputDataReaderImpl.GetDataValue(Password) + "to Login");
		loginPage.Login(InputDataReaderImpl.GetDataValue(UserName),InputDataReaderImpl.GetDataValue(Password));
	}

	@Then("^Validate Login is \"([^\"]*)\"$")
	public void validate_Login_is(String LoginStatus) {
		
		if(InputDataReaderImpl.GetDataValue(LoginStatus).equalsIgnoreCase("Pass")) 
		{
			if(UserActions.VerifyElementIsPresent(mainLandingPage.Icon_MainSearch)) 
				{
					logger.info("Login Successful");
					Reporter.addStepLog("Login Successful");
					Assert.assertTrue(true);
				}else
				{
					logger.info("Login Failed");
					Reporter.addStepLog("Login Failed");
					Assert.assertTrue(false);
				}
		}else if(InputDataReaderImpl.GetDataValue(LoginStatus).equalsIgnoreCase("Fail")) 
		{
			if(UserActions.VerifyElementIsPresent(loginPage.Txt_InvalidLoginMessage)) 
			{
				logger.info("Pass!!! User should not be allowed to Login");
				Reporter.addStepLog("Pass!!! User should not be allowed to Login");
				Assert.assertTrue(true);
			}else
			{
				logger.info("Fail!!! User is not allowed to Login");
				Reporter.addStepLog("Fail!!! User is not allowed to Login");
				Assert.assertTrue(false);
			}
		}
	}
	
	@Then("^Logout of the Website \"([^\"]*)\"$")
	public void logout_of_the_Website(String LoginStatus) throws Throwable {
		if(InputDataReaderImpl.GetDataValue(LoginStatus).equalsIgnoreCase("Pass"))
			mainLandingPage.Logout();
		
		if(UserActions.VerifyElementIsPresent(loginPage.Btn_Login)) {
			logger.info("Pass!!! User Logged out");
			Reporter.addStepLog("Pass!!! User Logged out");
			Assert.assertTrue(true);
			}
		else if(UserActions.VerifyElementIsPresent(mainLandingPage.Icon_MainSearch)) {
			logger.info("Fail!!! User still logged in");
			Reporter.addStepLog("Fail!!! User still logged in");
			Assert.assertTrue(false);
		}
		
	}
	
}
