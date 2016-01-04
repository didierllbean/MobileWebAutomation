package Test;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Pages.DailyMarkDownPageObjects;
import Pages.EmailSignUpPageObjects;
import Pages.FooterObjects;
import Pages.MenuPageObjects;
import Tools.Utilities;

public class ShopHome extends TestCaseConfiguration {
	
/* @Test
  public void EmailSignUp() {
	  
	FooterObjects footer = new FooterObjects();
	EmailSignUpPageObjects emailsingup = new EmailSignUpPageObjects();

	footer.EmailSignUp();
	 
	Utilities.explicitlyWait(8000);
	  
	emailsingup.ThankYouTextVerification();	  	  	 
  }
 
 @Test
  public void FooterLinks()
 
  {
		FooterObjects footer = new FooterObjects();
		footer.FooterLinkVerification();
  }
  */
 @Test 
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
