/**
 * Core Framework
 * Author : Deepak Tiwari
 * Creation Date : 27 Apr 2018
 * Modified Date : 
 * Modified By : 
 */
package alchemypages.livemediaplans;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LiveMediaPlanPage {
	
/*-----------------------Elements on Login Page ----------------------------*/
	
	@FindBy(xpath = "//div[@class='live-mediaplans-container']/table")
		public static WebElement Table_LiveMediaPlans;
	
	@FindBy(xpath = "//div[@class='live-mediaplans-container']/table//tbody/tr//a")
	public static WebElement Table_LiveMediaPlansRowLink;
	
	
	/*------------------------------Methods for Live Media Plans Page -----------------------------------*/

}
