package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPageObjects {
	private WebElement productOnList,
						aux;
	
	@FindBy(linkText  = "Remove all items")
	WebElement wlRemoveAllLink;
	
	private WebElement getProductInWL(String productID, WebDriver driver) {
		return productOnList = driver.findElement(By.xpath("//div[@class = 'sbItemAttributes']/div[contains(.,'"+productID+"')]/../../.."));
	}
	
	protected void moveProductToShoppingBag(String productID, WebDriver driver) {
		aux = getProductInWL(productID, driver);
		aux.findElement(By.xpath("//input[@value = 'MOVE TO BAG']")).click();		
	}
	
	protected void removeProduct(String productID, WebDriver driver) {
		aux = getProductInWL(productID, driver);
		aux.findElement(By.linkText("Remove Item")).click();		
	}

}
