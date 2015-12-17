package Test;

import org.testng.annotations.Test;

import Pages.CreateAnAccount;
import Pages.FooterObjects;
import Pages.LoginPageObjects;
import Tools.ExtentManager;
import Tools.Utilities;

public class AccountTestCases extends TestCaseConfiguration {
  @Test
  public void AccountPAU() {
	  
	  
	  ExtentManager.setExtentTest(REPORTMANAGER, Thread.currentThread().getStackTrace()[1].getMethodName());
		
		

	  
  }
}
