/**
 * Core Framework
 * Author : Deepak Tiwari
 * Creation Date : 27 Apr 2018
 * Modified Date : 
 * Modified By : 
 */
package alchemypages.dashboard;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import frameworkcore.frameworkUtils.UserActions;

public class DashboardPage {
	
/*-----------------------Elements on Login Page ----------------------------*/
	
	@FindBy(xpath = "//i[@class='search icon']")
	public WebElement Icon_MainSearch;
	
	@FindBy(xpath = "//div[@class='ui dropdown topbar-user-menu-container']/i[@class='dropdown icon']")
	public WebElement Icon_UserMenuDropdownRight;
	
	@FindBy(xpath = "//div[@class='item logout' and text()='Signout']")
	public WebElement Link_SignOut;
	
	@FindBy(xpath = "//a/span[text()='Dashboard']")
	public WebElement Lnk_Dashboard;
	
	@FindBy(xpath = "//a/span[text()='Initiatives']")
	public WebElement Lnk_Initiatives;
	
	@FindBy(xpath = "//a/span[text()='Live Media Plans']")
	public WebElement Lnk_LiveMediaPlans;
	
	@FindBy(xpath = "//a/span[text()='Media Plans']")
	public WebElement Lnk_MediaPlans;
	
	@FindBy(xpath = "//a/span[text()='Audiences']")
	public WebElement Lnk_Audiences;
	
	@FindBy(xpath = "//a/span[text()='Offers']")
	public WebElement Lnk_Offers;
	
	@FindBy(xpath = "//a/span[text()='Creative Assets']")
	public WebElement Lnk_CreativeAssets;
	
	@FindBy(xpath = "//a/span[text()='Reports']")
	public WebElement Lnk_Reports;
	
	@FindBy(className = "topbar-user-menu")
	public WebElement TopbarUserMenu;
	
	@FindBy(className = "bell outline icon")
	public WebElement Icon_Bell_Notification;
	
	@FindBy(xpath = "//h3[text()='Pending Tasks']")
	public WebElement Txt_PendingTasks;
	
	@FindBy(xpath = "//table[@class='ui table']//th[text()='Name']")
	public WebElement Txt_PendingTasksColumn_Name;
	
	@FindBy(xpath = "//table[@class='ui table']//th[text()='Budget']")
	public WebElement Txt_PendingTasksColumn_Budget;
	
	@FindBy(xpath = "//table[@class='ui table']//th[text()='Schedule']")
	public WebElement Txt_PendingTasksColumn_Schedule;
	
	@FindBy(xpath = "//table[@class='ui table']//th[text()='Action']")
	public WebElement Txt_PendingTasksColumn_Action;
	
	/*------------------------------Method for Main Landing Page -----------------------------------*/
	
	
	public void VerifyMainMenuItems() {
		 UserActions.VerifyElementIsDisplayed(Lnk_Dashboard);
		 UserActions.VerifyElementIsDisplayed(Lnk_Initiatives);
		 UserActions.VerifyElementIsDisplayed(Lnk_LiveMediaPlans);
		 UserActions.VerifyElementIsDisplayed(Lnk_MediaPlans);
		 UserActions.VerifyElementIsDisplayed(Lnk_Audiences);
		 UserActions.VerifyElementIsDisplayed(Lnk_Offers);
		 UserActions.VerifyElementIsDisplayed(Lnk_CreativeAssets);
		 UserActions.VerifyElementIsDisplayed(Lnk_Reports);
	}
	
	public void Logout() {
		Icon_UserMenuDropdownRight.click();
		Link_SignOut.click();
	}
}
