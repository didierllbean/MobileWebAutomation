package Test;

import org.testng.annotations.Test;

import Pages.AccountPageObjects;
import Pages.CreateAnAccount;
import Pages.CreditCardDetailPageObjects;
import Pages.FooterObjects;
import Pages.HomePageObjects;
import Pages.LoginPageObjects;
import Pages.SavedCreditCardsPageObjects;
import Tools.Constants;
import Tools.ExtentManager;
import Tools.Utilities;

public class AccountTestCases extends TestCaseConfiguration {
	  @Test
	  public void AccountAU() {
		  
		  FooterObjects footer = new FooterObjects();
		  LoginPageObjects Login;
		  HomePageObjects homepage= new HomePageObjects();
		  AccountPageObjects account = new AccountPageObjects();
		  SavedCreditCardsPageObjects paymentmethods = new SavedCreditCardsPageObjects();
		  CreditCardDetailPageObjects creditcard = new CreditCardDetailPageObjects();	 
		  Login = footer.NavigateToLoginPage();
		
		  homepage = Login.login(Constants.FULLINFOACCOUNT, Constants.PASSWORD, HomePageObjects.class);		
		  Utilities.explicitlyWait(3000);
		  footer.ClickUserAccountName();
		  Utilities.explicitlyWait(3000);
		  account.LinkVerification();
		  account.ClickSavedCC();
		  paymentmethods.ClickAddNewCC();
		  creditcard.EnterNewCC();
		  paymentmethods.StoredCardVerification();
		  paymentmethods.DeleteCC();
		    	  
	  }
	}