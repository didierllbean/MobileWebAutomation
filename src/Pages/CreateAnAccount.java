package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Test.TestCaseConfiguration;
import Tools.GenerateData;
import Tools.Utilities;


public class CreateAnAccount {
	
	@FindBy(id = "id_srfFNameTxt")
	WebElement Fname;

	@FindBy(name = "srfEmail")
	WebElement Email;

	@FindBy(name = "srfVeriEmail")
	WebElement ReEnterEmail;


	@FindBy(name = "srfPwd")
	WebElement Password;

	@FindBy(name = "srfVeriPwd")
	WebElement ReEnterPassword;


	@FindBy(id = "id_srfSecuQusSelect")
	WebElement SecurityQuestion;
	
	@FindBy(id = "id_srfSecuAnsTxt")
	WebElement SecurityAnswer;

	
	@FindBy(xpath = "//input[contains(@value, 'Create an Account')]")
	WebElement CreateMyAccount;

	 @FindBy(xpath="//div[@class='srfCreatAccBtnTxt' and contains(text(), 'Create My Account')]")
	 WebElement CreateMyAccount2;
	
	public CreateAnAccount()
	{
	  	PageFactory.initElements(TestCaseConfiguration.driver.get(), this);		
	}
	
	public void CreateAccClick()
	{
		Utilities.waitForAjaxToFinish();//wait for page to be fully loaded
		CreateMyAccount.click();
		//ExtentManager.getExtentTest().log(LogStatus.PASS, "NavigateToCreateAccountPage", "Success");
	}
	
	public String createAndVerifyAccount() throws InterruptedException
	{
		Utilities.waitForAjaxToFinish();//wait for page to be fully loaded
		GenerateData genData;
		genData=new GenerateData();
		
		 String Pass;	 

		Fname.sendKeys(genData.generateRandomString(10));
		String FirstName = Fname.getAttribute("value");
		System.out.println(FirstName);
		
	    Email.sendKeys(genData.generateEmail(15));
		String EmailAddress = Email.getAttribute("value");
	    ReEnterEmail.sendKeys(EmailAddress);
	    
	    Password.sendKeys(genData.generateRandomAlphaNumeric(10));
	    Pass= Password.getAttribute("value");
	    ReEnterPassword.sendKeys(Pass);
	    
	    SecurityQuestion.findElement(By.cssSelector("option[value=\"pet\"]")).click();
	    SecurityAnswer.sendKeys("Raja");
	    CreateMyAccount2.click();
	
		Utilities.waitForAjaxToFinish();//wait for page to be fully loaded
	
		if(TestCaseConfiguration.driver.get().getPageSource().contains(FirstName+"'s"))	{
		System.out.println("New Account Has Been Successfully Created");

		System.out.println("UserName Is Present");
		}
		else
		{
			System.out.println("UserName Is Not Present");

		
		}
		return EmailAddress+";"+Pass;
	}
}