package Tools;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Utilities {
	
	/**
	 * Verify if a WebElement can be found during the current execution.
	 * 
	 * @Param selector   Selector for the WebElement. Can be any selector supported on the By class (ie.: By.xpath or By.id). 
	 * @Param driver	 Current WebDriver in use. 
	 * @Return 			 True if the element is present or False if not.
	 * @Exception		 Ignores generic exceptions.
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
	 * @Param selector   Selector for the WebElement. Can be any selector supported on the By class (ie.: By.xpath or By.id). 
	 * @Param option     String text of the option present in list that wants to select.
	 * @Param driver	 Current WebDriver in use. 
	 * @Return 			 Object of the expected class.
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

}
