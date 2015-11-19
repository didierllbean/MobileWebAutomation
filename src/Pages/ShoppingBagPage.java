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
	
	@FindBy(id  = "shipMeRadio")
	WebElement sbShiptoMeRadioButton;
	
	@FindBy(id  = "shipOtherRadio")
	WebElement sbShiptoMultipleAddressesRadioButton;

	protected WebElement getProductInSB(String productID) {
		WebElement emailInputField = driver.findElement(By.xpath("//div[@class = 'sbItemAttributes']/div[contains(.,'209410')]/../../.."));
	}
}
