package Test;

import org.testng.annotations.Test;

import Pages.CheckoutPageObjects;
import Pages.FooterObjects;
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
	

	/*@Test(groups = { "smokeTest"})
	public void ShoppingBagRUMergeAndCheckoutWithNOCC() {		
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
		prodPage = Utilities.goToPDP(Constants.FULLPRICEPDP);		
		prodPage.selectRandomAttributes();
		shoppingbag = prodPage.addToBagAndGoToSB();
		
		login = new FooterObjects().NavigateToLoginPage();
		shoppingbag = login.login(Constants.FULLINFOACCOUNT, Constants.PASSWORD, ShoppingBagPage.class);
		shoppingbag.clearSB()
					.isSBEmpty();	
	}*/

	@Test(groups = { "smokeTest"})
	public void ShoppingBagGu(){
		prodPage = Utilities.goToPDP(Constants.FULLPRICEPDP);		
		prodPage.selectRandomAttributes();
		Utilities.explicitlyWait(5000);
		shoppingbag = prodPage.addToBagAndGoToSB();
		shoppingbag.FullPriceItem();
		Utilities.explicitlyWait(2000);	
		
		prodPage = Utilities.goToPDP(Constants.SALEPRICEPDP);		
		prodPage.selectRandomAttributes();
		shoppingbag = prodPage.addToBagAndGoToSB();
		shoppingbag.SalePriceItem();
		Utilities.explicitlyWait(2000);
		
		shoppingbag.PromoCodeVerification();
		Utilities.explicitlyWait(5000);
		shoppingbag.AddNewRecipient();		
		shoppingbag.ShoppingBagTitleVerification();	
		shoppingbag.ClickCheckOut();
			
        }	
}
