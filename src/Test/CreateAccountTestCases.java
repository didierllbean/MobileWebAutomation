package Test;

import org.testng.annotations.Test;

import Pages.LoginPageObjects;
import Pages.FooterObjects;
import Pages.CreateAnAccount;
import Tools.ExtentManager;
import Tools.Utilities;

public class CreateAccountTestCases extends TestCaseConfiguration
{
	@Test(groups = {"smokeTest", "brokenOrDevelopment"})
	public void CreateNewAccount() throws InterruptedException{
		//ExtentManager.setExtentTest(REPORTMANAGER, Thread.currentThread().getStackTrace()[1].getMethodName());
		
		FooterObjects footer = new FooterObjects();
		LoginPageObjects login;
		CreateAnAccount create = new CreateAnAccount();
		
		footer.NavigateToLoginPage();
		Utilities.explicitlyWait(5000);

		create.CreateAccClick();
        
		String EmPass= create.CreateAndVerifyAccount();
		String Part[] = EmPass.split(";");

		footer.FooterSignOut();

		login = footer.NavigateToLoginPage();
		login.VerifyNewAccount(Part[0], Part[1]);
		
	
		
	}
}