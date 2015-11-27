package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Tools.Utilities;

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
	
	@FindBy(id = "tab_0_0_content")
	WebElement attributesSection;
	
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
	
	public void selectRandomColorAttribute(WebDriver driver) {
		if(Utilities.isElementPresent(driver, By.id("un_color_cont")))
		{
			List <WebElement> colors = attributesSection.findElements(By.xpath("//img[not(contains(@src, 'outofstock')) and not(contains(@class, 'soldOutSwatchImg'))]/.."));
			
			System.err.println((int)(Math.random()*colors.size())+1);
			colors.get((int)(Math.random()*colors.size())+1).click();
			
		}
	}
}
