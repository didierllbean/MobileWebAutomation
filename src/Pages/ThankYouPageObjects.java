package Pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import Tools.Utilities;
import DataObjects.AddressData;
import DataObjects.ProductData;

public class ThankYouPageObjects {
	private WebElement productOnList,
	aux;

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
	
	private WebElement getProductInSB(String productID, WebDriver driver) {
		By selector = By.xpath("//div[@class = 'chkout_Review_InputLabel' and contains(.,'"+productID+"')]/../../..");
		Assert.assertTrue(Utilities.isElementPresent(driver, selector), "Product "+productID+" is not present on Thank You page");
		return driver.findElement(selector);
	}

	public void verifyProductBasicAttributes(ProductData productData, WebDriver driver) {	
		Utilities.explicitlyWait(2000);
		//Check if the product ID is present and if it is, create a new element based on it.
		productOnList = getProductInSB(productData.getProductID(), driver);
		
		//Verify the product name is correct
		Assert.assertTrue(Utilities.isElementPresent(driver, By.xpath("//u[contains(.,'"+productData.getProductName()+"')]")), "Product Name added to Shopping Bag doesn't match the one displayed in Thank You page");
		
		//Verify the product price is correct
		Assert.assertEquals(productOnList.findElement(By.xpath("//div[contains(@class, 'itemPrice') and not(contains(@style, 'line-through'))]")).getText(), productData.getProductPrice(), "Product Price added to Shopping Bag for Product "+productData.getProductID()+" doesn't match the one displayed in Thank You page");
		
		//Verify the product color is correct
		Assert.assertEquals(productOnList.findElement(By.xpath("(//div[@class = 'chkout_Review_InputLabel' ])[2]")).getText(), "Color/Style: "+productData.getProductColor(), "Product Color added to Shopping Bag for Product "+productData.getProductID()+" doesn't match the one displayed in Thank You page");
				
		//Verify the product size is correct
		Assert.assertEquals(productOnList.findElement(By.xpath("(//div[@class = 'chkout_Review_InputLabel' ])[3]")).getText(), "Size: "+productData.getProductSize(), "Product Size added to Shopping Bag for Product "+productData.getProductID()+" doesn't match the one displayed in Thank You page");
		
		//Verify the product Qty is correct
		Assert.assertEquals(productOnList.findElement(By.xpath("//div[contains(., 'Qty:') and contains(@class, 'ckOut_Review_ItemPrice')]")).getText(), "Qty: "+productData.getProductQty(), "Product Qty added to Shopping Bag for Product "+productData.getProductID()+" doesn't match the one displayed in Thank You page");
		
	}

	public void verifyShippingAddress(AddressData shippingAddress, ChromeDriver driver) {
		// TODO Auto-generated method stub
		
	}

	public void verifyBillingAddress(AddressData billingAddress, ChromeDriver driver) {
		// TODO Auto-generated method stub
		
	}
	
	

}
