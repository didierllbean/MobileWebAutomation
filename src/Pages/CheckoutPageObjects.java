package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;

import DataObjects.AddressData;
import Test.TestCaseConfiguration;
import Tools.ExtentManager;
import Tools.Utilities;

public class CheckoutPageObjects {
	
	private AddressData shippingData;
	public final String SHIPPINGSTEP = "shipping",
						BILLINGSTEP = "Billing",
						PAYMENTSTEP = "Payment",
						REVIEWSTEP = "Review";
	
	/*
	 * WebElements
	 */
	
	/* General Elements */

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
	
	/* Shipping Step Elements */
	
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
		
	
	/* Billing Step Elements */
	
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
	
	/* Payment Step Elements */
	
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
	
	/* Review Step Elements */
	
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
	
	
	/* Methods */ 
	
	/**
	 * Select the desired title in the Title dropdown element in shipping page.
	 * @param driver current webdriver in use.
	 * @param title desired title
	 * 
	 *  @author Yohan Desanti G.  
	 *  @LastUpdate Yohan Desanti G.
	 *  @version 1.0, 11/24/2015
	 */
	protected void selectShippingPersonTitle(String title) { 
		Utilities.selectDropDownOption (By.id( "shipPersonTitle" ),  title, TestCaseConfiguration.driver.get(), CheckoutPageObjects.class);
	}
	
	/**
	 * Select the desired Country in the Country dropdown element in shipping page.
	 * @param driver current driver in use.
	 * @param country desired country
	 * 
	 *  @author Yohan Desanti G.  
	 *  @LastUpdate Yohan Desanti G.
	 *  @version 1.0, 11/24/2015
	 */
	protected void selectShippingCountry(String country) { 
		Utilities.selectDropDownOption (By.id( "shipCountry" ),  country, TestCaseConfiguration.driver.get(), CheckoutPageObjects.class);
	}
	
	/**
	 * Select the desired State in the state dropdown element in shipping page.
	 * @param driver current webdriver in use.
	 * @param state desired state
	 * 
	 *  @author Yohan Desanti G.  
	 *  @LastUpdate Yohan Desanti G.
	 *  @version 1.0, 11/24/2015
	 */
	protected void selectShippingState(String state) { 
		Utilities.selectDropDownOption (By.id( "shipState" ),  state, TestCaseConfiguration.driver.get(), CheckoutPageObjects.class);
	}
	
	/**
	 * Enter default predefined data in the Checkout's Shipping page.
	 * @return A Shipping Address object which contains all the information entered.
	 * 
	 *  @author Yohan Desanti G.  
	 *  @LastUpdate Yohan Desanti G.
	 *  @version 1.0, 11/24/2015
	 */
	public AddressData fillDefaultShippingData() {
		Utilities.explicitlyWait(4000);
		Utilities.waitForAjaxToFinish();
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
	
	/**
	 * Select the desired title in the Title dropdown element in billing page.
	 * @param driver current webdriver in use.
	 * @param title desired title
	 * 
	 *  @author Yohan Desanti G.  
	 *  @LastUpdate Yohan Desanti G.
	 *  @version 1.0, 11/24/2015
	 */
	protected void selectBillingPersonTitle(String title) { 
		Utilities.selectDropDownOption (By.id( "billPersonTitle" ),  title, TestCaseConfiguration.driver.get(), CheckoutPageObjects.class);
	}
	
	/**
	 * Select the desired Country in the Country dropdown element in billing page.
	 * @param driver current driver in use.
	 * @param country desired country
	 * 
	 *  @author Yohan Desanti G.  
	 *  @LastUpdate Yohan Desanti G.
	 *  @version 1.0, 11/24/2015
	 */
	protected void selectBillingCountry(String country) { 
		Utilities.selectDropDownOption (By.id( "billCountry" ),  country, TestCaseConfiguration.driver.get(), CheckoutPageObjects.class);
	}
	
	/**
	 * Select the desired State in the state dropdown element in billing page.
	 * @param driver current webdriver in use.
	 * @param state desired state
	 * 
	 *  @author Yohan Desanti G.  
	 *  @LastUpdate Yohan Desanti G.
	 *  @version 1.0, 11/24/2015
	 */
	protected void selectBillingState(String state) { 
		Utilities.selectDropDownOption (By.id( "billState" ),  state, TestCaseConfiguration.driver.get(), CheckoutPageObjects.class);
	}
	
	/**
	 * Enter default predefined data in the Checkout's Billing page. By default use BASASA option.
	 * @return A Billing Address object which contains all the information entered.
	 * 
	 *  @author Yohan Desanti G.  
	 *  @LastUpdate Yohan Desanti G.
	 *  @version 1.0, 11/24/2015
	 */
	public AddressData fillDefaultBillingData() {	
		Utilities.explicitlyWait(3000);	
		String email = "mobiletest@automation.com";
		
		billingEmailTextfield.sendKeys(email);
		billingReenterEmailTextfield.sendKeys(email);
		billingContinueButton.click();
		
		return new AddressData(AddressData.BILLING, "", "", shippingData.getFirstName(), shippingData.getMiddleName(), shippingData.getLastName(), "", shippingData.getCountry(), 
				shippingData.getAddress1(), shippingData.getAddress2(), shippingData.getZipCode(), shippingData.getCity(), shippingData.getState(), shippingData.getDaytimePhone(), 
				"", email, "");		
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////
		
	/**
	 * Select the expiration date for a credit card in the Checkout's Payment page.
	 * @param driver current webdriver in use.
	 * @param month month number of the expiration date.
	 * @param year year of the expiration date
	 * 
	 *  @author Yohan Desanti G.  
	 *  @LastUpdate Yohan Desanti G.
	 *  @version 1.0, 11/24/2015
	 */
	protected void selectPaymentCCExpirationDate(String month, String year) { 	
		Utilities.selectDropDownOption (By.id( "ccExpMonth" ),  month, TestCaseConfiguration.driver.get(), CheckoutPageObjects.class);		
		Utilities.selectDropDownOption (By.id( "ccExpYear" ),  year, TestCaseConfiguration.driver.get(), CheckoutPageObjects.class);	
	}
	
	/**
	 * Enter default predefined data in the Checkout's Payment page. By default use Credit Card option.
	 * @return A Payment Address object which contains all the information entered.
	 * 
	 *  @author Yohan Desanti G.  
	 *  @LastUpdate Yohan Desanti G.
	 *  @version 1.0, 11/24/2015
	 */
	public void fillDefaultPaymentData() {
		Utilities.waitForAjaxToFinish();
		Utilities.explicitlyWait(10000);
		paymentCreditCardTextfield.sendKeys("4444444444444448");
		selectPaymentCCExpirationDate("12", "2030");
		paymentContinueToReviewOrderButton.click();
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Click on the Place Order button
	 * @param driver current webdriver in use.
	 * @return Thankyou page object
	 * 
	 *  @author Yohan Desanti G.  
	 *  @LastUpdate Yohan Desanti G.
	 *  @version 1.0, 11/24/2015
	 */
	public ThankYouPageObjects goToThankYouPage() {
		Utilities.explicitlyWait(4000);
		reviewPlaceOrderButton.click();
		return PageFactory.initElements(TestCaseConfiguration.driver.get(), ThankYouPageObjects.class);
	}

	public void validateLandingStep(String expectedTab) {
		if(Utilities.isElementPresent(TestCaseConfiguration.driver.get(), By.xpath("//div[contains(@class,'checkOutMenuTxt') and contains(@class,'SelectedTab') ]"))) {
			WebElement selectedCheckoutTab = TestCaseConfiguration.driver.get().findElement(By.xpath("//div[contains(@class,'checkOutMenuTxt') and contains(@class,'SelectedTab') ]"));
			
			/*if(selectedCheckoutTab.getText().equals(expectedTab))
				ExtentManager.getExtentTest().log(LogStatus.PASS, "CheckoutPaymentPage", "Success");
			else
				ExtentManager.getExtentTest().log(LogStatus.FAIL, "CheckoutPaymentPage", "Tab Title is not "+expectedTab);*/
		}
		/*else
			ExtentManager.getExtentTest().log(LogStatus.FAIL, "CheckoutPaymentPage", "Payment Tab Not Found");	*/	
	}
}
