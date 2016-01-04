package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Test.TestCaseConfiguration;

public class CreditCardDetailPageObjects {

	
	WebDriver driver;
	
	@FindBy(id = "myacCreditCardNumber")
	WebElement enterCCNumber;
	
	@FindBy(id = "myacCardExpiryMnth")
	WebElement enterMonth;

	@FindBy(id = "myacCardExpiryYr")
	WebElement enterYear;
	
	@FindBy(id = "myacAddrBookSaveAddrBtn")
	WebElement saveCC;
	
	public void EnterNewCC()
	{
		enterCCNumber.sendKeys("3454 5421 1544 815");
		enterMonth.sendKeys("02");
		enterYear.sendKeys("2019");
		saveCC.click();
		
	}
	
	public CreditCardDetailPageObjects()
	{
	  	PageFactory.initElements(TestCaseConfiguration.driver.get(), this);		
	}
	
	
}

