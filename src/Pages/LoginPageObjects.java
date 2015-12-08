package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;

import Test.CreateAccountTestCases;

import com.relevantcodes.extentreports.Chart;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class LoginPageObjects {

	static final ExtentReports extent = ExtentReports.get(CreateAccountTestCases.class);
	/* All WebElements are identified by @FindBy annotation */
	WebDriver driver;
	/* Common Elements *///available for both regular and checkout login pages
	@FindBy(id = "loginEmail")
	WebElement email;

	@FindBy(id = "loginPassword")
	WebElement password;

	@FindBy(xpath = "//input[contains(@name, 'un_jtt_login')]")
	WebElement loginBttn;
	
	@FindBy(linkText = "Forgot your password?")
	WebElement forgotPasswordLink;
	
	@FindBy(xpath = "//input[contains(@value, 'Guest')]")
	WebElement continueAsAGuest;

	/* Regular Login Elements *///only available for regular login page
	@FindBy(xpath = "//input[contains(@value, 'Create an Account')]")
	WebElement createAnAccount;
	
	/**
	 * Generic Method <p> 
	 * Allow the user to log into the site wherever the user is located. <p> 
	 * Returns page object class for the class where the user will land after login.
	 * 
	 * @param email   email address for the account to log in. 
	 * @param password     password for the desired account.
	 * @param driver	 Current WebDriver in use. 
	 * @return 			 Object of the expected class.
	 * 
	 *  @author Yohan Desanti G.  
	 *  @LastUpdate Yohan Desanti G.
	 *  @version 1.0, 11/30/2015
	 */
	public <T> T login(String email, String password, WebDriver driver, Class<T> expectedPage){
		this.email.clear();
		this.email.sendKeys(email);
		this.password.sendKeys(password);
		return PageFactory.initElements(driver, expectedPage);
	}
	
	
	/**
	 * Allow the user to log into the site during the chekcout process. <p> 
	 * Returns page object class for the Checkout class.
	 * 
	 * @param email   	 email address for the account to log in. 
	 * @param password   password for the desired account.
	 * @param driver	 Current WebDriver in use. 
	 * @return 			 Object of the expected class.
	 * 
	 *  @author Yohan Desanti G.  
	 *  @LastUpdate Yohan Desanti G.
	 *  @version 1.0, 11/30/2015
	 */
	public CheckoutPageObjects loginAndContinueCheckout(String email, String password, WebDriver driver){
		return login(email, password, driver, CheckoutPageObjects.class);
	}
	
	/**
	 * Generic Method <p> 
	 * Allow the user to continue without log into the site wherever the user is located. <p> 
	 * Returns page object class for the class where the user will land after avoid login.
	 * 
	 * @param email   	 email address for the account to log in. 
	 * @param password   password for the desired account.
	 * @param driver	 Current WebDriver in use. 
	 * @return 			 Object of the expected class.
	 * 
	 *  @author Yohan Desanti G.  
	 *  @LastUpdate Yohan Desanti G.
	 *  @version 1.0, 11/30/2015
	 */
	public <T> T continueAsGuest(WebDriver driver, Class<T> expectedPage){
		continueAsAGuest.click();
		return PageFactory.initElements(driver, expectedPage);
	}
	
	/**
	 * Allow the user to avoid log into the site during the checkout process. <p> 
	 * Returns page object class for the Checkout class.
	 * 
	 * @param driver	 Current WebDriver in use. 
	 * @return 			 Object of the expected class.
	 * 
	 *  @author Yohan Desanti G.  
	 *  @LastUpdate Yohan Desanti G.
	 *  @version 1.0, 11/30/2015
	 */
	public CheckoutPageObjects continueCheckoutAsGuest(WebDriver driver){
		return continueAsGuest(driver, CheckoutPageObjects.class);
	}
	
	public LoginPageObjects(WebDriver driver)
	
	{
		
		this.driver = driver;
	  	PageFactory.initElements(driver, this);

	}
	
	public void VerifyNewAccount(String Email1, String Pass1) throws InterruptedException
	
	{
		if(Email1.equals(email.getAttribute("value")))
				{
			
		     extent.log(LogStatus.PASS, "Email Address Verification", "Email Address Matches");

		password.sendKeys(Pass1);
		
		
				}
		else
		{
		     extent.log(LogStatus.FAIL, "Email Address Verification", "Email Address Does Not Match");

		}
		
		loginBttn.click();
	     
	}
	
	
	
}