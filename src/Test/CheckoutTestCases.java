package Test;

import org.testng.annotations.Test;

import Pages.ProductPageCore;
import Tools.Constants;
import Tools.Utilities;

public class CheckoutTestCases extends TestCaseConfiguration
{
	@Test(groups = { "smokeTest", "checkoutOnly" })
	public void fullCheckout(){
		ProductPageCore prodPage = Utilities.goToPDP(Constants.FULLPRICEPDP, driver);
		
		prodPage.selectRandomColorAttribute(driver);
		prodPage.addToBagAndContinueShopping(driver);
	}

}
