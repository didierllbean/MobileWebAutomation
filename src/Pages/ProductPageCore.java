package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DataObjects.ProductData;
import Tools.Utilities;

public class ProductPageCore {
	
	/*--------------------------------------------------* WebElements *--------------------------------------------------*/	
	/*-------------------------------------------------- General Elements --------------------------------------------------*/
	
	@FindBy(id = "pdp_headerTitle")
	WebElement productName;
	
	@FindBy(xpath  = "id('swatchDiv')//div[@itemid]")
	WebElement productID;
	
	@FindBy(xpath  = "//div[contains(@class, 'tabselected')]")
	WebElement productSizeType;
	
	@FindBy(id = "un_add_to_bag")
	WebElement addToBagButton;
	
	//@FindBy(xpath = "//select[@class = 'ppQutyCountSelect']")
	//WebElement qtyDropDown;
	
	@FindBy(id = "paypalExpress")
	WebElement buyPPExpressButton;
	
	@FindBy(xpath = "id('AddToWishListBtnBox_0')//a")
	WebElement addToWLButton;
	
	@FindBy(id = "tab_0_0_content")
	WebElement attributesSection;
	
	/*-------------------------------------------------- ADQ --------------------------------------------------*/
	
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
		
	/*-------------------------------------------------- Monogramming --------------------------------------------------*/
	
	@FindBy(id = "monogramCheckboxCnt")
	WebElement monogramCheckbox;
	
	@FindBy(xpath = "//a[contains(.,'details')]")
	WebElement monogramDetailsLink;
	
	@FindBy(xpath = "//a[contains(.,'Close')]")
	WebElement monogramCloseDetailsLink;
	
	@FindBy(xpath = "//a[contains(.,'More about')]")
	WebElement monogramMoreAboutLink;
	
	/*-------------------------------------------------- PASB --------------------------------------------------*/
	
	@FindBy(xpath = "//a[contains(.,'Check Out')]")
	WebElement pasbCheckoutButton;
	
	@FindBy(xpath = "//a[contains(.,'Continue Shopping')]")
	WebElement pasbContinueShoppingButton;
	
	/*-------------------------------------------------- Functions --------------------------------------------------*/
	
/*	public String getSelectedQty(WebDriver driver) {
		return driver.findElement(By.xpath("//select[@class = 'ppQutyCountSelect']")).getText();
	}
	*/
	private WebElement getProductPrice(WebDriver driver) {
		if(productID.getAttribute("data-catalogid").toString().equals("PO"))
			return driver.findElement(By.xpath("(id('swatchDiv')//span[not(contains(@class,'un_line_through')) and contains(.,'$')])[1]"));
		else
			return driver.findElement(By.xpath("id('swatchDiv')//div/b"));
	}
	
	/**
	 * Makes click on the Add to Bag button
	 * 
	 * @author Yohan Desanti G.
	 * @LastUpdate Yohan Desanti G.
	 * @version 1.0, 11/27/2015
	 */
	private void addToBag()
	{
		addToBagButton.click();
	}
	
	/**
	 * Makes click on the Go to Checkout button in the PASB layer
	 * 
	 * @param driver WebDriver for the flow in use
	 * @return ShoppingBag class object
	 * 
	 * @author Yohan Desanti G.
	 * @LastUpdate Yohan Desanti G.
	 * @version 1.0, 11/27/2015
	 */
	private ShoppingBagPage goToCheckout(WebDriver driver){
		pasbCheckoutButton.click();
		return PageFactory.initElements(driver, ShoppingBagPage.class);
	}
	
	/**
	 * Makes click on the Continue Shopping Link
	 * 
	 * @author Yohan Desanti G.
	 * @LastUpdate Yohan Desanti G.
	 * @version 1.0, 11/27/2015
	 */
	private void continueChopping()
	{
		pasbContinueShoppingButton.click();
	}
	
	/**
	 * Makes click on the Add to Bag button and click on the Go to Checkout button
	 * 
	 * @param driver WebDriver for the flow in use
	 * @return ShoppingBag class object
	 * 
	 * @author Yohan Desanti G.
	 * @LastUpdate Yohan Desanti G.
	 * @version 1.0, 11/27/2015
	 */
	public ShoppingBagPage addToBagAndGoToSB(WebDriver driver){
		addToBag();
		return goToCheckout(driver);
	}
	
	/**
	 * Makes click on the Add to Bag button and click on the Continue Shopping Link
	 * 
	 * @param driver WebDriver for the flow in use
	 * 
	 * @author Yohan Desanti G.
	 * @LastUpdate Yohan Desanti G.
	 * @version 1.0, 11/27/2015
	 */
	public void addToBagAndContinueShopping(WebDriver driver){
		addToBag();
		continueChopping();
	}
	
	/**
	 * Check if there are available colors and select a random color swatch 
	 * 
	 * @param driver WebDriver for the flow in use
	 * @return String name of the selected color
	 * 
	 * @author Yohan Desanti G.
	 * @LastUpdate Yohan Desanti G.
	 * @version 1.5, 12/02/2015
	 */
	public String selectRandomColorAttribute(WebDriver driver) {
		if(Utilities.isElementPresent(driver, By.id("un_color_cont")))
		{
			List <WebElement> colors = null;
			colors = attributesSection.findElements(By.xpath("id('un_color_cont')//img[not(contains(@src, 'outofstock')) and not(contains(@class, 'soldOutSwatchImg'))]/.."));
						
			colors.get((int)(Math.random()*colors.size())).click();		
			
			return attributesSection.findElement(By.xpath("id('colorNameContainer0_0_0')/div/span")).getText();
		}
		return "";
	}
	
	/**
	 * Check if there are available size and select a random size swatch 
	 * 
	 * @param driver WebDriver for the flow in use
	 * @return String value of the selected Size
	 * 
	 * @author Yohan Desanti G.
	 * @LastUpdate Yohan Desanti G.
	 * @version 1.1, 12/02/2015
	 */
	public String selectRandomSizeAttribute(WebDriver driver) {
		if(Utilities.isElementPresent(driver, By.id("llb_size")))
		{
			List <WebElement> sizes = null;
			sizes = attributesSection.findElements(By.xpath("id('llb_size')/div//input[not(contains(@class, 'outofstock'))]"));
						
			sizes.get((int)(Math.random()*sizes.size())).click();			

			return attributesSection.findElement(By.xpath("id('un_sizelabel')/div/span")).getText();
		}
		return "";
	}
	
	/**
	 * Verify which attributes are present for the current product page and select a ramdon available swatch for each one. 
	 * Also save and return this selected values in a Product object 
	 * 
	 * @param driver WebDriver for the flow in use
	 * @return ProductData object
	 * 
	 * @author Yohan Desanti G.
	 * @LastUpdate Yohan Desanti G.
	 * @version 1.2, 12/02/2015
	 */
	public ProductData selectRandomAttributes(WebDriver driver) {
		String color = null, size = null;
		if(Utilities.isElementPresent(driver, By.id("un_color_cont")))
			color = selectRandomColorAttribute(driver);
		
		if(Utilities.isElementPresent(driver, By.id("llb_size")))
			size = selectRandomSizeAttribute(driver);		
		
		return new ProductData(productID.getAttribute("itemid").toString(), productName.getText(), getProductPrice(driver).getText(), color, size, "1", productSizeType.getText());
	}
}
