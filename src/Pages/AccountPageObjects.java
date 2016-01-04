package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Test.TestCaseConfiguration;

public class AccountPageObjects {

	/**
	 * 
	 * All WebElements are identified by @FindBy annotation
	 */

	WebDriver driver;

	@FindBy(name = "logonId")
	WebElement llbnLogin;

	@FindBy(name = "logonPassword")
	WebElement llbnPassword;

	@FindBy(name = "un_jtt_login")
	WebElement loginButton;

	@FindBy(xpath = "//div[contains(@class, 'llbMAMainVCName matoplistname') and text() = 'L.L.Bean Visa Coupons']")
	WebElement llbeanVisaCoupons;

	@FindBy(xpath = "//div[contains(@class, 'llbMAMLMyProfileTxt mabottomlistname') and text() = 'My Profile']")
	WebElement myProfile;

	@FindBy(xpath = "//div[contains(@class, 'llbMAMLGiftCardsAndPromoCodesTxt mabottomlistname') and text() = 'Gift Cards and Promo Codes']")
	WebElement giftCardsAndPromoCodes;

	@FindBy(xpath = "//div[contains(@class, 'llbMAMLSavedCreditCardsTxt mabottomlistname') and text() = 'Saved Credit Cards']")
	WebElement savedCreditCards;

	@FindBy(xpath = "//div[contains(@class, 'llbMAMLSavedAddressesTxt mabottomlistname') and text() = 'Saved Addresses']")
	WebElement savedAddress;

	@FindBy(xpath = "//div[contains(@class, 'llbMAMLWishListTxt mabottomlistname') and text() = 'Wish List']")
	WebElement wishlist;

	@FindBy(xpath = "//div[contains(@class, 'llbMAMLAccessMyVisaAccTxt mabottomlistname') and text() = 'Access My L.L.Bean Visa Account']")
	WebElement accessMyllbnVisaAccount;

	public AccountPageObjects() {

	  	PageFactory.initElements(TestCaseConfiguration.driver.get(), this);		

	}
	
	public void ClickSavedCC()
	{
		savedCreditCards.click();
		
	}
	
	public void LinkVerification()
	{
		Assert.assertTrue(llbeanVisaCoupons.getText().equals("L.L.Bean Visa Coupons"));
		
		Assert.assertTrue(myProfile.getText().equals("My Profile"));
		
		Assert.assertTrue(giftCardsAndPromoCodes.getText().equals("Gift Cards and Promo Codes"));
				
		Assert.assertTrue(savedCreditCards.getText().equals("Saved Credit Cards"));
		
		Assert.assertTrue(wishlist.getText().equals("Wish List"));
		
		Assert.assertTrue(accessMyllbnVisaAccount.getText().equals("Access My L.L.Bean Visa Account"));
		
	}
	
}
