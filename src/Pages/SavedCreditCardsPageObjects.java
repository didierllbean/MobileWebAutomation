package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Test.TestCaseConfiguration;
import Tools.Utilities;

public class SavedCreditCardsPageObjects {

	WebDriver driver;
	
	@FindBy(xpath = "//input[@value='Add New']")
	WebElement addNewCC;
	
	@FindBy(xpath = "//div[@class='myacCardName myacCardInfo myacDefaultCard']")
	WebElement storedCC;
	
	@FindBy(xpath = "//div[@class='myacCardInfo myacEmptyCardTxt']")
	WebElement noCC;
	
	@FindBy(linkText = "Delete")
	WebElement deleteCC;
	
	@FindBy(css = "div.popup_but2Txt")
	WebElement delete;



	
	public SavedCreditCardsPageObjects()
	{
	  	PageFactory.initElements(TestCaseConfiguration.driver.get(), this);		
	} 
	
	public void ClickAddNewCC()
	
	{
		addNewCC.click();
	}
	
	public void StoredCardVerification()
	
	{
		
		Assert.assertTrue(storedCC.getText().equals("American Express *3499"));	
	}
	
	public void DeleteCC()
	
	{
		deleteCC.click();
		Utilities.explicitlyWait(3000);
		delete.click();
		Assert.assertEquals(noCC.getText(), "You don't currently have any credit cards associated with your account.");
		//Assert.assertTrue(noCC.getText().equals("You don't currently have any credit cards associated with your account."));	
		
	}
}



