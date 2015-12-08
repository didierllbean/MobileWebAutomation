package Test;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import DataObjects.AddressData;
import DataObjects.ProductData;
import Pages.CheckoutPageObjects;
import Pages.LoginPageObjects;
import Pages.ProductPageCore;
import Pages.ShoppingBagPage;
import Pages.ThankYouPageObjects;
import Tools.Constants;
import Tools.Utilities;

public class CheckoutTestCases extends TestCaseConfiguration
{
	private ProductData productData;
	private AddressData shippingAddress, billingAddress;
	
	@Test(groups = { "smokeTest", "checkoutOnly" })
	public void fullGuestCheckout(){
		extent.startTest("FullCheckoutAsGuest");
		
		ProductPageCore prodPage = Utilities.goToPDP(Constants.FULLPRICEPDP, driver);
		extent.log(LogStatus.PASS, "NavigateToProductPage", "Success");
	    
		productData = prodPage.selectRandomAttributes(driver);
		extent.log(LogStatus.PASS, "RandomAttributesSelection", "Success");
	    

		ShoppingBagPage shoppingbag = prodPage.addToBagAndGoToSB(driver);		
		extent.log(LogStatus.PASS, "AddToBagAndGoToSB", "Success");
	    
		LoginPageObjects login = shoppingbag.startCheckoutProcessAsGuest(driver);
		extent.log(LogStatus.PASS, "StartCheckout", "Success");
	    
		Utilities.waitForAjaxToFinish(30, driver);//wait for page to be fully loaded
		CheckoutPageObjects checkout = login.continueAsGuest(driver, CheckoutPageObjects.class);
		extent.log(LogStatus.PASS, "ContinueAsGuest", "Success");
	    
		Utilities.waitForAjaxToFinish(30, driver);//wait for page to be fully loaded
		shippingAddress = checkout.fillDefaultShippingData();
		extent.log(LogStatus.PASS, "EnterShippingAdress", "Success");
	    
		Utilities.waitForAjaxToFinish(30, driver);//wait for page to be fully loaded
		billingAddress = checkout.fillDefaultBillingData();
		extent.log(LogStatus.PASS, "BASASA", "Success");
	    
		Utilities.waitForAjaxToFinish(30, driver);//wait for page to be fully loaded
		checkout.fillDefaultPaymentData(driver);
		extent.log(LogStatus.PASS, "EnterPaymentData", "Success");	    

		Utilities.waitForAjaxToFinish(30, driver);//wait for page to be fully loaded
		ThankYouPageObjects typage = checkout.goToThankYouPage(driver);
		extent.log(LogStatus.PASS, "PlaceOrder", "Success");
	    		
		Utilities.waitForAjaxToFinish(30, driver);//wait for page to be fully loaded
		typage.verifyProductBasicAttributes(productData, driver);
		typage.verifyShippingAddress(shippingAddress, driver);
		typage.verifyBillingAddress(billingAddress, driver);
		extent.log(LogStatus.PASS, "TYPageValidations", "Success");
	}

}
