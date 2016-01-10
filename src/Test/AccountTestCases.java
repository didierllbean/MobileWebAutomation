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
	
	@Test(groups = {"smokeTest", "brokenOrDevelopment"})
	  public void AccountAU() {
		  
		  FooterObjects footer = new FooterObjects();
		  LoginPageObjects Login;
		  HomePageObjects homepage= new HomePageObjects();
		  AccountPageObjects account = new AccountPageObjects();
		  SavedCreditCardsPageObjects paymentmethods = new SavedCreditCardsPageObjects();
		  CreditCardDetailPageObjects creditcard = new CreditCardDetailPageObjects();	 
		  Login = footer.NavigateToLoginPage();
		
		  homepage = Login.login(Constants.FULLINFOACCOUNT, Constants.PASSWORD, HomePageObjects.class);	
		  Utilities.waitForAjaxToFinish();
		  Utilities.explicitlyWait(3000);
		  
		  
		  footer.clickUserAccountName();
		  Utilities.waitForAjaxToFinish();
		  
		  account.linkVerification();
		  Utilities.waitForAjaxToFinish();

		  account.clickSavedCC();
		  Utilities.waitForAjaxToFinish();


		  paymentmethods.ClickAddNewCC();
		  Utilities.waitForAjaxToFinish();


		  creditcard.enterNewCreditCard();
		  Utilities.waitForAjaxToFinish();


		  paymentmethods.StoredCardVerification();
		  Utilities.waitForAjaxToFinish();


		  paymentmethods.DeleteCC();		    	  
	  }
	}