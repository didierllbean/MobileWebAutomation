package Test;

import org.testng.annotations.Test;

import Pages.CheckoutPageObjects;
import Pages.LoginPageObjects;
import Pages.ProductPageCore;
import Pages.ShoppingBagPage;
import Tools.Constants;
import Tools.Utilities;

public class CheckoutTestCases extends TestCaseConfiguration
{
	@Test(groups = { "smokeTest", "checkoutOnly" })
	public void fullGuestCheckout(){
		ProductPageCore prodPage = Utilities.goToPDP(Constants.FULLPRICEPDP, driver);
		
		prodPage.selectRandomAttributes(driver);
		
		ShoppingBagPage shoppingbag = prodPage.addToBagAndGoToSB(driver);		
		LoginPageObjects login = shoppingbag.startCheckoutProcessAsGuest(driver);
		CheckoutPageObjects checkout = login.continueAsGuest(driver, CheckoutPageObjects.class);
		checkout.fillDefaultShippingData();
	}

}
