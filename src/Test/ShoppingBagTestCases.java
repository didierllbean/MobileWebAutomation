package Test;


import org.testng.annotations.Test;

import Pages.CheckoutPageObjects;
import Pages.FooterObjects;
import Pages.HeaderObjects;
import Pages.LoginPageObjects;
import Pages.ProductPageCore;
import Pages.ShoppingBagPage;
import Tools.Constants;
import Tools.ExtentManager;
import Tools.Utilities;

public class ShoppingBagTestCases extends TestCaseConfiguration {
	private CheckoutPageObjects checkout;
	private ProductPageCore prodPage;
	private ShoppingBagPage shoppingbag;
	private LoginPageObjects login;

	@Test(groups = { "smokeTest"})
	public void ShoppingBagRUMergeAndCheckoutWithNOCC() {
		ExtentManager.setExtentTest(REPORTMANAGER, Thread.currentThread().getStackTrace()[1].getMethodName());
		
		prodPage = Utilities.goToPDP(Constants.FULLPRICEPDP);		
		prodPage.selectRandomAttributes();		
		shoppingbag = prodPage.addToBagAndGoToSB();
		
		login = shoppingbag.startCheckoutProcessAsGuest();		
		shoppingbag = login.login(Constants.NOCCACCOUNT, Constants.PASSWORD, ShoppingBagPage.class);				
		shoppingbag.validateMergeMessage();
		
		checkout = shoppingbag.startCheckoutProcess();
		checkout.validateLandingStep(checkout.PAYMENTSTEP);
	}
	
	@Test(groups = { "smokeTest"})
	public void ShoppingBagRUCheckoutWithAllData() {
		ExtentManager.setExtentTest(REPORTMANAGER, Thread.currentThread().getStackTrace()[1].getMethodName());
		
		prodPage = Utilities.goToPDP(Constants.FULLPRICEPDP);		
		prodPage.selectRandomAttributes();		
		shoppingbag = prodPage.addToBagAndGoToSB();
		
		login = shoppingbag.startCheckoutProcessAsGuest();		
		shoppingbag = login.login(Constants.FULLINFOACCOUNT, Constants.PASSWORD, ShoppingBagPage.class);				
		
		checkout = shoppingbag.startCheckoutProcess();
		checkout.validateLandingStep(checkout.REVIEWSTEP);
	}
	
	@Test(groups = { "smokeTest"})
	public void ShoppingBagRUClearSB() {
		ExtentManager.setExtentTest(REPORTMANAGER, Thread.currentThread().getStackTrace()[1].getMethodName());
		prodPage = Utilities.goToPDP(Constants.FULLPRICEPDP);		
		prodPage.selectRandomAttributes();
		shoppingbag = prodPage.addToBagAndGoToSB();
		
		login = new FooterObjects().NavigateToLoginPage();
		shoppingbag = login.login(Constants.FULLINFOACCOUNT, Constants.PASSWORD, ShoppingBagPage.class);
		shoppingbag.clearSB()
					.isSBEmpty();	
	}
}
