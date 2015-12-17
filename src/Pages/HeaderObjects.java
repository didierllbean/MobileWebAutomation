package Pages;

import java.util.List;

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
	
	@FindBy(xpath = "//a[@class='llb_productListTitle']")
	List<WebElement> ProductTitle;
	
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
		String text = SearchAutoCompleteDropDown.getAttribute("innerHTML");
		String text1 = text.replaceAll("<div class=\"searchAutoCompleteDropdownList\"", " ");
		System.out.println(text1);
		if(text1.contains("socks")|text1.contains("signature boots")|text1.contains("sweat pants"))
			
		{
			System.out.println("Pass");

		}
		
		else
		{
		
		System.out.println("Fail");
		}
	}
	
public void ProductListPageVerification()
	
	{
		SeachBar.sendKeys("Bluetooth");
		ClickSearchButton.click();
		
		Utilities.explicitlyWait(5000);
		
		for(WebElement ele: ProductTitle)
		{
			System.out.println(ele.getText());
			
			if(ele.getText().contains("Bluetooth"))
			{
				System.out.println("Pass");
			}
			else
			{
				System.out.println("Fail");

			}
		}
		
		
	}

public void QuickShopCatalogVerification()

{
	SeachBar.sendKeys("296574");
	ClickSearchButton.click();
	Utilities.explicitlyWait(3000);
	if(TestCaseConfiguration.driver.get().getPageSource().contains("We found more than one match for the item number(s) you entered."))
	{

		System.out.println("Pass");

}
	
	else
	{
		System.out.println("Fail");

	}
	
	
}
}