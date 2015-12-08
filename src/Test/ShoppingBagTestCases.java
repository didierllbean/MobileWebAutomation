package Test;


import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import DataObjects.ProductData;
import Pages.HeaderObjects;
import Pages.ProductPageCore;
import Pages.ShoppingBagPage;
import Tools.Constants;
import Tools.Utilities;

public class ShoppingBagTestCases extends TestCaseConfiguration {
private ProductData productData;

  @Test(groups = { "smokeTest"})
  public void ShoppingBagGu() throws InterruptedException {

	  extent.startTest("ShoppingBagAsAGuestUser");
	  System.out.println("Running ShoppingBagAsAGuestUser Test Case");
	  
	  ShoppingBagPage sbPage = new ShoppingBagPage();
      HeaderObjects header = new HeaderObjects(driver);
      ProductPageCore prodPage = new ProductPageCore();
      header.clickSBImage();
	  Utilities.waitForAjaxToFinish(30, driver);//wait for page to be fully loaded
	  
	  if(driver.getPageSource().contains("Your Shopping Bag is empty"))
			
		{
			System.out.println("Your Shopping Bag is empty Is Present");
			extent.log(LogStatus.PASS, "Your Shopping Bag is empty Is Present");

		}
		else
		{
			System.out.println("Your Shopping Bag is empty Is Not Present");
			extent.log(LogStatus.FAIL, "Your Shopping Bag is empty Is Present");


		}
	    
  }
}
