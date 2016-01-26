package Test;

import org.testng.Assert;

import org.testng.annotations.Test;

import Pages.MonogramConfigurationPage;
import Pages.ProductPageCore;
import Pages.ShoppingBagPage;
import Tools.Constants;
import Tools.Utilities;

public class ProductPageTestCases extends TestCaseConfiguration {
	
	private ProductPageCore prodPage;
	@Test(groups = {"smokeTest"})
  public void PdpAdq() {	  
	  prodPage = Utilities.goToPDP(Constants.FULLPRICEPDP);	
	  Utilities.waitForAjaxToFinish();

	  prodPage.selectRandomAttributes();
	  Utilities.waitForAjaxToFinish();

	  prodPage.AdqVerification();  
  }
  
  
	@Test(groups = {"smokeTest"})
  public void PdpMonogrammming()  
  {
	  ShoppingBagPage shoppingbag;
	  MonogramConfigurationPage monogram = new MonogramConfigurationPage();
	  prodPage = Utilities.goToPDP(Constants.MONOGRAM);	
	  Utilities.waitForAjaxToFinish();

	  prodPage.selectRandomAttributes();
	  Utilities.waitForAjaxToFinish();

	  prodPage.selectMonogramming();
	  Utilities.waitForAjaxToFinish();

	  prodPage.goToMonogramPage();
	  Utilities.waitForAjaxToFinish();

	  Utilities.explicitlyWait(7000);
	  String expected = monogram.singleLetterMonogram();
	  shoppingbag = prodPage.addMonogramToBagGoToSB();
	  Utilities.explicitlyWait(8000);
	  Utilities.waitForAjaxToFinish();
	  String actual = shoppingbag.MonogramVerification();
	  Assert.assertEquals(expected.split(";")[1], actual.split(";")[2]);
	  Assert.assertEquals(expected.split(";")[2], actual.split(";")[1]);
	  Assert.assertEquals(expected.split(";")[3], actual.split(";")[3]);
  }  
}
