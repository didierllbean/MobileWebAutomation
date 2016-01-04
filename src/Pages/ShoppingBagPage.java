package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import Test.TestCaseConfiguration;
import Tools.ExtentManager;
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
	List<WebElement> sBMonogramOptions ;
	
	
	
	
	
	 /*"//div[2]/div[2]/span[@class='un_bold']"*/
	
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
		
		
		if(sbCheckoutButton.isDisplayed()) {
			sbCheckoutButton.click();
			//ExtentManager.getExtentTest().log(LogStatus.PASS, "StartCheckout", "Success");
		}
		/*else 
			ExtentManager.getExtentTest().log(LogStatus.FAIL, "StartCheckout", "Failed");*/
		
		
		return PageFactory.initElements(TestCaseConfiguration.driver.get(), CheckoutPageObjects.class);
	}
	
	/*-------------------------------------------------- Validations --------------------------------------------------*/
	public void validateMergeMessage() {
		if(sbMergeMessagePopipTitle.isDisplayed())
		{
			//ExtentManager.getExtentTest().log(LogStatus.PASS, "MergeMessageDisplay", "Success");
			closeMergeMessage();
		} /*else
			ExtentManager.getExtentTest().log(LogStatus.FAIL, "MergeMessageDisplay", "MissingElement");*/
	}
	
	public void closeMergeMessage(){		
		try {
			if(sbMergePopipOkButton.isDisplayed())		
				sbMergePopipOkButton.click();
			/*else
				ExtentManager.getExtentTest().log(LogStatus.FAIL, "MergeMessageOkButton", "MissingElement");*/
		
		} catch (Exception e) {}
	}

	public ShoppingBagPage clearSB() {
		Utilities.waitForAjaxToFinish();
		
		Boolean notEmpty = !Utilities.isElementPresent(TestCaseConfiguration.driver.get(), By.id("un_cartempty"));
		if(notEmpty)
		{
			closeMergeMessage();
			
			sbClearSBLink.click();
			if(sbClearLayerRemoveAll.isDisplayed()){
				//ExtentManager.getExtentTest().log(LogStatus.PASS, "ClearSBLayerDisplayed ", "Success");
				sbClearLayerRemoveAll.click();
			}
			/*else
				ExtentManager.getExtentTest().log(LogStatus.FAIL, "ClearSBLayerDisplayed ", "Missing Clear SB Layer");*/
		}
		/*else {
			ExtentManager.getExtentTest().log(LogStatus.FAIL, "SBAlredyEmpty", "There Are No Products To Remove");
			Assert.assertTrue(notEmpty, "There Are No Products To Remove, the SB is already empty");
		}*/
		
		
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
		EnterPromo.sendKeys("QATHANKS15");
		ClickRedeem.click();
		
		Utilities.explicitlyWait(7000);
		
		String SecondPrice = PriceAfterPromo.getText();
		String AfterRedeem = SecondPrice.substring(1, 6);
		double c = Double.parseDouble(AfterRedeem);
		System.out.println(c);	
		Assert.assertTrue(b>c);
	
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
	
public void MonogramVerification()

{
	
	for(WebElement E1: sBMonogramOptions)
    {
    	System.out.println(E1.getText());
    	
    }
	    
}
}
