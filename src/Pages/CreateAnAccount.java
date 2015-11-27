package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

	@FindBy(id = "id_srfSecuAnsTxt")
	WebElement SecuirtyAnswer;

	@FindBy(xpath = "//div[@class='srfCreatAccBtnTxt' and contains(text(), 'Create My Account")
	WebElement CreateMyAccount;

}
