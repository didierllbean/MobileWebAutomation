package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import DataObjects.ProductData;
import Test.TestCaseConfiguration;
import Tools.ExtentManager;
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
		
	@FindBy(xpath = "//div[@class = 'orderDetCont']")
	WebElement adqCityName;
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
	
/*	public String getSelectedQty() {
		return driver.findElement(By.xpath("//select[@class = 'ppQutyCountSelect']")).getText();
	}
	*/
	
	/**
	 * Find the product price value based on the page type (Fullpriced or Sale) 
	 * @param driver current webdriver in use.
	 * @return WebElement with the price text
	 */
	private WebElement getProductPrice() {
		if(productID.getAttribute("data-catalogid").toString().equals("PO"))
			return TestCaseConfiguration.driver.get().findElement(By.xpath("(id('swatchDiv')//span[not(contains(@class,'un_line_through')) and contains(.,'$')])[1]"));
		else
			return TestCaseConfiguration.driver.get().findElement(By.xpath("id('swatchDiv')//div/b"));
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
		//ExtentManager.getExtentTest().log(LogStatus.PASS, "AddedToBag", "Success");
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
	private ShoppingBagPage goToCheckout(){
		pasbCheckoutButton.click();
		//ExtentManager.getExtentTest().log(LogStatus.PASS, "GoToShoppingBag", "Success");
		
		return PageFactory.initElements(TestCaseConfiguration.driver.get(), ShoppingBagPage.class);
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
	public ShoppingBagPage addToBagAndGoToSB(){
		addToBag();
		return goToCheckout();
	}
	
	
	public MonogramConfigurationPage goToMonogramPage()
	{
		addToBag();
		Utilities.waitForAjaxToFinish(40000);
		return PageFactory.initElements(TestCaseConfiguration.driver.get(), MonogramConfigurationPage.class);	
	}
	
	public ShoppingBagPage addMonogramToBagGoToSB()
	{
		
		 Assert.assertTrue(pasbCheckoutButton.isDisplayed());

		 goToCheckout();
		 
			return PageFactory.initElements(TestCaseConfiguration.driver.get(), ShoppingBagPage.class);	

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
	public ShoppingBagPage addToBagAndContinueShopping(){
		addToBag();
		continueChopping();
		return PageFactory.initElements(TestCaseConfiguration.driver.get(), ShoppingBagPage.class);
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
	public String selectRandomColorAttribute() {
		Utilities.explicitlyWait(2000);
		if(Utilities.isElementPresent(TestCaseConfiguration.driver.get(), By.id("un_color_cont")))
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
	public String selectRandomSizeAttribute() {
		if(Utilities.isElementPresent(TestCaseConfiguration.driver.get(), By.id("llb_size")))
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
	public ProductData selectRandomAttributes() {
		String color = null, size = null;
		if(Utilities.isElementPresent(TestCaseConfiguration.driver.get(), By.id("un_color_cont")))
			color = selectRandomColorAttribute();
		
		if(Utilities.isElementPresent(TestCaseConfiguration.driver.get(), By.id("llb_size")))
			size = selectRandomSizeAttribute();		
		
		
		
		//ExtentManager.getExtentTest().log(LogStatus.PASS, "ProductRandomAttributesSelection", "Success");
		return new ProductData(productID.getAttribute("itemid").toString(), productName.getText(), getProductPrice().getText(), color, size, "1", productSizeType.getText());
	}
	
	public void selectMonogramming()
	{
		monogramCheckbox.click();
		
	}
	
	public void AdqVerification()
	{
		
		Assert.assertTrue(addADQZipCodeLink.isDisplayed());
		addADQZipCodeLink.click();
		adqZipCodeTextField.sendKeys("11235");
		adqSubmitZipCodeButton.click();
		Utilities.explicitlyWait(3000);
		
		String text = adqCityName.getText();
		Assert.assertTrue(text.startsWith("Shipping")|text.endsWith("?"));
		Assert.assertTrue(text.contains("Brooklyn"));
		Assert.assertTrue(adqNeedFasterLink.isDisplayed());
		Utilities.explicitlyWait(3000);
		
		
		adqChangeZipCodeButton.click();
		adqZipCodeTextField.clear();
		adqZipCodeTextField.sendKeys("11412");
		adqSubmitZipCodeButton.click();
		Utilities.explicitlyWait(3000);

		String text2 = adqCityName.getText();
		Assert.assertTrue(text2.contains("Saint Albans"));


	}
	
	
	
	
	public void fullPriceAlphaCodeVerification()
	{

	    
	    String AlphaCode1 =  productID.getText();
	    Assert.assertTrue(AlphaCode1.contains("PF"));  
	
	}
	
	public void salePriceAlphaCodeVerification()
	{
	    String AlphaCode2 = productID.getText();	
	    Assert.assertTrue(AlphaCode2.contains("PO"));

	}
	
	
}