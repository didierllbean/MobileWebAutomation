package Test;

import org.testng.annotations.Test;

import Pages.ProductPageCore;
import Pages.ShoppingBagPage;
import Tools.Constants;
import Tools.Utilities;

public class CheckoutTestCases extends TestCaseConfiguration
{
	@Test(groups = { "smokeTest", "checkoutOnly" })
	public void fullCheckout(){
		ProductPageCore prodPage = Utilities.goToPDP(Constants.FULLPRICEPDP, driver);
		
		prodPage.selectRandomAttributes(driver);
		ShoppingBagPage shoppingbag = prodPage.addToBagAndGoToSB(driver);
		
		shoppingbag
	}

}
