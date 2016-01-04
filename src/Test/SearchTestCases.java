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
import Pages.SavedCreditCardsPageObjects;
import Tools.Constants;

public class SearchTestCases extends TestCaseConfiguration {

@Test(groups = {"smokeTest"})
  public void Search() throws InterruptedException {
	
	ProductPageCore ProdPage;
	HeaderObjects header = new HeaderObjects();
	ProductListPageObjects productListpage = new ProductListPageObjects();
	QuickShopPageObjects quickshop = new QuickShopPageObjects();
	
	header.SearchSuggestionVerification();
	header.NavigateToHp();
    Utilities.explicitlyWait(3000);
    
    header.SearchSuggestionClick();
	//header.ProductListPageVerification();
	
	Utilities.explicitlyWait(8000);
	header.QuickShopCatalogVerification();
	
  }

@Test(groups = {"smokeTest"})
public void QuickShop()
{
	ProductPageCore ProdPage;
	QuickShopPageObjects quickshop = new QuickShopPageObjects();

	ProdPage = quickshop.QSOptionVerification();
	ProdPage = quickshop.QSOption2();
	ProdPage = quickshop.QSOptionVerification();
	ProdPage = quickshop.QSOption2();
	ProdPage.SalePriceItem();	
}
}
