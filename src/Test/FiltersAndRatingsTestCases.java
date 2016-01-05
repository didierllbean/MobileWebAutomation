package Test;

import org.testng.annotations.Test;

import Pages.HeaderObjects;
import Pages.ProductListPageObjects;
import Tools.Utilities;

public class FiltersAndRatingsTestCases extends TestCaseConfiguration {
  @Test
  public void filters() {
	  
	  HeaderObjects header = new HeaderObjects();
	  
	  ProductListPageObjects productlistpage = new ProductListPageObjects();

	  header.searchForShirts();
	  Utilities.explicitlyWait(5000);
	  productlistpage.applyFilters();
	  
  }
  
}
  
