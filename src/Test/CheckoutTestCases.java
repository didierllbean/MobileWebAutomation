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
	
	/**
	 * @author ydesanti
	 * @version 1.0
	 * @lastUpdate 01/26/2016
	 */
	@Test(groups = { "smokeTest", "checkoutOnly" })//Related Issue LLBN-4975 is present for billing address step, This test will fail until the mentioned issue is fixed 
	public void fullGuestCheckout(){
		
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