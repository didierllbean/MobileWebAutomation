package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Test.TestCaseConfiguration;
import Tools.Utilities;

public class MenuPageObjects {

	WebDriver driver;

	@FindBy(xpath = "//div[@id='llb_header']/div[2]/div/div[2]")
	WebElement menShopMenu;

	@FindBy(xpath = "//div/div[2]/div[@name='Shirts']")
	WebElement menShirt;

	@FindBy(xpath = "//div[4]//div[@name='Polos']")
	WebElement menPolos;

	@FindBy(xpath = "/html/body/div[13]/div/div/div[11]/div[2]/h3")
	WebElement menCat;
	
	@FindBy(xpath = "//h3[contains(text(),'Sale')]")
	WebElement Sale;
	
	@FindBy(xpath = "//div[@class='CategoryWgetContSet expand']/div[@name= '2-A-Day Daily Markdown']")
	WebElement TwoADay;
	
	

	
	public MenuPageObjects()
	{
	  	PageFactory.initElements(TestCaseConfiguration.driver.get(), this);		
	} 

	public void NavigateToPlp() {

		Utilities.waitForAjaxToFinish();

		menShopMenu.click();
		Utilities.explicitlyWait(3000);
		menCat.click();
		menShirt.click();

	}
	
	public void NavigateToDailyMarkDownPage()
	
	{
		Utilities.waitForAjaxToFinish();
		menShopMenu.click();
		Utilities.explicitlyWait(3000);

		Sale.click();
		Utilities.explicitlyWait(3000);

		TwoADay.click();
		

	}

}