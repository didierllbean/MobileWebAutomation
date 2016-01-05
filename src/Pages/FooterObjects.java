package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import Test.TestCaseConfiguration;
import Tools.ExtentManager;
import Tools.Utilities;


public class FooterObjects {

	@FindBy(linkText = "Customer Service")
	WebElement custServlink;

	@FindBy(linkText="L.L.Bean® Visa® Apply Now")
	WebElement llbVisaApply;

	@FindBy(linkText="L.L.Bean® Visa® Card Coupon Lookup")
	WebElement llbVisaCoupLkUp;

	@FindBy(linkText="Purchase History & Order Tracking")
	WebElement purchaseHistOrdTrk;


	@FindBy(xpath="//div[@class='llb_ftLogInStatusTxt' and contains(text(), 'Log In')]")
	WebElement ftlogin;

	@FindBy(linkText="Security")
	WebElement security;

	@FindBy(linkText="Privacy")
	WebElement privacy;

	@FindBy(linkText="Recalls")
	WebElement recalls;

	@FindBy(linkText="Promotional Terms")
	WebElement promotionalTerms;

	@FindBy(linkText="888-797-3880")
	WebElement phoneNumber;

	@FindBy(linkText="Full Site")
	WebElement fullSite;

	@FindBy(linkText="Download the Mobile App")
	WebElement downLdApp;

	@FindBy(name="emailaddress")
	WebElement emailAddFld;

	@FindBy(id="llb_ftSignUpBtn")
	WebElement signUpBtn;

	@FindBy(id="search-string")
	WebElement searchBar;

	@FindBy(xpath = "//div[@class='llb_ftLogInStatusTxt' and contains(text(), 'Log In')]")
	WebElement  FooterLogin;

	@FindBy(xpath = "//div[@id='llb_footer']/div[4]")
	WebElement UserAccount;

	@FindBy(xpath = "//div[@class='llb_ftLogInStatusTxt' and contains(text(), 'Log Out')]")
	WebElement  FooterLogOut;

	public LoginPageObjects NavigateToLoginPage (){
		Utilities.waitForAjaxToFinish();//wait for page to be fully loaded

		FooterLogin.click();
		
		return PageFactory.initElements(TestCaseConfiguration.driver.get(), LoginPageObjects.class);	
	}
	
	public FooterObjects()
	{
	  	PageFactory.initElements(TestCaseConfiguration.driver.get(), this);		
	}

	public void footerSignOut()	
	{
		Utilities.waitForAjaxToFinish();//wait for page to be fully loaded
		FooterLogOut.click();
	}
	
	public void emailSignUp()
	
	{
		emailAddFld.sendKeys("testing121@gmail.com");
		Utilities.explicitlyWait(3000);

		signUpBtn.click();
		
		
	}
	
	public void clickUserAccountName()
	{
		UserAccount.click();
	}
	
	public void footerLinkVerification()
	
	{
		
		
		Utilities.waitForAjaxToFinish();
		Assert.assertTrue(custServlink.isDisplayed());
		Assert.assertTrue(llbVisaApply.isDisplayed());
		Assert.assertTrue(llbVisaCoupLkUp.isDisplayed());
		Assert.assertTrue(purchaseHistOrdTrk.isDisplayed());
		Assert.assertTrue(security.isDisplayed());
		Assert.assertTrue(privacy.isDisplayed());
		Assert.assertTrue(recalls.isDisplayed());
		Assert.assertTrue(promotionalTerms.isDisplayed());
		Assert.assertTrue(phoneNumber.isDisplayed());
		Assert.assertTrue(fullSite.isDisplayed());
		Assert.assertTrue(emailAddFld.isDisplayed());
		Assert.assertTrue(signUpBtn.isDisplayed());
		Assert.assertTrue(searchBar.isDisplayed());
		Assert.assertTrue(FooterLogin.isDisplayed());
		Assert.assertTrue(downLdApp.isDisplayed());
		Assert.assertTrue(UserAccount.isDisplayed());	

	}
	
	
	
}