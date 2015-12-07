package Test;

import org.testng.annotations.Test;

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
		
		ProductPageCore prodPage = Utilities.goToPDP(Constants.FULLPRICEPDP, driver);
		
		productData = prodPage.selectRandomAttributes(driver);

		ShoppingBagPage shoppingbag = prodPage.addToBagAndGoToSB(driver);		
		LoginPageObjects login = shoppingbag.startCheckoutProcessAsGuest(driver);

		Utilities.waitForAjaxToFinish(30, driver);//wait for page to be fully loaded
		CheckoutPageObjects checkout = login.continueAsGuest(driver, CheckoutPageObjects.class);
		
		Utilities.waitForAjaxToFinish(30, driver);//wait for page to be fully loaded
		shippingAddress = checkout.fillDefaultShippingData();
		
		Utilities.waitForAjaxToFinish(30, driver);//wait for page to be fully loaded
		billingAddress = checkout.fillDefaultBillingData();
		
		Utilities.waitForAjaxToFinish(30, driver);//wait for page to be fully loaded
		checkout.fillDefaultPaymentData(driver);

		Utilities.waitForAjaxToFinish(30, driver);//wait for page to be fully loaded
		ThankYouPageObjects typage = checkout.goToThankYouPage(driver);
		
		Utilities.waitForAjaxToFinish(30, driver);//wait for page to be fully loaded
		typage.verifyProductBasicAttributes(productData, driver);
		typage.verifyShippingAddress(shippingAddress, driver);
		typage.verifyBillingAddress(billingAddress, driver);
	}

}
