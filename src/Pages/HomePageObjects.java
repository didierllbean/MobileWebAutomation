package Pages;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
 
import org.openqa.selenium.WebElement;
 
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
 
public class HomePageObjects {
 
    /**
 
     * All WebElements are identified by @FindBy annotation
 
     */
 
    WebDriver driver;
    
    @FindBy(xpath ="//div[@id='llb_header']/div[2]/div/div[2]")

    WebElement HPShopMenu;
    
    @FindBy(xpath="//div[1]/div/div[@name='Shirts']")
    
    
    WebElement HPMenShirt;
    
    @FindBy(xpath="//div[4]//div[@name='Polos']")
    WebElement  HPMenPolos;
    
    
    @FindBy(xpath="/html/body/div[13]/div/div/div[11]/div[2]/h3")
    
    WebElement HPMensCat;
    
   

   
  
  
  
  
}


