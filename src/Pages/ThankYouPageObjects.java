package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
		return productOnList = driver.findElement(By.xpath("//div[@class = 'chkout_Review_InputLabel' and contains(.,'"+productID+"')]/../../.."));
	}

}
