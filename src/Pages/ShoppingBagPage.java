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
		
		if(sbMergeMessagePopipTitle.isDisplayed())
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
}
