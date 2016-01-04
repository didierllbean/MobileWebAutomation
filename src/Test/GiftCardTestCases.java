package Test;

import org.testng.annotations.Test;

import Pages.EgiftCardPageObjects;
import Pages.GiftCardPageObjects;
import Pages.HomePageObjects;
import Tools.Utilities;

public class GiftCardTestCases extends TestCaseConfiguration {
  @Test
  public void EGC() {
	  
	  HomePageObjects homepage = new HomePageObjects();
	  GiftCardPageObjects giftcard = new GiftCardPageObjects();
	  EgiftCardPageObjects egiftcard = new EgiftCardPageObjects();
	  
	  homepage.ClickGC();
	  Utilities.explicitlyWait(3000);
	  giftcard.ClickEGc();
	  Utilities.explicitlyWait(3000);
	  egiftcard.SelectEgc();
	  
  }
}
