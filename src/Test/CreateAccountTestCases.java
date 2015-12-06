package Test;

import org.testng.annotations.Test;
import java.util.Dictionary;

import org.testng.annotations.Test;

import Pages.LoginPageObjects;
import Pages.FooterObjects;
import Pages.CreateAnAccount;
import Tools.Constants;
import Tools.Utilities;

public class CreateAccountTestCases extends TestCaseConfiguration
{
	@Test(groups = { "smokeTest"})
	public void CreateNewAccount() throws InterruptedException{
		
		
		
		FooterObjects footer = new FooterObjects(driver);
		LoginPageObjects Login = new LoginPageObjects(driver);
		CreateAnAccount Create = new CreateAnAccount(driver);
        //Fetch fetchobj = new Fetch();
        Dictionary dict;    
       // dict = fetchobj.readfromExcel();
		footer.NavigateToLoginPage();
		Create.CreateAccClick();
		
		String EmPass= Create.CreateAndVerifyAccount();
		String Part[] = EmPass.split(";");
        
		footer.FooterSignOut();
		footer.NavigateToLoginPage();
		Login.VerifyNewAccount(Part[0], Part[1]);
				

		//Createobj.AccountVerification();
	}

}
