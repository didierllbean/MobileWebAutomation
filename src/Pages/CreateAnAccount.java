package Pages;

import java.util.Dictionary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;




public class CreateAnAccount {

	WebDriver driver;

	//Fetch obj=new Fetch();
	//Dictionary dict1=obj.readfromExcel();

	
	//Fetch excelreader;



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

	@FindBy(id = "id_srfSecuAnsTxt")
	WebElement SecuirtyAnswer;

	@FindBy(xpath = "/html/body/div[2]/div[2]/div[3]/div[1]/div/div[4]/div[4]/div/div[3]/input")
	WebElement CreateMyAccount;



public void CreateAccount(WebDriver driver)

{
	this.driver = driver;
  	PageFactory.initElements(driver, this);
  	CreateMyAccount.click();
	
}

public void EnterInfo(WebDriver driver)
{
	
	//Fname.sendkeys(dict1("Fname"));
	//Fname.sendkeys(dict1("Lname"));
	Fname.sendKeys("shavaiz");

}
}