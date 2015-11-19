package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingBagPage {

	
	/**
	 * WebElements
	 */
	
	/** General Elements **/
	
	@FindBy(xpath  = "(//input[@value='Check Out'])[1]")
	WebElement sbCheckoutButton;
	
	@FindBy(xpath  = "(//input[@value='Check out with'])[1]")
	WebElement sbCheckoutWithPaypalButton;
	
	@FindBy(id  = "shipMeRadio")
	WebElement sbShiptoMeRadioButton;
	
	@FindBy(id  = "promoNumber")
	WebElement sbPromoCodeTextField;
	
	@FindBy(xpath  = "//input[@value = 'Redeem']")
	WebElement sbPromoCodeRedeemButton;
	
	@FindBy(id  = "shipOtherRadio")
	WebElement sbShiptoMultipleAddressesRadioButton;
	
	@FindBy(xpath  = "id('un_clearcart')//a")
	WebElement sbGoToWLLink;
	
	@FindBy(xpath  = "id('clearSB')/span")
	WebElement sbClearSBLink;

	protected WebElement getProductInSB(String productID) {
		WebElement emailInputField = driver.findElement(By.xpath("//div[@class = 'sbItemAttributes']/div[contains(.,'209410')]/../../.."));
	}
}
