package Test;

import org.testng.annotations.Test;

import Pages.AccountPageObjects;
import Pages.CreditCardDetailPageObjects;
import Pages.FooterObjects;
import Pages.HomePageObjects;
import Pages.LoginPageObjects;
import Pages.SavedCreditCardsPageObjects;
import Tools.Constants;
import Tools.Utilities;

public class AccountTestCases extends TestCaseConfiguration {
	
	@Test(groups = {"smokeTest"})
	  public void AccountAU() {
		  
		  FooterObjects footer = new FooterObjects();
		  LoginPageObjects Login;
		  HomePageObjects homepage= new HomePageObjects();
		  AccountPageObjects account = new AccountPageObjects();
		  SavedCreditCardsPageObjects paymentmethods = new SavedCreditCardsPageObjects();
		  CreditCardDetailPageObjects creditcard = new CreditCardDetailPageObjects();	 
		  Login = footer.NavigateToLoginPage();
		
		  homepage = Login.login(Constants.NEWCCACCOUNT, Constants.CCPASSWORD, HomePageObjects.class);	
		  Utilities.waitForAjaxToFinish();
		  Utilities.explicitlyWait(3000);
		  
		  
		  footer.clickUserAccountName();
		  Utilities.waitForAjaxToFinish();
		  Utilities.explicitlyWait(3000);
		  
		  account.linkVerification();
		  Utilities.waitForAjaxToFinish();
		  Utilities.explicitlyWait(3000);


		  account.clickSavedCC();
		  Utilities.waitForAjaxToFinish();
		  Utilities.explicitlyWait(3000);



		  paymentmethods.ClickAddNewCC();
		  Utilities.waitForAjaxToFinish();
		  Utilities.explicitlyWait(3000);



		  creditcard.enterNewCreditCard();
		  Utilities.waitForAjaxToFinish();
		  Utilities.explicitlyWait(3000);



		  paymentmethods.StoredCardVerification();
		  Utilities.waitForAjaxToFinish();
		  Utilities.explicitlyWait(3000);



		  paymentmethods.DeleteCC();
		  Utilities.explicitlyWait(3000);

	  }
	}