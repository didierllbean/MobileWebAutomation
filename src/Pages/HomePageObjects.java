package Pages;
 
import org.testng.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
 
import org.openqa.selenium.WebElement;
 
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
 
public class HomePageObjects {
 
    /* 
     * All WebElements are identified by @FindBy annotation 
     */    
    @FindBy(xpath ="//div[@id='llb_header']/div[2]/div/div[2]")
    WebElement HPShopMenu;
    
    @FindBy(xpath="//div[1]/div/div[@name='Shirts']")    
    WebElement HPMenShirt;
    
    @FindBy(xpath="//div[4]//div[@name='Polos']")
    WebElement  HPMenPolos;
    
    @FindBy(xpath="//h3[@catid='26'])[2]")    
    WebElement HPMensCat;
}


