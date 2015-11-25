package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingBagPage {

	private WebElement productOnList,
						aux;
	
	/**
	 * WebElements
	 */
	
	/** General Elements **/
	
	@FindBy(xpath  = "(//input[@value='Check Out'])[1]")
	WebElement sbCheckoutButton;
	
	@FindBy(xpath  = "(//input[@value='Check out with'])[1]")
	WebElement sbCheckoutWithPaypalButton;
	
	@FindBy(id  = "shipMeRadio")
	WebElement sbShiptoMeRadioButton;
	
	@FindBy(id  = "promoNumber")
	WebElement sbPromoCodeTextField;
	
	@FindBy(xpath  = "//input[@value = 'Redeem']")
	WebElement sbPromoCodeRedeemButton;
	
	@FindBy(id  = "shipOtherRadio")
	WebElement sbShiptoMultipleAddressesRadioButton;
	
	@FindBy(xpath  = "id('un_clearcart')//a")
	WebElement sbGoToWishListLink;
	
	@FindBy(xpath  = "id('clearSB')/span")
	WebElement sbClearSBLink;
	
	@FindBy(xpath  = "//div[@class = 'shoppingBagDays']/a[1]")
	WebElement sbDaysMessageLoginLink;
	
	@FindBy(xpath  = "//div[@class = 'shoppingBagDays']/a[2]")
	WebElement sbDaysMessageCreateAccountLink;
	
	@FindBy(xpath  = "//div[@class = 'sbPopupTitle' and contains(.,'Merge Bag')]")
	WebElement sbMergeMessagePopipTitle;
	
	@FindBy(xpath  = "id('un_popup_wrapper')//input")
	WebElement sbMergePopipOkButton;

	private WebElement getProductInSB(String productID, WebDriver driver) {
		return productOnList = driver.findElement(By.xpath("//div[@class = 'sbItemAttributes']/div[contains(.,'"+productID+"')]/../../.."));
	}
	
	protected void updateProductQty(String qty, String productID, WebDriver driver) {
		aux = getProductInSB(productID, driver);
		aux.findElement(By.xpath("//input[@id]")).sendKeys(qty);
		aux.findElement(By.xpath("//input[@value = 'Update']")).click();		
	}
	
	protected void moveProductToWishList(String productID, WebDriver driver) {
		aux = getProductInSB(productID, driver);
		aux.findElement(By.linkText("Move to Wish List")).click();		
	}
	
	protected void removeProduct(String productID, WebDriver driver) {
		aux = getProductInSB(productID, driver);
		aux.findElement(By.linkText("Remove")).click();		
	}
}
