package Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Test.TestCaseConfiguration;
import Tools.Utilities;

public class HeaderObjects {
	
	
	@FindBy(id ="un_logo")
	WebElement headerLLbeanLogo;
	
	@FindBy(xpath ="id('cart-section')/div[contains(@class, 'cart-div')]")
    WebElement shoppingBagImg;
	
	@FindBy(xpath = "//div[@class = 'llb_headerBagCount']")
	WebElement shoppingBagCount;
	
	@FindBy(xpath ="//input[@id='search-string']")
	WebElement seachBar;
	
	@FindBy(xpath = "//div[@id='search_button']")
	WebElement clickSearchButton;
	
	@FindBy(xpath = "//div[@class='searchAutoCompleteDropdown']")
	WebElement searchAutoCompleteDropDown;
	
	@FindBy(xpath = "//a[@class='llb_productListTitle']")
	List<WebElement> productTitle;
	
	@FindBy(xpath = "//div[contains(text(), 'socks')]")
	WebElement socks;
	
	@FindBy(id = "headerSearchCloseBtnSymbol")
    WebElement removeSearchTerm;	
	public HeaderObjects()	{
	  	PageFactory.initElements(TestCaseConfiguration.driver.get(), this);		
	}
	
	public ShoppingBagPage goToSB(){	
		Utilities.waitForAjaxToFinish();
		
		shoppingBagImg.click();	
		//ExtentManager.getExtentTest().log(LogStatus.PASS, "GoToSB", "Success");
		
		return PageFactory.initElements(TestCaseConfiguration.driver.get(), ShoppingBagPage.class);
	}
	
	public void navigateToHp()
	
	{
		headerLLbeanLogo.click();
		
	}
	public void sBCount()
	{
		String Count = shoppingBagCount.getText();
		System.out.println(Count);

	}
	
	public void searchSuggestionVerification()
	{
		seachBar.sendKeys("S");

		Utilities.explicitlyWait(5000);
		String text = searchAutoCompleteDropDown.getAttribute("innerHTML");
		
		String text1 = text.replaceAll("<div class=\"searchAutoCompleteDropdownList\"", " ");
		
		Assert.assertTrue(text1.contains("sock")|text1.contains("signature boots")|text1.contains("sweat pants"));
		removeSearchTerm.click();
	}
	
	public void searchSuggestionClick()
	
	{
		seachBar.sendKeys("S");
		Utilities.explicitlyWait(7000);
		socks.click();
		
	}
	
	public void searchForShirts()
	{
		seachBar.sendKeys("Shirts");
		clickSearchButton.click();

		
	}
	
public void productListPageVerification()
	
	{
		seachBar.sendKeys("Bluetooth");
		clickSearchButton.click();
		
		Utilities.explicitlyWait(5000);
		
		for(WebElement ele: productTitle)
		{
			
			Assert.assertTrue(ele.getText().contains("Bluetooth"));
		}	
		
	}

public void quickShopCatalogVerification()

{
	seachBar.sendKeys("266127");
	clickSearchButton.click();
	Utilities.explicitlyWait(3000);
	Utilities.waitForAjaxToFinish();
	
	Assert.assertTrue(TestCaseConfiguration.driver.get().getPageSource().contains("We found more than one match for the item number(s) you entered."));

}
}