package Test;

import org.testng.annotations.Test;

import Pages.FooterObjects;
import Pages.MonogramConfigurationPage;
import Pages.ProductPageCore;
import Pages.ShoppingBagPage;
import Tools.Constants;
import Tools.Utilities;

public class ProductPageTestCases extends TestCaseConfiguration {
	
	private ProductPageCore prodPage;
 @Test
  public void PdpAdq() {
	  
	  
	  prodPage = Utilities.goToPDP(Constants.FULLPRICEPDP);		
	  prodPage.selectRandomAttributes();
	  prodPage.AdqVerification();  
  }
  
  
  @Test
  public void PdpMonogrammming()
  
  {
	  ShoppingBagPage shoppingbag = new ShoppingBagPage();
	  MonogramConfigurationPage monogram = new MonogramConfigurationPage();
	  prodPage = Utilities.goToPDP(Constants.MONOGRAM);		
	  prodPage.selectRandomAttributes();
	  prodPage.checkMonogramming();
	  prodPage.goToMonogramPage();
	  Utilities.explicitlyWait(7000);
	  monogram.singleLetterMonogram();
	  prodPage.addMonogramToBagGoToSB();
	  Utilities.explicitlyWait(18000);
	  shoppingbag.MonogramVerification();
  }
}
