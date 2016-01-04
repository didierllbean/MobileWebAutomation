package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;

import Test.TestCaseConfiguration;
import Tools.ExtentManager;
import Tools.GenerateData;
import Tools.Utilities;


public class CreateAnAccount {
	
	@FindBy(id = "id_srfFNameTxt")
	WebElement fName;

	@FindBy(name = "srfEmail")
	WebElement email;

	@FindBy(name = "srfVeriEmail")
	WebElement reEnterEmail;


	@FindBy(name = "srfPwd")
	WebElement password;

	@FindBy(name = "srfVeriPwd")
	WebElement reEnterPassword;


	@FindBy(id = "id_srfSecuQusSelect")
	WebElement securityQuestion;
	
	@FindBy(id = "id_srfSecuAnsTxt")
	WebElement securityAnswer;

	
	@FindBy(xpath = "//input[contains(@value, 'Create an Account')]")
	WebElement createMyAccount;

	 @FindBy(xpath="//div[@class='srfCreatAccBtnTxt' and contains(text(), 'Create My Account')]")
	 WebElement createMyAccount2;
	
	public CreateAnAccount()
	{
	  	PageFactory.initElements(TestCaseConfiguration.driver.get(), this);		
	}
	
	public void CreateAccClick()
	{
		Utilities.waitForAjaxToFinish();//wait for page to be fully loaded
		createMyAccount.click();
		//ExtentManager.getExtentTest().log(LogStatus.PASS, "NavigateToCreateAccountPage", "Success");
	}
	
	public String CreateAndVerifyAccount() throws InterruptedException
	{
		Utilities.waitForAjaxToFinish();//wait for page to be fully loaded
		GenerateData genData;
		genData=new GenerateData();
		
		 String Pass;	 

		fName.sendKeys(genData.generateRandomString(10));
		String FirstName = fName.getAttribute("value");
		System.out.println(FirstName);
		
	    email.sendKeys(genData.generateEmail(15));
		String EmailAddress = email.getAttribute("value");
	    reEnterEmail.sendKeys(EmailAddress);
	    
	    password.sendKeys(genData.generateRandomAlphaNumeric(10));
	    Pass= password.getAttribute("value");
	    reEnterPassword.sendKeys(Pass);
	    
	    securityQuestion.findElement(By.cssSelector("option[value=\"pet\"]")).click();
	    securityAnswer.sendKeys("Raja");
	    createMyAccount2.click();
	
		Utilities.waitForAjaxToFinish();//wait for page to be fully loaded
	
		if(TestCaseConfiguration.driver.get().getPageSource().contains(FirstName+"'s"))	{

			System.out.println("User Name Is Present");
}
		else
		{
			System.out.println("User Name Is Not Present");

		
		}
		return EmailAddress+";"+Pass;
	}
}