package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Test.TestCaseConfiguration;
import Tools.Utilities;

public class DailyMarkDownPageObjects {
	
	WebDriver driver;
	
	@FindBy(css="h1")
	WebElement dailyMarkDownTitle;
	
	//div[contains(@class, 'description')]/h3"

	public DailyMarkDownPageObjects()	{
	  	PageFactory.initElements(TestCaseConfiguration.driver.get(), this);		
	}
	
	public String getDailyMarkDownTitleTexts01()
	{
		
		Utilities.waitForAjaxToFinish();
		String text1 = dailyMarkDownTitle.getText();
		System.out.println(text1);
		return text1;
	}
	
	public String getDailyMarkDownTitleTextsProd()
	{
		
		Utilities.waitForAjaxToFinish();
		String text2 = dailyMarkDownTitle.getText();
		System.out.println(text2);
		return text2;
		
	}
	
	
}
