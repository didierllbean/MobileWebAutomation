package Tools;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Pages.ProductPageCore;
import Tools.Constants;

public class Utilities {
	
	/**
	 * Verify if a WebElement can be found during the current execution.
	 * 
	 * @param selector   Selector for the WebElement. Can be any selector supported on the By class (ie.: By.xpath or By.id). 
	 * @param driver	 Current WebDriver in use. 
	 * @return 			 True if the element is present or False if not.
	 * @exception		 Ignores generic exceptions.
	 *  
	 *  @author Yohan Desanti G.
	 *  @LastUpdate Yohan Desanti G.
	 *  @version 1.0, 11/21/2015
	 */
	public static boolean isElementPresent(WebDriver driver, By selector) {
       try {
          driver.findElement(selector);    
          return true;    
       } catch (Exception e) {
           return false ;
	   }
	}
	
	/**
	 * Generic Method <p> 
	 * Find and Select any option present on a Select dropdown list. <p> 
	 * Returns a webdriver pointing to the desired page object class.
	 * 
	 * @param selector   Selector for the WebElement. Can be any selector supported on the By class (ie.: By.xpath or By.id). 
	 * @param option     String text of the option present in list that wants to select.
	 * @param driver	 Current WebDriver in use. 
	 * @return 			 Object of the expected class.
	 * 
	 *  @author Yohan Desanti G.  
	 *  @LastUpdate Yohan Desanti G.
	 *  @version 1.0, 11/24/2015
	 */
	public static <T> T selectDropDownOption(By selector, String option, WebDriver driver, Class<T> expectedPage)
    {
         new Select(driver.findElement(selector)).selectByVisibleText(option);                 
         return PageFactory.initElements(driver, expectedPage);
    }
	
	/**
	 * Navigate to any valid product page.
	 * 
	 * @param pdpID     String value for the desired product page(5 digits ID). 
	 * @param driver	Current WebDriver in use. 
	 * @return 			ProductPageCore class object.
	 *  
	 *  @author Yohan Desanti G.
	 *  @LastUpdate Yohan Desanti G.
	 *  @version 1.0, 11/26/2015
	 */
	public static ProductPageCore goToPDP(WebDriver driver, String pdpID){
		driver.get(Constants.PDPURL+pdpID);
		return PageFactory.initElements(driver, ProductPageCore.class);
	}

	/**
	 * Navigate to an predefined product page.
	 * 
	 * @param pdpType   String value for the desired product page type (Constants.FULLPRICEPDP or Constants.SALEPRICEPDP). 
	 * @param driver	Current WebDriver in use. 
	 * @return 			ProductPageCore class object.
	 *  
	 *  @author Yohan Desanti G.
	 *  @LastUpdate Yohan Desanti G.
	 *  @version 1.0, 11/26/2015
	 */
	public static ProductPageCore goToPDP(String pdpType, WebDriver driver){
		switch(pdpType)
		{
			case Constants.FULLPRICEPDP:
				driver.get(Constants.PDPURL+Constants.FULLPRICEPDP);	
			break;
			case Constants.SALEPRICEPDP:
				driver.get(Constants.PDPURL+Constants.SALEPRICEPDP);	
			break;				
		}
		
		return PageFactory.initElements(driver, ProductPageCore.class);
	}
}
