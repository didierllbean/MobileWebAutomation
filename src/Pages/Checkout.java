package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Tools.Utilities;

public class Checkout {
	
	/**
	 * WebElements
	 */
	
	/** General Elements **/

	@FindBy(linkText  = "Edit Shopping Bag")
	WebElement checkoutEditSBLink;
	
	@FindBy(xpath  = "//div[contains(@class, 'un_center') and contains(.,'Shipping')]")
	WebElement checkoutShippingTabTitle;
	
	@FindBy(xpath  = "//div[contains(@class, 'un_center') and contains(.,'Billing')]")
	WebElement checkoutBillingTabTitle;
	
	@FindBy(xpath  = "//div[contains(@class, 'un_center') and contains(.,'Payment')]")
	WebElement checkoutPaymentTabTitle;
	
	@FindBy(xpath  = "//div[contains(@class, 'un_center') and contains(.,'Review')]")
	WebElement checkoutReviewTabTitle;
	
	/** Shipping Step Elements **/
	
	@FindBy(linkText  = "Ship to someone else")
	WebElement shippingShipNotMeLink;
	
	@FindBy(id  = "shipPersonTitle")
	WebElement shippingSelectTitleDropDown;
	
	@FindBy(id  = "shipFirstName")
	WebElement shippingFirstNameTextfield;
	
	@FindBy(id  = "shipMiddleName")
	WebElement shippingMiddleNameTextfield;
	
	@FindBy(id  = "shipLastName")
	WebElement shippingLastNameTextfield;
	
	@FindBy(id  = "shipMale")
	WebElement shippingShipToMaleRadioButton;
	
	@FindBy(id  = "shipFemale")
	WebElement shippingShipToFamaleRadioButton;
	
	@FindBy(xpath  = "//a[contains(@class, ' editCountry')]")
	WebElement shippingEditCountryLink;
	
	@FindBy(id  = "")
	WebElement shippingSelectCountryDropDown;
	
	
	/** Billing Step Elements **/
	
	/** Payment Step Elements **/
	
	/** Review Step Elements **/
	
	/** Methods **/ 
	
	protected void selectCountry(WebDriver driver, String country) { 
		Utilities.selectDropDownOption (By.id( "shipCountry" ),  "option", driver, Checkout.class);
	}
	
	//div[contains(@class, 'Selected')]
}
