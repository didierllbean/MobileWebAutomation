package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderObjects {
	
	WebDriver driver;
	@FindBy(id ="cart-section")
    WebElement ShoppingBagImg;
	
	public HeaderObjects(WebDriver driver)

	{
		this.driver = driver;
	  	PageFactory.initElements(driver, this);
		
	}
	
	public void clickSBImage(){
		
		
		ShoppingBagImg.click();
		
	}
}



