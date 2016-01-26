package Test;

import org.testng.annotations.Test;

import Pages.LoginPageObjects;
import Pages.FooterObjects;
import Pages.CreateAnAccount;
import Tools.Utilities;

public class CreateAccountTestCases extends TestCaseConfiguration
{
	@Test(groups = {"smokeTest"})
	public void CreateNewAccount() throws InterruptedException{
		
		FooterObjects footer = new FooterObjects();
		LoginPageObjects Login;
		CreateAnAccount Create = new CreateAnAccount();
		
		footer.NavigateToLoginPage();
		Utilities.explicitlyWait(5000);
		Utilities.waitForAjaxToFinish();

		Create.CreateAccClick();
        
		String EmPass= Create.createAndVerifyAccount();
		String Part[] = EmPass.split(";");

		footer.footerSignOut();

		Login = footer.NavigateToLoginPage();
		Utilities.explicitlyWait(5000);

		Login.VerifyNewAccount(Part[0], Part[1]);
	}
}