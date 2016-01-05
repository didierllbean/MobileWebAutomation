package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Test.TestCaseConfiguration;

public class GiftCardPageObjects {

	
	WebDriver Driver;
	
	@FindBy(xpath = "//input[@value='E-GIFT CARD']")
	WebElement eGiftCard;
	
	
	public GiftCardPageObjects()
	{
	  	PageFactory.initElements(TestCaseConfiguration.driver.get(), this);		
	}

	
	public void clickEGc()
	
	{
		
		eGiftCard.click();
	}
	
	
}
