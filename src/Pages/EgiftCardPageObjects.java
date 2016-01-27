package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Test.TestCaseConfiguration;
import Tools.Utilities;

public class EgiftCardPageObjects {

	
	WebDriver driver;
	
	@FindBy(xpath ="//div[@name='Night Tent']")
	WebElement EgcType;
	
	@FindBy(xpath = "//input[@type='text']")
	WebElement EgcTypeValue;
	
	@FindBy(xpath = "//textarea[@type='text']")
	WebElement EgcMessage;
	
	@FindBy(xpath ="//div[@class='gc_TxtBoxCont']//input")
	WebElement EgcName;
	
	@FindBy(xpath = "//input[@type='email']")
	WebElement EgcEmail;
	
	
	@FindBy(xpath = "(//input[@type='email'])[2]")
	WebElement EgcReEnterEmail;
	
	@FindBy(xpath ="//input[@value='Add to shopping bag']")
	WebElement EgcATB;
	
	@FindBy(xpath = "//a[@class='un_wlorange']")
	WebElement EgcCheckout;
	
	@FindBy(xpath = "//input[@value='Remove']")
	WebElement EgcRemove;

	public EgiftCardPageObjects()	{
	  	PageFactory.initElements(TestCaseConfiguration.driver.get(), this);		
	}
	
	public ShoppingBagPage selectEgc()
	
	{
		EgcType.click();
		EgcTypeValue.sendKeys("10");
		EgcMessage.sendKeys("Happy New Year");
		EgcName.sendKeys("David");
		EgcEmail.sendKeys("dave123@gmail.com");
		EgcReEnterEmail.sendKeys("dave123@gmail.com");
		EgcATB.click();
		Utilities.waitForAjaxToFinish();
		Utilities.explicitlyWait(5000);
		EgcCheckout.click();
		//EgcRemove.click();	
		
		return PageFactory.initElements(TestCaseConfiguration.driver.get(), ShoppingBagPage.class);

	}
	
}
