package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Test.TestCaseConfiguration;
import Tools.Utilities;

public class ShoppingBagPage {


	private WebElement aux;
	
	/*--------------------------------------------------* WebElements *--------------------------------------------------*/	
	/*-------------------------------------------------- General Elements --------------------------------------------------*/
	
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
	
	@FindBy(xpath  = "id('keepItems')/span")
	WebElement sbClearLayerKeepItems;
	
	@FindBy(xpath  = "id('un_removeallcontent')//a")
	WebElement sbClearLayerRemoveAll;
	
	@FindBy(xpath  = "//div[@class = 'shoppingBagDays']/a[1]")
	WebElement sbDaysMessageLoginLink;
	
	@FindBy(xpath  = "//div[@class = 'shoppingBagDays']/a[2]")
	WebElement sbDaysMessageCreateAccountLink;
	
	@FindBy(xpath  = "//div[@class = 'sbPopupTitle' and contains(.,'Merge Bag')]")
	WebElement sbMergeMessagePopipTitle;
	
	@FindBy(xpath  = "id('un_popup_wrapper')//input")
	WebElement sbMergePopipOkButton;

	@FindBy(xpath  = "//div[@class = 'sbItemAttributes']")
	WebElement ProductID;
	
	@FindBy(name ="un_jtt_promocodeinput")
	WebElement EnterPromo;
	
	@FindBy(name = "un_jtt_promocode1_promoNumber")
	WebElement ClickRedeem;
	
	@FindBy (xpath ="//div[@class ='un_float_right']")
	WebElement Priceb4Promo;
	
	@FindBy (xpath ="//div[@id='wlsb_rtSBButton']/div/div/div[2]/div[7]/div[2]")
	WebElement PriceAfterPromo;
	
	@FindBy(id = "un_shiptoAll")
	WebElement AddRecDropDown;
	
	@FindBy(linkText = "Add New Recipient")
	WebElement AddNewRecipient;
	
	@FindBy(id="id_newRecipientName1")
	WebElement PopTextEnter;
	
	@FindBy(css = "div.un_wid100 > input[name=\"un_jtt_addnewrec_0\"]")
	WebElement SaveNewRecipient;
	
	@FindBy(id = "un_shipto_All1")
	WebElement SavedRecipient;
	
	@FindBy(id= "un_title_text un_wid50")
	WebElement SBTitle;
	
	@FindBy(xpath = "//div[@class='sel_attributes']")
	List<WebElement> sBMonogramOptions;
	
	@FindBy(xpath ="//div[@class='giftCardMessageDiv']")
	WebElement sbgiftCardMessage;
	
	@FindBy(xpath = "//div[@class='sbItemAttributes']/div[2]")
	WebElement sbgiftcardValue;
	
	@FindBy(xpath ="//div[@class='wlsb_giftCardEmail']/div[1]")
	WebElement sbgiftcardRecepientName;
	
	@FindBy(xpath ="//div[@class='wlsb_giftCardEmail']/div[2]")
	WebElement sbgiftcardRecepientEmail;
	
	@FindBy(xpath ="//a[@class='sb_itemNameAnc  ']")
	WebElement sbgiftcardName;
	
	@FindBy(xpath ="//div[@class='sbItemAttributes']/div[4]")
	WebElement sbgiftcardDeliveryDate;
	
	
	
		
	/*-------------------------------------------------- functions --------------------------------------------------*/
	
	private WebElement getProductInSB(String productID ) {
		return TestCaseConfiguration.driver.get().findElement(By.xpath("//div[@class = 'sbItemAttributes']/div[contains(.,'"+productID+"')]/../../.."));
	}
	
	protected void updateProductQty(String qty, String productID) {
		aux = getProductInSB(productID);
		aux.findElement(By.xpath("//input[@id]")).sendKeys(qty);
		aux.findElement(By.xpath("//input[@value = 'Update']")).click();		
	}
	
	protected void moveProductToWishList(String productID) {
		aux = getProductInSB(productID);
		aux.findElement(By.linkText("Move to Wish List")).click();		
	}
	
	protected void removeProduct(String productID) {
		aux = getProductInSB(productID);
		aux.findElement(By.linkText("Remove")).click();		
	}
	
	public LoginPageObjects startCheckoutProcessAsGuest(){
		Utilities.waitForAjaxToFinish();
		if(sbCheckoutButton.isDisplayed()) {
			sbCheckoutButton.click();
			//ExtentManager.getExtentTest().log(LogStatus.PASS, "StartCheckout", "Success");
		}
		/*else 
			ExtentManager.getExtentTest().log(LogStatus.FAIL, "StartCheckout", "Failed");
		ExtentManager.getExtentTest().log(LogStatus.PASS, "StartCheckout", "Success");*/
		return PageFactory.initElements(TestCaseConfiguration.driver.get(), LoginPageObjects.class);
	}	
	
	public CheckoutPageObjects startCheckoutProcess() {
		Utilities.waitForAjaxToFinish();		
		Utilities.explicitlyWait(3000);
		
		if(sbCheckoutButton.isDisplayed()) {
			Actions actions = new Actions(TestCaseConfiguration.driver.get());
			actions.moveToElement(sbCheckoutButton).click().perform();
		}
		else 
			Assert.assertTrue(false, "Checkout button was not displayed");		
		
		return PageFactory.initElements(TestCaseConfiguration.driver.get(), CheckoutPageObjects.class);
	}
	
	/*-------------------------------------------------- Validations --------------------------------------------------*/
	public void validateMergeMessage() {
		if(sbMergeMessagePopipTitle.isDisplayed())
		{
			closeMergeMessage();
		} 
	}
	
	public void closeMergeMessage(){		
		try {
			if(sbMergePopipOkButton.isDisplayed())		
				sbMergePopipOkButton.click();
		
		} catch (Exception e) {}
	}

	public ShoppingBagPage clearSB() {
		Utilities.waitForAjaxToFinish();
		Utilities.explicitlyWait(2000);
		
		Boolean notEmpty = !Utilities.isElementPresent(TestCaseConfiguration.driver.get(), By.id("un_cartempty"));
		if(notEmpty)
		{
			closeMergeMessage();
			
			Utilities.waitForAjaxToFinish();
			Utilities.explicitlyWait(7000);
			sbClearSBLink.click();
			Utilities.explicitlyWait(3000);

			if(sbClearLayerRemoveAll.isDisplayed()){
				sbClearLayerRemoveAll.click();
			}
		}
		
		return PageFactory.initElements(TestCaseConfiguration.driver.get(), ShoppingBagPage.class);
	}
	
	public void isSBEmpty() {
		Utilities.waitForAjaxToFinish();
		
		/*if(Utilities.isElementPresent(TestCaseConfiguration.driver.get(), By.id("un_cartempty")))
			ExtentManager.getExtentTest().log(LogStatus.PASS, "SBIsEmpty ", "Success");
		else
			ExtentManager.getExtentTest().log(LogStatus.FAIL, "SBIsEmpty ", "Missing Clear SB Layer");*/
	}
	
	public void FullPriceItem()
	{
		
		Assert.assertTrue(ProductID.getText().contains("PF"));
   
	}
	
	public void SalePriceItem()
	{
		
		Assert.assertTrue(ProductID.getText().contains("PO"));  
	}
	
	public void PromoCodeVerification()
	{
		
		String FirstPrice = Priceb4Promo.getText();
		String BeforeRedeem = FirstPrice.substring(1, 6);
		double b = Double.parseDouble(BeforeRedeem);
		
		System.out.println(b);
		EnterPromo.sendKeys("EXCLNOTH");
		ClickRedeem.click();
		
		Utilities.explicitlyWait(7000);
		Utilities.waitForAjaxToFinish();
		
		String SecondPrice = PriceAfterPromo.getText();
		String AfterRedeem = SecondPrice.substring(1, 6);
		double c = Double.parseDouble(AfterRedeem);
		System.out.println(c);	
		Assert.assertTrue(b>c);
		//Assert.assertEquals(c, "331.2");
	
	}
	
	public void AddNewRecipient()
	
	{
		
		AddRecDropDown.click();
		Utilities.explicitlyWait(2000);
		AddNewRecipient.click();
		Utilities.explicitlyWait(2000);
		PopTextEnter.sendKeys("Dave");
		SaveNewRecipient.click();
		Utilities.explicitlyWait(3000);	
		
		System.out.println(SavedRecipient);
		Utilities.waitForAjaxToFinish();

		Assert.assertTrue(SavedRecipient.getText().equals("Dave"));
		

	}
	
	public void ShoppingBagTitleVerification()
	
	{
		
		
		Assert.assertTrue(SBTitle.getText().equals("Shopping Bag"));

	}
	
	public void ClickCheckOut()
	{
		sbCheckoutButton.click();
		Utilities.explicitlyWait(3000);	

		Assert.assertTrue(TestCaseConfiguration.driver.get().getPageSource().contains("Have an llbean.com account?"));


	}	
	
	
public void sBgiftCardVerification()
{
	String[] s1= sbgiftCardMessage.getText().split(": ");
	String[] s2= sbgiftcardValue.getText().split(": ");
    String[] s3 = sbgiftcardRecepientName.getText().split(": ");
    String s4 = sbgiftcardRecepientEmail.getText();
    String s5 =sbgiftcardName.getText();
    String[] s6 = sbgiftcardDeliveryDate.getText().split(": ");

	Assert.assertEquals(s1[1], "Happy New Year");
	Assert.assertEquals(s2[1], "$10.00");
	Assert.assertEquals(s3[1], "David");
	Assert.assertEquals(s4, "dave123@gmail.com");
	Assert.assertEquals(s5, "Night Tent E-Mail Gift Card");
	//Assert.assertEquals(s6[1], "Tuesday, January 05, 2016");
}
	
public String MonogramVerification()

{
	

	int icount = 0;
	String returntext = "";
	for(WebElement E2: sBMonogramOptions)
		
    {
		if(icount>2)
		{
		if(E2.getText().contains(": "))
		{
		String[] s1= E2.getText().split(": ");
		
    	System.out.println(s1[1]);
    	returntext = returntext + ";" + s1[1];

		}
		

		}
		icount = icount+1;
		
    }

	return returntext;
	    
}
}