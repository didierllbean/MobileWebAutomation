package Pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Test.TestCaseConfiguration;

public class QuickShopPageObjects {
	

	WebDriver driver;

	
	@FindBy(name = "cg")
	WebElement qsOption1;
	
	@FindBy(xpath= "(//input[@name='cg'])[2]")
	WebElement qsOption2;
	
	@FindBy(id = "un_input_but")
	WebElement qsContinue;
	
	
	public QuickShopPageObjects()
	{
	  	PageFactory.initElements(TestCaseConfiguration.driver.get(), this);		
	}
	public ProductPageCore QSOption1()
	
	{
		qsOption1.click();
		qsContinue.click();
		
		return PageFactory.initElements(TestCaseConfiguration.driver.get(), ProductPageCore.class);

	}
	
public ProductPageCore QSOption2()
	
	{
		qsOption2.click();
		qsContinue.click();
		
		return PageFactory.initElements(TestCaseConfiguration.driver.get(), ProductPageCore.class);

	}

public ProductPageCore QSOptionVerification()

{
	Assert.assertTrue(qsOption1.isDisplayed());
	Assert.assertTrue(qsOption2.isDisplayed());

	
	return PageFactory.initElements(TestCaseConfiguration.driver.get(), ProductPageCore.class);

	
}

}
