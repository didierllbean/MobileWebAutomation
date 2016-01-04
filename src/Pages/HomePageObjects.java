package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Test.TestCaseConfiguration;
 
    /* 
     * All WebElements are identified by @FindBy annotation 
     */  

public class HomePageObjects
{

	WebDriver driver;
	@FindBy(xpath ="//div[@id='llb_header']/div[2]/div/div[2]")
    WebElement hpShopMenu;
    
    @FindBy(xpath="//div[1]/div/div[@name='Shirts']")    
    WebElement hpMenShirt;
    
    @FindBy(xpath="//div[4]//div[@name='Polos']")
    WebElement  hpMenPolos;
    
    @FindBy(xpath="//h3[@catid='26'])[2]")    
    WebElement hpMensCat;
    
    @FindBy(xpath ="//h3[@name='GiftCard']")
    WebElement giftCard;

    public HomePageObjects()	{
	  	PageFactory.initElements(TestCaseConfiguration.driver.get(), this);		
	}
    public void ClickGC()
    
    {
    	giftCard.click();
    }
}