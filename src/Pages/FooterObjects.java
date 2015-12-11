package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;

import Test.TestCaseConfiguration;
import Tools.ExtentManager;
import Tools.Utilities;


public class FooterObjects {

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

	@FindBy(xpath = "//div[@class='llb_ftLogInStatusTxt' and contains(text(), 'Log In')]")
	WebElement  FooterLogin;

	@FindBy(xpath = "//div/div[@id='llb_footer']/div[4]")
	WebElement UserAccount;

	@FindBy(xpath = "//div[@class='llb_ftLogInStatusTxt' and contains(text(), 'Log Out')]")
	WebElement  FooterLogOut;

	public LoginPageObjects NavigateToLoginPage (){
		Utilities.waitForAjaxToFinish();//wait for page to be fully loaded

		FooterLogin.click();
		ExtentManager.getExtentTest().log(LogStatus.PASS, "GoToLogin", "Success");
		
		return PageFactory.initElements(TestCaseConfiguration.driver.get(), LoginPageObjects.class);	
	}
	
	public FooterObjects()
	{
	  	PageFactory.initElements(TestCaseConfiguration.driver.get(), this);		
	}

	public void FooterSignOut()	
	{
		Utilities.waitForAjaxToFinish();//wait for page to be fully loaded
		FooterLogOut.click();
		ExtentManager.getExtentTest().log(LogStatus.PASS, "Logout", "Success");
	}
}