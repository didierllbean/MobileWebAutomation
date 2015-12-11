package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;

import Test.TestCaseConfiguration;
import Tools.ExtentManager;
import Tools.Utilities;

public class HeaderObjects {
	
	@FindBy(xpath ="id('cart-section')/div[contains(@class, 'cart-div')]")
    WebElement ShoppingBagImg;
	
	public HeaderObjects()	{
	  	PageFactory.initElements(TestCaseConfiguration.driver.get(), this);		
	}
	
	public ShoppingBagPage goToSB(){	
		Utilities.waitForAjaxToFinish();
		
		ShoppingBagImg.click();	
		ExtentManager.getExtentTest().log(LogStatus.PASS, "GoToSB", "Success");
		
		return PageFactory.initElements(TestCaseConfiguration.driver.get(), ShoppingBagPage.class);
	}
}



