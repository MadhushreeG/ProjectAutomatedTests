/**
 * Core Framework
 * Author : Deepak Tiwari
 * Creation Date : 27 Apr 2018
 * Modified Date : 
 * Modified By : 
 */
package alchemypages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import frameworkcore.frameworkUtils.UserActions;

public class LoginPage {
	
	
	/*-----------------------Elements on Login Page ----------------------------*/
	
	@FindBy(xpath = "//input[@placeholder='Username']")
	public static WebElement TxtBox_UserName;
	
	@FindBy(xpath = "//input[@placeholder='Password']")
	public WebElement TxtBox_Password;
	
	@FindBy(xpath = "//button[contains(@class,'login-button')]")
	public WebElement Btn_Login;
	
	@FindBy(xpath = "//img[@src='/logo.png']")
	public WebElement Img_AlchemyLogo;
	
	@FindBy(xpath = "//a[text()='Forgot Password ?']")
	public WebElement Link_ForgotPassword;
	
	@FindBy(xpath = "//p[@class='error' and text()='Invalid Username/Password']")
	public WebElement Txt_InvalidLoginMessage;
	
	/*------------------------------Method for Login Page -----------------------------------*/
	
	public void VerifyLoginPageItems() {
		 UserActions.VerifyElementIsDisplayed(TxtBox_UserName);
		 UserActions.VerifyElementIsDisplayed(TxtBox_Password);
		 UserActions.VerifyElementIsDisplayed(Btn_Login);
		 UserActions.VerifyElementIsDisplayed(Img_AlchemyLogo);
		 UserActions.VerifyElementIsDisplayed(Link_ForgotPassword);
	}
	 
	 public void Login(String UserName, String Password) {
		 UserActions.SetText(TxtBox_UserName, UserName);
		 UserActions.SetText(TxtBox_Password, Password);
		 Btn_Login.click();
	 }
	
	 
	 
}
