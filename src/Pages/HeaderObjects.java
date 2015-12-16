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
	
	@FindBy(xpath = "//div[@class = 'llb_headerBagCount']")
	WebElement ShoppingBagCount;
	
	@FindBy(xpath ="//input[@id='search-string']")
	WebElement SeachBar;
	
	@FindBy(xpath = "//div[@id='search_button']")
	WebElement ClickSearchButton;
	
	@FindBy(xpath = "//div[@class='searchAutoCompleteDropdown']")
	WebElement SearchAutoCompleteDropDown;
	
	public HeaderObjects()	{
	  	PageFactory.initElements(TestCaseConfiguration.driver.get(), this);		
	}
	
	public ShoppingBagPage goToSB(){	
		Utilities.waitForAjaxToFinish();
		
		ShoppingBagImg.click();	
		ExtentManager.getExtentTest().log(LogStatus.PASS, "GoToSB", "Success");
		
		return PageFactory.initElements(TestCaseConfiguration.driver.get(), ShoppingBagPage.class);
	}
	
	public void SBCount()
	{
		String Count = ShoppingBagCount.getText();
		System.out.println(Count);

	}
	
	public void EnterSearchTerm()
	{
		SeachBar.sendKeys("S");
		//ClickSearchButton.click();
		String text = SearchAutoCompleteDropDown.getAttribute("innerHTML");
		String text1 = text.replaceAll("<div class=\"searchAutoCompleteDropdownList\"", " ");
		
		System.out.println(text1);
		
	

		
	}
	
		
}



