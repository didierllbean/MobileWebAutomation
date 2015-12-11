package Test;

import org.testng.annotations.Test;

import Pages.LoginPageObjects;
import Pages.FooterObjects;
import Pages.CreateAnAccount;

import Tools.ExtentManager;

public class CreateAccountTestCases extends TestCaseConfiguration
{
	@Test(groups = {"smokeTest", "brokenOrDevelopment"})
	public void CreateNewAccount() throws InterruptedException{
		ExtentManager.setExtentTest(REPORTMANAGER, Thread.currentThread().getStackTrace()[1].getMethodName());
		
		FooterObjects footer = new FooterObjects();
		LoginPageObjects Login = new LoginPageObjects();
		CreateAnAccount Create = new CreateAnAccount();
		
		footer.NavigateToLoginPage();
		Create.CreateAccClick();
        
		String EmPass= Create.CreateAndVerifyAccount();
		String Part[] = EmPass.split(";");

		footer.FooterSignOut();

		footer.NavigateToLoginPage();
		
		Login.VerifyNewAccount(Part[0], Part[1]);
	}
}