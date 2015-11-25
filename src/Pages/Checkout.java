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
	
	@FindBy(xpath  = "//a[contains(@class, 'editCountry')]")
	WebElement shippingEditCountryLink;
	
	@FindBy(id  = "shipAddress1")
	WebElement shippingAddressLine1Textfield;

	@FindBy(id  = "shipAddress2")
	WebElement shippingAddressLine2Textfield;
	
	@FindBy(id  = "shipZipCode")
	WebElement shippingZipCodeTextfield;
	
	@FindBy(id  = "shipCity")
	WebElement shippingCityTextfield;
	
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
	
	@FindBy(id  = "ckoutSameAsShip")
	WebElement billingBASASACheckbox;
	
	@FindBy(id  = "billFirstName")
	WebElement billingFirstNameTextfield;
	
	@FindBy(id  = "billMiddleName")
	WebElement billingMiddleNameTextfield;
	
	@FindBy(id  = "billLastName")
	WebElement billingLastNameTextfield;
	
	@FindBy(id  = "billMale")
	WebElement billingMaleCheckbox;
	
	@FindBy(id  = "billFemale")
	WebElement billingFemaleCheckbox;
	
	@FindBy(xpath  = "//a[contains(@class, 'editCountry')]")
	WebElement billingEditCountryLink;
	
	@FindBy(id  = "billAddress1")
	WebElement billingAddressLine1Textfield;

	@FindBy(id  = "billAddress2")
	WebElement billingAddressLine2Textfield;
	
	@FindBy(id  = "billZipCode")
	WebElement billingZipCodeTextfield;
	
	@FindBy(id  = "billCity")
	WebElement billingCityTextfield;
	
	@FindBy(id  = "billHomeAddress")
	WebElement billingAddressTypeHomeRadioButton;
	
	@FindBy(id  = "billBizAddress")
	WebElement billingAdressTypeBusinessRadioButton;
	
	@FindBy(id  = "billDaytimePhone")
	WebElement billingDayTimePhoneTextfield;
	
	@FindBy(id  = "billHomePhone")
	WebElement billingPhoneTypeHomeRadioButton;
	
	@FindBy(id  = "billWorkPhone")
	WebElement billingPhoneTypeWorkRadioButton;
	
	@FindBy(id  = "billMobilePhone")
	WebElement billingPhoneTypeMobileRadioButton;
	
	@FindBy(id  = "enterEmail")
	WebElement billingEmailTextfield;
	
	@FindBy(id  = "verifyEmail")
	WebElement billingReenterEmailTextfield;
	
	@FindBy(id  = "ckoutSentmeEmail")
	WebElement billingPromoEmailsCheckbox;
	
	@FindBy(id  = "eveningPhone")
	WebElement billingEveningPhoneTextfield;
	
	@FindBy(id  = "billHomePhone2")
	WebElement billingPhone2TypeHomeRadioButton;
	
	@FindBy(id  = "billWorkPhone2")
	WebElement billingPhone2TypeWorkRadioButton;
	
	@FindBy(id  = "billMobilePhone2")
	WebElement billingPhone2TypeMobileRadioButton;
	
	@FindBy(xpath = "//input[@value='CONTINUE TO PAYMENT OPTIONS']")
	WebElement billingContinueButton;
	
	@FindBy(linkText  = "Return to Shopping Address")
	WebElement billingReturnToSBButton;
	
	@FindBy(xpath = "//input[@value='USE AS ENTERED']")
	WebElement billingUseAddressButton;
	
	/** Payment Step Elements **/
	
	/** Review Step Elements **/
	
	/** Methods **/ 
	
	protected void selectShippingPersonTitle(WebDriver driver, String country) { 
		Utilities.selectDropDownOption (By.id( "shipPersonTitle" ),  "option", driver, Checkout.class);
	}
	
	protected void selectShippingCountry(WebDriver driver, String country) { 
		Utilities.selectDropDownOption (By.id( "shipCountry" ),  "option", driver, Checkout.class);
	}
	
	protected void selectShippingState(WebDriver driver, String country) { 
		Utilities.selectDropDownOption (By.id( "shipState" ),  "option", driver, Checkout.class);
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////
	
	protected void selectBillingPersonTitle(WebDriver driver, String country) { 
		Utilities.selectDropDownOption (By.id( "billPersonTitle" ),  "option", driver, Checkout.class);
	}
	
	protected void selectBillingCountry(WebDriver driver, String country) { 
		Utilities.selectDropDownOption (By.id( "billCountry" ),  "option", driver, Checkout.class);
	}
	
	protected void selectBillingState(WebDriver driver, String country) { 
		Utilities.selectDropDownOption (By.id( "billState" ),  "option", driver, Checkout.class);
	}
	
}
