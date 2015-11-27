package Pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

public class ProductListPageObjects {

	/**
	 * 
	 * All WebElements are identified by @FindBy annotation
	 */

	WebDriver driver;

	@FindBy(xpath = "//div[@id='id_scfContent_productlistpage']/div[1]/div[6]")
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

	public String PLPVerification(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		String text1 = PLPSearchRsName.getText();
		return text1;
	}
}