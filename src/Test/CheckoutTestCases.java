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
import Tools.ExtentManager;
import Tools.Utilities;

public class CheckoutTestCases extends TestCaseConfiguration
{
	private ProductData productData;
	private AddressData shippingAddress, billingAddress;
	
	@Test(groups = { "smokeTest", "checkoutOnly" })
	public void fullGuestCheckout(){
		ExtentManager.setExtentTest(REPORTMANAGER, Thread.currentThread().getStackTrace()[1].getMethodName());
		
		ProductPageCore prodPage = Utilities.goToPDP(Constants.FULLPRICEPDP);	    
		productData = prodPage.selectRandomAttributes();
	    
		ShoppingBagPage shoppingbag = prodPage.addToBagAndGoToSB();		    
		LoginPageObjects login = shoppingbag.startCheckoutProcessAsGuest();
	    
		CheckoutPageObjects checkout = login.continueAsGuest(CheckoutPageObjects.class);	    
		shippingAddress = checkout.fillDefaultShippingData();	    
		billingAddress = checkout.fillDefaultBillingData();	    
		checkout.fillDefaultPaymentData();    

		ThankYouPageObjects typage = checkout.goToThankYouPage();	    
		typage.verifyProductBasicAttributes(productData);
		typage.verifyShippingAddress(shippingAddress);
		typage.verifyBillingAddress(billingAddress);
	}
}
