package Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import Tools.ExtentManager;
import Tools.Utilities;
import Pages.HeaderObjects;
import Pages.ProductListPageObjects;
import Pages.ProductPageCore;
import Pages.QuickShopPageObjects;
import Tools.Constants;


public class SearchTestCases extends TestCaseConfiguration {

@Test(groups = {"smokeTest"})
  public void Search() throws InterruptedException {
	

	HeaderObjects header = new HeaderObjects();
	ProductListPageObjects ProductListPage = new ProductListPageObjects();
	
	QuickShopPageObjects quickShopPage = new QuickShopPageObjects();
	
	ProductPageCore prodPage;
	
	header.productListPageVerification();
	Utilities.explicitlyWait(3000);
	
	
	header.searchSuggestionVerification();
	Utilities.explicitlyWait(3000);
	
	header.searchSuggestionClick();
	
	ProductListPage.searchTermVerification();
	Utilities.explicitlyWait(3000);

	header.quickShopCatalogVerification();
	Utilities.explicitlyWait(3000);

	prodPage = quickShopPage.QSOption1();
	Utilities.waitForAjaxToFinish();
	Utilities.explicitlyWait(3000);

	
	prodPage.fullPriceAlphaCodeVerification();
	
	header.quickShopCatalogVerification();
	Utilities.waitForAjaxToFinish();

	prodPage = quickShopPage.QSOption2();
	Utilities.waitForAjaxToFinish();
	Utilities.explicitlyWait(3000);
	
	
	prodPage.salePriceAlphaCodeVerification();
	
	
  }
}
