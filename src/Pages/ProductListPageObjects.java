package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;

import Test.TestCaseConfiguration;
import Tools.ExtentManager;
import Tools.Utilities;

public class ProductListPageObjects {

	/**
	 * 
	 * All WebElements are identified by @FindBy annotation
	 */

	WebDriver driver;

	@FindBy(xpath = "//div[@id='id_scfContent_searchpage']/div[1]/div[7]")
	WebElement PLPSearchRsName;

	@FindBy(xpath = "//div[@class='llbFilterResTxt' and contains(text(), 'Filter Results')]")
	WebElement PLPFilterRst;

	@FindBy(xpath = "//div/div[@name='Size Range']")
	WebElement PLPFLSizeRng;

	@FindBy(xpath = "//div/div[@name='Regular']/div[1]")
	WebElement PLPFLSizeRngReg;

	@FindBy(xpath = "//div/div[@name='Features']")
	WebElement PLPFLFeature;

	@FindBy(xpath = "//div/div[@name='Fade-Resistant']/div[1]")
	WebElement PLPFLFeatureAbrasionRstnt;

	@FindBy(xpath = "//div/div[@name='Fabric']")
	WebElement PLPFLFabric;

	@FindBy(xpath = "//div/div[@name='Cotton Blend']/div[1]")
	WebElement PLPFabricCtnBlend;

	@FindBy(xpath = "//div[@class='facetCatWFiltersResetAllTxt' and contains(text(), 'Reset All')]")
	WebElement PLPResetAllFilter;
	
	

	public ProductListPageObjects()
	{
	  	PageFactory.initElements(TestCaseConfiguration.driver.get(), this);		
	}
	
	public String PLPVerification() {

		String text1 = PLPSearchRsName.getText();
		System.out.println(text1);

		if(text1.contains("S"))
		{
			ExtentManager.getExtentTest().log(LogStatus.PASS, "Search Text Displays On Product List Page");

		}
		else
		{
			ExtentManager.getExtentTest().log(LogStatus.FAIL, "Search Text Displays On Product List Page");
		}
		return text1;

		
	}
	

}