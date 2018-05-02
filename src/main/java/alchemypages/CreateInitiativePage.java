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

public class CreateInitiativePage {
	
/*-----------------------Elements on Login Page ----------------------------*/
	
	@FindBy(xpath = "//input[@placeholder='Username']")
		public static WebElement TxtBox_UserName;
	
	@FindBy(xpath = "//a[contains(text(), 'Create New Initiative')]")
		public static WebElement Btn_CreateNewInitiative;
			
	@FindBy(xpath = "//input[@name='name']")
		public static WebElement TxtBox_NewInitiativeName ;
			
	@FindBy(xpath = "//a[text()='Liquidate Inventory']")
			public static WebElement Btn_LiquidateInventory ;
			
	@FindBy(xpath = "//a[text()='Drive Promotion/Awareness']")
			public static WebElement Btn_DrivePromotionAwareness;
			
	@FindBy(xpath = "//button[text()='Add']")
			public static WebElement Btn_AddKPI;
			
	@FindBy(xpath = "//div[@class='goals-builder-container']//i[@class='dropdown icon']")
			public static WebElement DropDown_SelectKPI;
			
	@FindBy(xpath = "//div[@class='goals-builder-container']//div/input[@type='text']")
			public static WebElement TxtBox_KPIText;
	
	@FindBy(xpath = "//div[@class='goals-builder-container']//i[@class='close icon']")
			public static WebElement Btn_RemoveKPI;
			
	@FindBy(xpath = "//div[@class='goals-builder-container']//span[@class='text' and contains(text(),'Traffic/Views')]")
			public static WebElement LstItm_KPI_TrafficViews;
			
	@FindBy(xpath = "//div[starts-with(@class,'field')]/label[text()='Choose Products']/parent::div//span[@class='' and @role='button']")
			public static WebElement Checkbox_ChooseProducts;
			
	@FindBy(xpath = "//div[starts-with(@class,'field')]/label[text()='Choose Products']/parent::div//span[@class='' and @role='button' and text()='Vanity Resorts']")
			public static WebElement Checkbox_VanityResorts ;
			
	@FindBy(xpath = "//div[starts-with(@class,'field')]/label[text()='Choose Regions']/parent::div//span[text()='CA']")
			public static WebElement Checkbox_RegionCA;
			
	@FindBy(xpath = "//div[starts-with(@class,'field')]/label[text()='Choose Regions']/parent::div//span[text()='US']")
			public static WebElement Checkbox_RegionUS;
			
	@FindBy(xpath = "//div[starts-with(@class,'field')]/label[text()='Choose Regions']/parent::div//span[@class='' and @role='button' and text()='Virginia']")
			public static WebElement Checkbox_RegionUSStateVirginia;
			
	@FindBy(xpath = "//input[@id='mediabudget']")
			public static WebElement TxtBox_MediaBudget;
			
	@FindBy(xpath = "//input[@id='offerbudget']")
			public static WebElement TxtBox_OfferBudget;
			
	@FindBy(xpath = "//input[@id='variablebudget']")
			public static WebElement TxtBox_VariableBudget;
			
	@FindBy(xpath = "//button[@type='submit']")
	public static WebElement Btn_SubmitInitiative;
	
	/*------------------------------Method for Create Initiative Page -----------------------------------*/

}
