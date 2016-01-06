package Test;

import org.testng.annotations.Test;

import Pages.EgiftCardPageObjects;
import Pages.GiftCardPageObjects;
import Pages.HomePageObjects;
import Pages.ShoppingBagPage;
import Tools.Utilities;

public class GiftCardTestCases extends TestCaseConfiguration {

	@Test(groups = {"smokeTest"})
  public void EGC() {
	  
	  HomePageObjects homepage = new HomePageObjects();
	  GiftCardPageObjects giftcard = new GiftCardPageObjects();
	  EgiftCardPageObjects egiftcard = new EgiftCardPageObjects();
	  ShoppingBagPage shoppingbag;
	  homepage.clickGC();
	  Utilities.waitForAjaxToFinish();
	  giftcard.clickEGc();
	  Utilities.waitForAjaxToFinish();

	  shoppingbag = egiftcard.selectEgc();
	  Utilities.waitForAjaxToFinish();

	  
	  shoppingbag.sBgiftCardVerification();
	  
  }
}
