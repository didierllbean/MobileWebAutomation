package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DataObjects.AddressData;
import Tools.Utilities;

public class CheckoutPageObjects {
	
	AddressData shippingData;
	
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
	WebElement shippingUseAddressAsEnteredButton;
		
	
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
	WebElement billingUseAddressAsEnteredButton;
	
	/** Payment Step Elements **/
	
	@FindBy(id  = "creditRdo")
	WebElement paymentPayWithCreditCardRadioButton;
	
	@FindBy(id  = "paypalRdo")
	WebElement paymentPayWithPayPalRadioButton;
	
	@FindBy(xpath = "//input[@value = 'Continue to PayPal']")
	WebElement paymentContinueToPaypalButton;
	
	@FindBy(id  = "creditCardNum")
	WebElement paymentCreditCardTextfield;
	
	@FindBy(xpath = "//input[@value = 'Continue to Review Order']")
	WebElement paymentContinueToReviewOrderButton;
	
	@FindBy(id  = "promoCodeInput")
	WebElement paymentCouponsAndGiftCardsTextfield;
	
	@FindBy(xpath  = "id('promoInputBlock')//div[@class='redeemTxt']")
	WebElement paymentRedeemCodeButton;
	
	@FindBy(id  = "promoPinInput")
	WebElement paymentGiftCardPinTextfield;
	
	/** Review Step Elements **/
	
	@FindBy(xpath  = "//input[contains(@class,'editOption billingEditLink')]")
	WebElement reviewEditBillingAddressLink;
	
	@FindBy(xpath  = "//input[contains(@class,'editOption paymentEditLink')]")
	WebElement reviewEditPaymentMethodLink;
	
	@FindBy(xpath  = "//input[contains(@class,'Addpromo paymentEditLink')]")
	WebElement reviewAddPromoCodeLink;
	
	@FindBy(xpath  = "//input[contains(@class,'AddVisa paymentEditLink')]")
	WebElement reviewAddVisaLink;
	
	@FindBy(xpath  = "(//input[contains(@class,'editOption shippingEditLink')])[1]")
	WebElement reviewEditShippingAddressAndMehodLink;
	
	@FindBy(xpath = "//input[@value='PLACE YOUR ORDER']")
	WebElement reviewPlaceOrderButton;
	
	@FindBy(xpath = "//input[@value='Return to Shopping Bag']")
	WebElement reviewReturnToSBButton;
	
	
	/** Methods **/ 
	
	protected void selectShippingPersonTitle(WebDriver driver, String title) { 
		Utilities.selectDropDownOption (By.id( "shipPersonTitle" ),  title, driver, CheckoutPageObjects.class);
	}
	
	protected void selectShippingCountry(WebDriver driver, String country) { 
		Utilities.selectDropDownOption (By.id( "shipCountry" ),  country, driver, CheckoutPageObjects.class);
	}
	
	protected void selectShippingState(WebDriver driver, String state) { 
		Utilities.selectDropDownOption (By.id( "shipState" ),  state, driver, CheckoutPageObjects.class);
	}
	
	public AddressData fillDefaultShippingData() {
		shippingFirstNameTextfield.sendKeys("John");
		shippingMiddleNameTextfield.sendKeys("MobileWebTest");
		shippingLastNameTextfield.sendKeys("Doe");
		shippingShipToMaleRadioButton.click();
		shippingAddressLine1Textfield.sendKeys("1221 Main St.");
		shippingZipCodeTextfield.sendKeys("12345");
		shippingZipCodeTextfield.sendKeys(Keys.TAB);
		Utilities.explicitlyWait(3000);//wait for page to be fully loaded
		shippingDayTimePhoneTextfield.sendKeys("5551234567");
		shippingContinueButton.click();
		shippingUseAddressAsEnteredButton.click();
		
		return shippingData = new AddressData(AddressData.SHIPPING, "Me", "", "John", "MobileWebTest", "Doe", "", "UNITED STATES", "1221 Main St.", "", "12345",
				"", "", "5551234567", AddressData.FREE, "", ""); 
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////
	
	protected void selectBillingPersonTitle(WebDriver driver, String title) { 
		Utilities.selectDropDownOption (By.id( "billPersonTitle" ),  title, driver, CheckoutPageObjects.class);
	}
	
	protected void selectBillingCountry(WebDriver driver, String country) { 
		Utilities.selectDropDownOption (By.id( "billCountry" ),  country, driver, CheckoutPageObjects.class);
	}
	
	protected void selectBillingState(WebDriver driver, String state) { 
		Utilities.selectDropDownOption (By.id( "billState" ),  state, driver, CheckoutPageObjects.class);
	}
	
	public AddressData fillDefaultBillingData() {
		String email = "mobiletest@automation.com";
		
		billingEmailTextfield.sendKeys(email);
		billingReenterEmailTextfield.sendKeys(email);
		billingContinueButton.click();
		
		return new AddressData(AddressData.BILLING, "", "", shippingData.getFirstName(), shippingData.getMiddleName(), shippingData.getLastName(), "", shippingData.getCountry(), 
				shippingData.getAddress1(), shippingData.getAddress2(), shippingData.getZipCode(), shippingData.getCity(), shippingData.getState(), shippingData.getDaytimePhone(), 
				"", email, "");		
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////
		
	protected void selectPaymentCCExpirationDate(WebDriver driver, String month, String year) { 	
		Utilities.selectDropDownOption (By.id( "ccExpMonth" ),  month, driver, CheckoutPageObjects.class);		
		Utilities.selectDropDownOption (By.id( "ccExpYear" ),  year, driver, CheckoutPageObjects.class);	
	}
	
	public void fillDefaultPaymentData(WebDriver driver) {
		Utilities.explicitlyWait(2000);
		paymentCreditCardTextfield.sendKeys("4444444444444448");
		selectPaymentCCExpirationDate(driver, "12", "2030");
		paymentContinueToReviewOrderButton.click();
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////

	public ThankYouPageObjects goToThankYouPage(WebDriver driver) {
		reviewPlaceOrderButton.click();
		return PageFactory.initElements(driver, ThankYouPageObjects.class);
	}
}
