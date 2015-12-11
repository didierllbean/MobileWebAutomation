package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
 
    /* 
     * All WebElements are identified by @FindBy annotation 
     */  

public class HomePageObjects
{

	WebDriver driver;
	@FindBy(xpath ="//div[@id='llb_header']/div[2]/div/div[2]")
    WebElement HPShopMenu;
    
    @FindBy(xpath="//div[1]/div/div[@name='Shirts']")    
    WebElement HPMenShirt;
    
    @FindBy(xpath="//div[4]//div[@name='Polos']")
    WebElement  HPMenPolos;
    
    @FindBy(xpath="//h3[@catid='26'])[2]")    
    WebElement HPMensCat;

}
