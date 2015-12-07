package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Tools.GenerateData;
import Tools.Utilities;


public class CreateAnAccount {
	
	

	WebDriver driver;
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

public CreateAnAccount(WebDriver driver)

{
	this.driver = driver;
  	PageFactory.initElements(driver, this);
	
}

public void CreateAccClick()

{
	//Utilities.waitForAjaxToFinish(30, driver);//wait for page to be fully loaded
	Utilities.explicitlyWait(10000);
	CreateMyAccount.click();
}

public String CreateAndVerifyAccount() throws InterruptedException
{

	 GenerateData genData;
	 genData=new GenerateData();
	
	 String Pass;
	 

	//Fname.sendKeys((CharSequence[]) dict1.get("Fname"));
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

	Utilities.waitForAjaxToFinish(30, driver);//wait for page to be fully loaded


if(driver.getPageSource().contains(FirstName+"'s"))
		
	{
		System.out.println("Text is Present");
		System.out.println(FirstName);

	}
	else
	{
		System.out.println("Text is not Present");

	}
return EmailAddress+";"+Pass;


}


}