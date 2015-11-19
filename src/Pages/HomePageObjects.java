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
    
   

    @FindBy(className="llb_ftCustServTxt")

    WebElement HPCustServlink;
 
        
    		
    WebElement HPChildShirts;
 
 
    @FindBy(className="llb_ftFindAStoreTxt")
 
    WebElement HPFindAStrLink;
 
     
 
    @FindBy(linkText="L.L.Bean® Visa® Apply Now")
 
    WebElement HPLbVisaApply;
    
    @FindBy(linkText="L.L.Bean® Visa® Card Coupon Lookup")
    
    WebElement HPLbVisaCoupLkUp;
    
   @FindBy(linkText="Purchase History & Order Tracking")
    
    WebElement HPPrcHistOrdTrk;
    
    
   @FindBy(className="llb_ftLogInStatusTxt")
   
   WebElement HPLogin;
   
   @FindBy(linkText="Security")
   
   WebElement HPSecurity;
   
   
 @FindBy(linkText="Privacy")
   
   WebElement HPPrivacy;
   
   
 @FindBy(linkText="Recalls")
   
   WebElement HPRecalls;
   
   
   
 @FindBy(linkText="Promotional Terms")
   
   WebElement HPPromotionalTerms;
   
   
 @FindBy(linkText="888-797-3880")
 
 WebElement HPPhoneNumber;
 
 

 @FindBy(linkText="Full Site")
 
 WebElement HPFullSite;
 
   
@FindBy(linkText="Download the Mobile App")
 
 WebElement HPDownLdApp;
 
   
  
    
   @FindBy(name="emailaddress")
   
   WebElement HPEmailAddFld;
    
    
  @FindBy(id="llb_ftSignUpBtn")
   
   WebElement SignUpBtn;
  
  
  @FindBy(id="search-string")
  
  WebElement HpSrchBar;
  
  
  public void NavigateToPlp (WebDriver driver){
  	
  	this.driver = driver;
  	PageFactory.initElements(driver, this);
  	HPShopMenu.click();
  	HPMensCat.click();
  	MenShirt.click();
  	
  	
  }
  
}


