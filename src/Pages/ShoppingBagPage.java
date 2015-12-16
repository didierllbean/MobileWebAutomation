package Pages;

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
	WebElement ItemPrice;
	
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
		sbCheckoutButton.click();

		ExtentManager.getExtentTest().log(LogStatus.PASS, "StartCheckout", "Success");
		return PageFactory.initElements(TestCaseConfiguration.driver.get(), LoginPageObjects.class);
	}	
	
	public CheckoutPageObjects startCheckoutProcess() {
		Utilities.waitForAjaxToFinish();
		
		closeMergeMessage();
		
		sbCheckoutButton.click();
		ExtentManager.getExtentTest().log(LogStatus.PASS, "StartCheckout", "Success");
		
		return PageFactory.initElements(TestCaseConfiguration.driver.get(), CheckoutPageObjects.class);
	}
	
	/*-------------------------------------------------- Validations --------------------------------------------------*/
	public void validateMergeMessage() {
		if(sbMergeMessagePopipTitle.isDisplayed())
		{
			ExtentManager.getExtentTest().log(LogStatus.PASS, "MergeMessageDisplay", "Success");
			closeMergeMessage();
		} else
			ExtentManager.getExtentTest().log(LogStatus.FAIL, "MergeMessageDisplay", "MissingElement");
	}
	
	public void closeMergeMessage(){		
		try {
			if(sbMergePopipOkButton.isDisplayed())		
				sbMergePopipOkButton.click();
			else
				ExtentManager.getExtentTest().log(LogStatus.FAIL, "MergeMessageOkButton", "MissingElement");
		
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
				ExtentManager.getExtentTest().log(LogStatus.PASS, "ClearSBLayerDisplayed ", "Success");
				sbClearLayerRemoveAll.click();
			}
			else
				ExtentManager.getExtentTest().log(LogStatus.FAIL, "ClearSBLayerDisplayed ", "Missing Clear SB Layer");
		}
		else {
			ExtentManager.getExtentTest().log(LogStatus.FAIL, "SBAlredyEmpty", "There Are No Products To Remove");
			Assert.assertTrue(notEmpty, "There Are No Products To Remove, the SB is already empty");
		}
		
		
		return PageFactory.initElements(TestCaseConfiguration.driver.get(), ShoppingBagPage.class);
	}
	
	public void isSBEmpty() {
		Utilities.waitForAjaxToFinish();
		
		if(Utilities.isElementPresent(TestCaseConfiguration.driver.get(), By.id("un_cartempty")))
			ExtentManager.getExtentTest().log(LogStatus.PASS, "SBIsEmpty ", "Success");
		else
			ExtentManager.getExtentTest().log(LogStatus.FAIL, "SBIsEmpty ", "Missing Clear SB Layer");
	}
	
	public void FullPriceItem()
	{
	    String AlphaCode1 = ItemPrice.getText();
		
	    if(AlphaCode1.contains("PF"))
	    {
			ExtentManager.getExtentTest().log(LogStatus.PASS, "FullPrice Item Number Contains PF AlphaCode");

	    	
	    }
	    else
	    {
			ExtentManager.getExtentTest().log(LogStatus.FAIL, "FullPrice Item Number Does Not Contain PF AlphaCode");

	    }
	    
	    
	}
	
	public void SalePriceItem()
	{
	    String AlphaCode2 = ItemPrice.getText();
		
	    if(AlphaCode2.contains("PO"))
	    {
			ExtentManager.getExtentTest().log(LogStatus.PASS, "SalePrice Item Number Contains PO AlphaCode");
	    	
	    }
	    else
	    {
			ExtentManager.getExtentTest().log(LogStatus.FAIL, "SalePrice Item Number Does Not Contain PO AlphaCode");

	    }
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
		
		String SecondPrice = PriceAfterPromo.getText();
		String AfterRedeem = SecondPrice.substring(1, 6);
		double c = Double.parseDouble(AfterRedeem);
		System.out.println(c);

	    if(b>c)
	    {
			ExtentManager.getExtentTest().log(LogStatus.PASS, "PromoCode Successfully Applied");
	    }
	    else
	    {
			ExtentManager.getExtentTest().log(LogStatus.FAIL, "PromoCode Failed To Apply");

	    }
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
		String RecipientName = SavedRecipient.getText();
		System.out.println(RecipientName);
	
	
		if(RecipientName.equals("Dave"))
		{
			ExtentManager.getExtentTest().log(LogStatus.PASS, " New Recipient Successfully Added");

		}
		else
		{
			ExtentManager.getExtentTest().log(LogStatus.FAIL, " New Recipient Not Added");

		}		

	}
	
	public void ShoppingBagTitleVerification()
	
	{
		String Title = SBTitle.getText();
		
		if(Title.equals("Shopping Bag"))
		{
			ExtentManager.getExtentTest().log(LogStatus.PASS, " Shopping Bag Title Is Present");
		}
		else
		{
			ExtentManager.getExtentTest().log(LogStatus.FAIL, " Shopping Bag Title Is Not Present");

		}
	}
	
	public void ClickCheckOut()
	{
		sbCheckoutButton.click();
		Utilities.explicitlyWait(3000);	

		
		if(TestCaseConfiguration.driver.get().getPageSource().contains("Have an llbean.com account?"))
				{
			ExtentManager.getExtentTest().log(LogStatus.PASS, " Login Page Loaded");

				}
		else
		{
			ExtentManager.getExtentTest().log(LogStatus.FAIL, " Login Page Failed To Load");

		}

	}
	
	
	
	
	
}
