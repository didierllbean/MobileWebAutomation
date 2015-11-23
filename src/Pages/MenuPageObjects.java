package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuPageObjects {

	
	 WebDriver driver;
	    
	    @FindBy(xpath ="//div[@id='llb_header']/div[2]/div/div[2]")

	    WebElement MNShopMenu;
	    
	    @FindBy(xpath="//div[1]/div/div[@name='Shirts']")
	    
	    
	    WebElement MNMenShirt;
	    
	    @FindBy(xpath="//div[4]//div[@name='Polos']")
	    WebElement  MNMenPolos;
	    
	    
	    @FindBy(xpath="/html/body/div[13]/div/div/div[11]/div[2]/h3")
	    
	    WebElement MNMensCat;
	
	    
	    public void NavigateToPlp (WebDriver driver){
	      	
	      	this.driver = driver;
	      	PageFactory.initElements(driver, this);
	      	MNShopMenu.click();
	      	MNMensCat.click();
	      	MNMenShirt.click();
	      	
	      	
	      }
	
}
