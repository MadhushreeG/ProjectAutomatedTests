package alchemypages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	/*-----------------------Elements on Login Page ----------------------------*/
	
	@FindBy(xpath = "//input[@placeholder='Username']")
	protected WebElement TxtBox_UserName;
	
	@FindBy(xpath = "//input[@placeholder='Password']")
	protected WebElement TxtBox_Password;
	
	@FindBy(xpath = "//button[contains(@class,'login-button')]")
	protected WebElement Btn_Login;
	
	@FindBy(xpath = "//img[@src='/logo.png']")
	protected WebElement Img_AlchemyLogo;
	
	@FindBy(xpath = "//a[text()='Forgot Password ?']")
	protected WebElement Link_ForgotPassword;
	
	/*------------------------------Method for Login Page -----------------------------------*/
	// methods to operate on page elements
	
	
	private void enterUserName(String username) {
		TxtBox_UserName.sendKeys(username);
	}
	private void enterPassword(String password) {
		TxtBox_Password.sendKeys(password);
	}
	private void clickOnLoginButton() {
		Btn_Login.click();
		}
	 
	 public void Login(String UserName, String Password) {
		 enterUserName(UserName);
		 enterPassword(Password);
		 clickOnLoginButton();
	 }
	 
	
	
}
