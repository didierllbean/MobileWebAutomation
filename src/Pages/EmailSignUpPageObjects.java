package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


import Test.TestCaseConfiguration;

public class EmailSignUpPageObjects {

	WebDriver driver;
	
	
	@FindBy(xpath ="//div[@id='mainbody']/div[1]")
	WebElement welcomeText;
	
	public void ThankYouTextVerification()
	
	{
		String text = welcomeText.getText();
		System.out.print(text);
		
		Assert.assertTrue(welcomeText.getText().equals("Thank you for signing up to receive L.L.Bean email updates."));

	}
	
	public EmailSignUpPageObjects()
	{
	  	PageFactory.initElements(TestCaseConfiguration.driver.get(), this);		
	}
	
}
