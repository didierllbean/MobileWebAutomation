package Test;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Pages.LoginPageObjects;
import Pages.FooterObjects;
import Pages.CreateAnAccount;
import Tools.Utilities;

public class CreateAccountTestCases extends TestCaseConfiguration
{
	@Test(groups = {"smokeTest"})
	public void CreateNewAccount() throws InterruptedException{
		
		
		  extent.startTest("CreateNewAccount");
          System.out.println("Running CreateAnAccount Test Case");
		
		FooterObjects footer = new FooterObjects(driver);
		LoginPageObjects Login = new LoginPageObjects(driver);
		CreateAnAccount Create = new CreateAnAccount(driver);
		
		footer.NavigateToLoginPage();
	    extent.log(LogStatus.PASS, "NavigateToLoginPage", "Success");
	    Utilities.waitForAjaxToFinish(30, driver);//wait for page to be fully loaded

		Create.CreateAccClick();
		Utilities.waitForAjaxToFinish(30, driver);//wait for page to be fully loaded
        
		String EmPass= Create.CreateAndVerifyAccount();
		String Part[] = EmPass.split(";");
	    extent.log(LogStatus.PASS, "NavigateToCreateAccountPage", "Success");

		footer.FooterSignOut();
		Utilities.waitForAjaxToFinish(30, driver);//wait for page to be fully loaded
	    extent.log(LogStatus.PASS, "Logout", "Success");

		footer.NavigateToLoginPage();
		Utilities.waitForAjaxToFinish(30, driver);//wait for page to be fully loaded
	    extent.log(LogStatus.PASS, "Relogin", "Success");

		Login.VerifyNewAccount(Part[0], Part[1]);
	}
}
