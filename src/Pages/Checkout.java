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
	
	@FindBy(id  = "shipAddress1")
	WebElement shippingAddressLine1Textfield;

	@FindBy(id  = "shipAddress2")
	WebElement shippingAddressLine2Textfield;
	
	@FindBy(id  = "shipZipCode")
	WebElement shippingZipCodeTextfield;
	
	@FindBy(id  = "shipCity")
	WebElement shippingCityTextfield;
	
	@FindBy(id  = "shipState")
	WebElement shippingStateTextfield;
	
	@FindBy(id  = "shipHomeAddress")
	WebElement shippingAddressTypeHomeRadioButton;
	
	@FindBy(id  = "shipBizAddress")
	WebElement shippingAdressTypeBusinessRadioButton;
	
	@FindBy(id  = "shipDaytimePhone")
	WebElement shippingDayTimePhoneTextfield;
	
	@FindBy(id  = "shipHomePhone")
	WebElement shippingPhoneTypeHomeRadioButton;
	
	@FindBy(id  = "shipWorkPhone")
	WebElement shippingPhoneTypeWorkRadioButton;
	
	@FindBy(id  = "shipMobilePhone")
	WebElement shippingPhoneTypeMobileRadioButton;
	
	@FindBy(id  = "shipCkoutShippingCheck")
	WebElement shippingIncludePhoneCheckbox;
	
	@FindBy(xpath = "//input[@value='CONTINUE TO BILLING ADDRESS']")
	WebElement shippingContinueButton;
	
	@FindBy(linkText  = "Return to Shopping Bag")
	WebElement shippingReturnToSBButton;
	
	@FindBy(xpath = "//input[@value='USE AS ENTERED']")
	WebElement shippingUseAddressButton;
		
	
	/** Billing Step Elements **/
	
	/** Payment Step Elements **/
	
	/** Review Step Elements **/
	
	/** Methods **/ 
	
	protected void selectCountry(WebDriver driver, String country) { 
		Utilities.selectDropDownOption (By.id( "shipCountry" ),  "option", driver, Checkout.class);
	}
	
	//div[contains(@class, 'Selected')]
}
