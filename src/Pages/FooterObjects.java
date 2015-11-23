package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FooterObjects {

	
	
	

	
	 @FindBy(xpath="//div[@id= 'llb_footer']/div[2]/a[1]/div/div[2]")

	    WebElement FTCustServlink;
	 
	  
	    		
	    WebElement FTChildShirts;
	
	 
	   // "//div[@id='llb_header']/div[2]/div/div[2]"
	 
	    @FindBy(linkText="L.L.Bean® Visa® Apply Now")
	 
	    WebElement FTLbVisaApply;
	    
	    @FindBy(linkText="L.L.Bean® Visa® Card Coupon Lookup")
	    
	    WebElement FTLbVisaCoupLkUp;
	    
	   @FindBy(linkText="Purchase History & Order Tracking")
	    
	    WebElement FTPrcHistOrdTrk;
	    
	    
	   @FindBy(className="llb_ftLogInStatusTxt")
	   
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
	  
	  @FindBy(xpath = "//div/div[@id='llb_footer']/div[4]")
	  
	  WebElement  FooterLogin;
	  
	  @FindBy(xpath = "//div/div[@id='llb_footer']/div[4]")
	  WebElement UserAccount;
}
