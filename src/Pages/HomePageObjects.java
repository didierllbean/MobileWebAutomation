package Pages;

import java.util.Dictionary;
 
    /* 
     * All WebElements are identified by @FindBy annotation 
     */  

public class HomrPageObjects
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


	@FindBy(xpath = "//div[@id='llb_header']/div[2]/div/div[2]")
	WebElement HPShopMenu;

	@FindBy(xpath = "//div[1]/div/div[@name='Shirts']")
	WebElement HPMenShirt;

	@FindBy(xpath = "//div[4]//div[@name='Polos']")
	WebElement HPMenPolos;

	@FindBy(xpath = "//h3[@catid='26'])[2]")
	WebElement HPMensCat;

}
