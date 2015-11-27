package Pages;

import java.util.Dictionary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Util.Fetch;

public class FooterObjects {

	
		Fetch obj=new Fetch();
		Dictionary dict1=obj.readfromExcel();
	
	 WebDriver driver;


	
	@FindBy(xpath = "//div[@class='llb_ftCustServTxt' and contains(text(), 'Customer Service")
	    WebElement FTCustServlink;
		
	 
	 
	    @FindBy(linkText="L.L.Bean® Visa® Apply Now")
	 
	    WebElement FTLbVisaApply;
	    
	    @FindBy(linkText="L.L.Bean® Visa® Card Coupon Lookup")
	    
	    WebElement FTLbVisaCoupLkUp;
	    
	   @FindBy(linkText="Purchase History & Order Tracking")
	    
	    WebElement FTPrcHistOrdTrk;
	    
	    
	   @FindBy(xpath="//div[@class='llb_ftLogInStatusTxt' and contains(text(), 'Log In')]")
	   
	   WebElement FTLogin;
	   
	   @FindBy(linkText="Security")
	   
	   WebElement FTSecurity;
	   
	   
	 @FindBy(linkText="Privacy")
	   
	   WebElement FTPrivacy;
	   
	   
	 @FindBy(linkText="Recalls")
	   
	   WebElement FTRecalls;
	   
	   
	   
	 @FindBy(linkText="Promotional Terms")
	   
	   WebElement FTPromotionalTerms;
	   
	   
	 @FindBy(linkText="888-797-3880")
	 
	 WebElement FTPhoneNumber;
	 
	 

	 @FindBy(linkText="Full Site")
	 
	 WebElement FTFullSite;
	 
	   
	@FindBy(linkText="Download the Mobile App")
	 
	 WebElement FTDownLdApp;
	 
	   
	  
	    
	   @FindBy(name="emailaddress")
	   
	   WebElement FTEmailAddFld;
	    
	    
	  @FindBy(id="llb_ftSignUpBtn")
	   
	   WebElement SignUpBtn;
	  
	  
	  @FindBy(id="search-string")
	  
	  WebElement FTSrchBar;
	  
	  @FindBy(xpath = "//div[@class='llb_ftLogInStatusTxt' and contains(text(), 'Log In")
	  
	  WebElement  FooterLogin;
	  
	  @FindBy(xpath = "//div/div[@id='llb_footer']/div[4]")
	  WebElement UserAccount;
	  
      @FindBy(xpath = "//div[@class='llb_ftLogInStatusTxt' and contains(text(), 'Log Out")
	  
	  WebElement  FooterLogOut;
      
      public void NavigateToLoginPage (WebDriver driver){
	      	
	      	this.driver = driver;
	      	PageFactory.initElements(driver, this);
	      	FooterLogin.click();
	      	
	            }
      
      

    	
      
	  
}
