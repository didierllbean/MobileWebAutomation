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
import Tools.Constants;


public class SearchTestCases extends TestCaseConfiguration {

@Test(groups = {"smokeTest"})
  public void Search() throws InterruptedException {
	
	ExtentManager.setExtentTest(REPORTMANAGER, Thread.currentThread().getStackTrace()[1].getMethodName());

	HeaderObjects header = new HeaderObjects();
	ProductListPageObjects ProductListPage = new ProductListPageObjects();
	//header.EnterSearchTerm();
	header.ProductListPageVerification();
	header.SearchSuggestionVerification();;
	header.QuickShopCatalogVerification();
	
  }
}
