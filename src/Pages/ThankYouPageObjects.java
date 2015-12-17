package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import Test.TestCaseConfiguration;
import Tools.Utilities;
import DataObjects.AddressData;
import DataObjects.ProductData;

public class ThankYouPageObjects {
	private WebElement productOnList;

	@FindBy(xpath  = "id('wlsb_products')//span[not(contains(.,'Order Number'))]")
	WebElement tyOrderNumberLabel;
	
	@FindBy(xpath  = "//div[@class = 'billDisplayWrapper un_ckOutReviewBlockCont']")
	WebElement tyBillingAddressSection;
	
	@FindBy(xpath  = "//div[@class = 'shipDisplayWrapper_review un_ckOutReviewBlockCont']")
	WebElement tyShippingAddressSection;
	
	@FindBy(xpath  = "(//div[@class = 'un_chkoutInputLabel'])[1]")
	WebElement tyPaymentMethodSection;
	
	@FindBy(xpath  = "//div[@class = 'shippingDescription']")
	WebElement tyShippingMethodLabel;
	
	@FindBy(xpath  = "//span[@class = 'shipSinglItemDate']")
	WebElement tyShippingDateLabel;
	
	@FindBy(xpath  = "//div[@class = 'chkOutOrsumSection']")
	WebElement tyOrderSummaryBalanceSection;
	
	@FindBy(xpath = "//input[@value='CONTINUE SHOPPING']")
	WebElement paymentContinueButton;
	
	/**
	 * Find the complete section which contains the product data in SB page
	 * @param productID Six number digit to identify the desired product
	 * @param driver Current webdriver in use.
	 * @return WebElement with the product details
	 * 
	 *  @author Yohan Desanti G.  
	 *  @LastUpdate Yohan Desanti G.
	 *  @version 1.0, 11/24/2015
	 */
	private WebElement getProductInSB(String productID) {
		By selector = By.xpath("//div[@class = 'chkout_Review_InputLabel' and contains(.,'"+productID+"')]/../../..");
		Assert.assertTrue(Utilities.isElementPresent(TestCaseConfiguration.driver.get(), selector), "Product "+productID+" is not present on Thank You page");
		return TestCaseConfiguration.driver.get().findElement(selector);
	}

	/**
	 * Check the presence of the product basic details such as ID, Name, Price, Color, Size and Qty. Throw an assertion error in case of any of these attributes doesn't match the selected in PDP or are not present in TY page.
	 * 
	 * @param productData Product object which contain the exact attributes selected in PDP before adding the product to SB
	 * @param driver Current webdriver in use.
	 * 
	 * 
	 *  @author Yohan Desanti G.  
	 *  @LastUpdate Yohan Desanti G.
	 *  @version 1.0, 12/4/2015
	 */
	public void verifyProductBasicAttributes(ProductData productData) {			
		Utilities.waitForAjaxToFinish();//wait for page to be fully loaded
		//Check if the product ID is present and if it is, create a new element based on it.
		productOnList = getProductInSB(productData.getProductID());
		
		//Verify the product name is correct
		Assert.assertTrue(Utilities.isElementPresent(TestCaseConfiguration.driver.get(), By.xpath("//u[contains(.,'"+productData.getProductName()+"')]")), "Product Name added to Shopping Bag doesn't match the one displayed in Thank You page");
		
		//Verify the product price is correct
		Assert.assertEquals(productOnList.findElement(By.xpath("//div[contains(@class, 'itemPrice') and not(contains(@style, 'line-through'))]")).getText(), productData.getProductPrice(), "Product Price added to Shopping Bag for Product "+productData.getProductID()+" doesn't match the one displayed in Thank You page");
		
		//Verify the product color is correct
		Assert.assertEquals(productOnList.findElement(By.xpath("(//div[@class = 'chkout_Review_InputLabel' ])[2]")).getText(), "Color/Style: "+productData.getProductColor(), "Product Color added to Shopping Bag for Product "+productData.getProductID()+" doesn't match the one displayed in Thank You page");
				
		//Verify the product size is correct
		Assert.assertEquals(productOnList.findElement(By.xpath("(//div[@class = 'chkout_Review_InputLabel' ])[3]")).getText(), "Size: "+productData.getProductSize(), "Product Size added to Shopping Bag for Product "+productData.getProductID()+" doesn't match the one displayed in Thank You page");
		
		//Verify the product Qty is correct
		Assert.assertEquals(productOnList.findElement(By.xpath("//div[contains(., 'Qty:') and contains(@class, 'ckOut_Review_ItemPrice')]")).getText(), "Qty: "+productData.getProductQty(), "Product Qty added to Shopping Bag for Product "+productData.getProductID()+" doesn't match the one displayed in Thank You page");
		
	}

	/**
	 * Check the presence of the order shipping information such as Address, Country, Zip Code and Phone. Throw an assertion error in case of any of these details doesn't match the selected in Shipping step or are not present in TY page.
	 * 
	 * @param shippingAddress Shipping Address object which contains the information entered in the Checkout's Shipping step. 
	 * @param driver Current webdriver in use.
	 * 
	 *  @author Yohan Desanti G.  
	 *  @LastUpdate Yohan Desanti G.
	 *  @version 1.0, 12/7/2015
	 */
	public void verifyShippingAddress(AddressData shippingAddress) {		
		Utilities.waitForAjaxToFinish();//wait for page to be fully loaded
		Assert.assertTrue(Utilities.isElementPresent(TestCaseConfiguration.driver.get(), By.xpath("//div[@class = 'shipDisplayWrapper_review un_ckOutReviewBlockCont']//div[contains(.,'"+shippingAddress.getAddress1()+"')]")), "Address Line 1 is not found for Shipping Address Summary");
		Assert.assertTrue(
				Utilities.isElementPresent(
						TestCaseConfiguration.driver.get(), 
						By.xpath("//div[@class = 'shipDisplayWrapper_review un_ckOutReviewBlockCont']"
								+ "//div["
									+ "contains("
										+ "translate(., 'ABCDEFGHJIKLMNOPQRSTUVWXYZ', 'abcdefghjiklmnopqrstuvwxyz'),"
										+ "translate('"+shippingAddress.getCountry()+"', 'ABCDEFGHJIKLMNOPQRSTUVWXYZ', 'abcdefghjiklmnopqrstuvwxyz')"
										+ ")"
									+ "]"
								)
				), 
				"Country is not found for Shipping Address Summary"
		);
		Assert.assertTrue(Utilities.isElementPresent(TestCaseConfiguration.driver.get(), By.xpath("//div[@class = 'shipDisplayWrapper_review un_ckOutReviewBlockCont']//div[contains(.,'"+shippingAddress.getZipCode()+"')]")), "Zip Code is not found for Shipping Address Summary");
		Assert.assertTrue(Utilities.isElementPresent(TestCaseConfiguration.driver.get(), By.xpath("//div[@class = 'shipDisplayWrapper_review un_ckOutReviewBlockCont']//div[contains(.,'"+shippingAddress.getDaytimePhone()+"')]")), "Daytime phone number is not found for Shipping Address Summary");
	}

	/**
	 * Check the presence of the order billing information such as Address, Country, Zip Code, email and Phone. Throw an assertion error in case of any of these details doesn't match the selected in Billing step or are not present in TY page.
	 * 
	 * @param billingAddress Billing Address object which contain the information entered in the Checkout's Billing Step.
	 * @param driver Current webdriver in use.
	 * 
	 *  @author Yohan Desanti G.  
	 *  @LastUpdate Yohan Desanti G.
	 *  @version 1.0, 12/7/2015
	 */
	public void verifyBillingAddress(AddressData billingAddress) {		
		Utilities.waitForAjaxToFinish();//wait for page to be fully loaded
		Assert.assertTrue(Utilities.isElementPresent(TestCaseConfiguration.driver.get(), By.xpath("//div[@class = 'billDisplayWrapper un_ckOutReviewBlockCont']//div[contains(.,'"+billingAddress.getAddress1()+"')]")), "Address Line 1 is not found for Billing Address Summary");
		Assert.assertTrue(Utilities.isElementPresent(TestCaseConfiguration.driver.get(), By.xpath("//div[@class = 'billDisplayWrapper un_ckOutReviewBlockCont']//div[contains(  translate(., 'ABCDEFGHJIKLMNOPQRSTUVWXYZ', 'abcdefghjiklmnopqrstuvwxyz'),    translate('"+billingAddress.getCountry()+"', 'ABCDEFGHJIKLMNOPQRSTUVWXYZ', 'abcdefghjiklmnopqrstuvwxyz'))]")), "Country is not found for Billing Address Summary");
		Assert.assertTrue(Utilities.isElementPresent(TestCaseConfiguration.driver.get(), By.xpath("//div[@class = 'billDisplayWrapper un_ckOutReviewBlockCont']//div[contains(.,'"+billingAddress.getZipCode()+"')]")), "Zip Code is not found for Billing Address Summary");
		Assert.assertTrue(Utilities.isElementPresent(TestCaseConfiguration.driver.get(), By.xpath("//div[@class = 'billDisplayWrapper un_ckOutReviewBlockCont']//div[contains(.,'"+billingAddress.getDaytimePhone()+"')]")), "Daytime phone number is not found for Billing Address Summary");
		Assert.assertTrue(Utilities.isElementPresent(TestCaseConfiguration.driver.get(), By.xpath("//div[@class = 'billDisplayWrapper un_ckOutReviewBlockCont']//div[contains(.,'"+billingAddress.getEmail()+"')]")), "Email address is not found for Billing Address Summary");	
	}
}
