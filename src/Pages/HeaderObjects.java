package Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import Test.TestCaseConfiguration;
import Tools.ExtentManager;
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
	WebElement sweatPantsSrchSuggestion;
	
	public HeaderObjects()	{
	  	PageFactory.initElements(TestCaseConfiguration.driver.get(), this);		
	}
	
	public ShoppingBagPage goToSB(){	
		Utilities.waitForAjaxToFinish();
		
		shoppingBagImg.click();	
		//ExtentManager.getExtentTest().log(LogStatus.PASS, "GoToSB", "Success");
		
		return PageFactory.initElements(TestCaseConfiguration.driver.get(), ShoppingBagPage.class);
	}
	
	public void NavigateToHp()
	
	{
		headerLLbeanLogo.click();
		
	}
	public void SBCount()
	{
		String Count = shoppingBagCount.getText();
		System.out.println(Count);

	}
	
	public void SearchSuggestionVerification()
	{
		seachBar.sendKeys("S");

		Utilities.explicitlyWait(5000);
		String text = searchAutoCompleteDropDown.getAttribute("innerHTML");
		
		String text1 = text.replaceAll("<div class=\"searchAutoCompleteDropdownList\"", " ");
		
		Assert.assertTrue(text1.contains("sock")|text1.contains("signature boots")|text1.contains("sweat pants"));
		
	}
	
	public void SearchSuggestionClick()
	
	{
		seachBar.sendKeys("S");
		Utilities.explicitlyWait(7000);
		sweatPantsSrchSuggestion.click();
		
	}
	
	public void SearchForShirts()
	{
		seachBar.sendKeys("Shirts");
		clickSearchButton.click();

		
	}
	
public void ProductListPageVerification()
	
	{
		seachBar.sendKeys("Bluetooth");
		clickSearchButton.click();
		
		Utilities.explicitlyWait(5000);
		
		for(WebElement ele: productTitle)
		{
			System.out.println(ele.getText());
			
			Assert.assertTrue(ele.getText().contains("Bluetooth"));
		}	
		
	}

public void QuickShopCatalogVerification()

{
	seachBar.sendKeys("266127");
	clickSearchButton.click();
	Utilities.explicitlyWait(3000);
	
	Assert.assertTrue(TestCaseConfiguration.driver.get().getPageSource().contains("We found more than one match for the item number(s) you entered."));

}
}