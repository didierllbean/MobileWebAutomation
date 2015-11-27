package Pages;

import java.util.Dictionary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Util.Fetch;

public class AccountPageObjects {

	/**
	 * 
	 * All WebElements are identified by @FindBy annotation
	 */

	WebDriver driver;

	@FindBy(name = "logonId")
	WebElement LLBLogin;

	@FindBy(name = "logonPassword")
	WebElement LLBPassword;

	@FindBy(name = "un_jtt_login")
	WebElement LoginBttn;

	@FindBy(xpath = "//div[contains(@class, 'llbMAMainVCName matoplistname') and text() = 'L.L.Bean Visa Coupons']")
	WebElement LLBEANVISACOUPONS;

	@FindBy(xpath = "//div[contains(@class, 'llbMAMLMyProfileTxt mabottomlistname') and text() = 'My Profile']")
	WebElement MyProfile;

	@FindBy(xpath = "//div[contains(@class, 'llbMAMLGiftCardsAndPromoCodesTxt mabottomlistname') and text() = 'Gift Cards and Promo Codes']")
	WebElement GiftCardAndPromoCodes;

	@FindBy(xpath = "//div[contains(@class, 'llbMAMLSavedCreditCardsTxt mabottomlistname') and text() = 'Saved Credit Cards']")
	WebElement SavedCreditCards;

	@FindBy(xpath = "//div[contains(@class, 'llbMAMLSavedAddressesTxt mabottomlistname') and text() = 'Saved Addresses']")
	WebElement SavedAddresses;

	@FindBy(xpath = "//div[contains(@class, 'llbMAMLWishListTxt mabottomlistname') and text() = 'Wish List']")
	WebElement WishList;

	@FindBy(xpath = "//div[contains(@class, 'llbMAMLAccessMyVisaAccTxt mabottomlistname') and text() = 'Access My L.L.Bean Visa Account']")
	WebElement AccessMyLLBVisaAcount;

	public void Login(WebDriver driver) throws InterruptedException {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
}
