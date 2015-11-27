package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjects {

	/**
	 * 
	 * All WebElements are identified by @FindBy annotation
	 */

	WebDriver driver;

	@FindBy(id = "loginEmail")
	WebElement Email;

	@FindBy(id = "loginPassword")
	WebElement Password;

	@FindBy(name = "un_jtt_login")
	WebElement LoginBttn;

	@FindBy(xpath = "//div/div[@id='CO_BC_LoginTopCreateAccount']/div/div[3]")
	WebElement CreateAnAccount;

	@FindBy(id = " CO_BC_LoginContinueShopping")
	WebElement ContinueAsAGuest;
	
		

}