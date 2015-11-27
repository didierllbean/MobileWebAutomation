package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPageCore {
	
	/**
	 * WebElements
	 */
	
	/** General Elements **/
	
	@FindBy(xpath  = "//@data-catalogid")
	WebElement catalogID;
	
	@FindBy(id = "un_add_to_bag")
	WebElement addToBagButton;
	
	@FindBy(xpath = "//select[@class = 'ppQutyCountSelect']")
	WebElement qtyDropDown;
	
	@FindBy(id = "paypalExpress")
	WebElement buyPPExpressButton;
	
	@FindBy(xpath = "id('AddToWishListBtnBox_0')//a")
	WebElement addToWLButton;
	
	
	/** ADQ **/
	
	@FindBy(xpath = "//a[contains(.,'Enter zip code')]")
	WebElement addADQZipCodeLink;
		
	@FindBy(id = "pdp_zipcode")
	WebElement adqZipCodeTextField;
	
	@FindBy(xpath = "//a[contains(.,'Submit')]")
	WebElement adqSubmitZipCodeButton;
	
	@FindBy(xpath = "//a[contains(.,'Cancel')]")
	WebElement adqCancelButton;
	
	@FindBy(xpath = "//a[contains(.,'change')]")
	WebElement adqChangeZipCodeButton;
	
	@FindBy(xpath = "//a[contains(.,'Want it faster?')]")
	WebElement adqNeedFasterLink;
		
	/** Monogramming **/
	
	@FindBy(id = "monogramCheckboxCnt")
	WebElement monogramCheckbox;
	
	@FindBy(xpath = "//a[contains(.,'details')]")
	WebElement monogramDetailsLink;
	
	@FindBy(xpath = "//a[contains(.,'Close')]")
	WebElement monogramCloseDetailsLink;
	
	@FindBy(xpath = "//a[contains(.,'More about')]")
	WebElement monogramMoreAboutLink;
	
	/** PASB **/
	
	@FindBy(xpath = "//a[contains(.,'Check Out')]")
	WebElement pasbCheckoutButton;
	
	@FindBy(xpath = "//a[contains(.,'Continue Shopping')]")
	WebElement pasbContinueShoppingButton;
	
	private void addToBag()
	{
		addToBagButton.click();
	}
	
	private ShoppingBagPage goToCheckout(WebDriver driver){
		pasbCheckoutButton.click();
		return PageFactory.initElements(driver, ShoppingBagPage.class);
	}
	
	private void continueChopping()
	{
		pasbContinueShoppingButton.click();
	}
	
	public ShoppingBagPage addToBagAndGoToSB(WebDriver driver){
		addToBag();
		return goToCheckout(driver);
	}
	
	public void addToBagAndContinueShopping(WebDriver driver){
		addToBag();
		continueChopping();
	}
}
