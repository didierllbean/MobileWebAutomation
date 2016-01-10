package Test;

import org.junit.Assert;
import org.testng.annotations.Test;

import Pages.DailyMarkDownPageObjects;
import Pages.EmailSignUpPageObjects;
import Pages.FooterObjects;
import Pages.MenuPageObjects;
import Tools.Utilities;

public class ShopHome extends TestCaseConfiguration {
	
@Test(groups = {"smokeTest"})
  public void EmailSignUp() {
	  
	FooterObjects footer = new FooterObjects();
	EmailSignUpPageObjects emailsingup = new EmailSignUpPageObjects();

	footer.emailSignUp();
	 
	Utilities.explicitlyWait(8000);
	  
	emailsingup.ThankYouTextVerification();	  	  	 
  }
 
@Test(groups = {"smokeTest"})
  public void FooterLinks()
 
  {
		FooterObjects footer = new FooterObjects();
		footer.footerLinkVerification();
  }
  
@Test(groups = {"smokeTest"})
 public void DailyMarkDown()
 
 {
	 MenuPageObjects menupage = new MenuPageObjects();
	 DailyMarkDownPageObjects markdown = new DailyMarkDownPageObjects();
	 menupage.NavigateToDailyMarkDownPage();
	 Utilities.explicitlyWait(3000);
	 String DailyMarkDownTitlePreProd = markdown.getDailyMarkDownTitleTexts01();
	 
	 driver.get().get("https://www.llbean.com");
	 menupage.NavigateToDailyMarkDownPage();
	 Utilities.explicitlyWait(3000);
	 String DailyMarkDownTitleProd = markdown.getDailyMarkDownTitleTextsProd();
	 
	 Assert.assertEquals(DailyMarkDownTitlePreProd, DailyMarkDownTitleProd);
	 
 }
 
 
  
}
