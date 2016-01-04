package Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Test.TestCaseConfiguration;
import Tools.Utilities;

public class MonogramConfigurationPage {

	/**
	 * WebElements
	 */
	
	/** General Elements **/
	
	@FindBy(xpath  = "//div[@class = 'monogrammingTypes ui-grid-b']")
	WebElement monogramTypes;
	
	@FindBy(xpath = "//div[@class= 'monogramType' and contains(text(), 'Single Letter')]")
	WebElement singleLetter;
	
	@FindBy(xpath ="//img[contains(@src,'//ecwebs01.llbean.com/images/monogramming/monogram_icon_heirloom_sl.png')]")
	WebElement heirLoom;
	
	@FindBy(xpath  = "//div[@class = 'monogrammingTypes ui-grid-b']")
	WebElement monogramStyles;
	
	@FindBy(xpath  = "//div[@class = 'monoEdtName']//input")
	WebElement monogramNameTextField;
	
	@FindBy(xpath  = "//div[@class = 'monoEdtInitials']//input")
	WebElement monogramInitialsTextField;
	
	@FindBy(xpath  = "//div[@class = 'monoEdtSingleLetter']//input")
	WebElement monogramSingleLetterTextField;
	
	@FindBy(id = "threadColorSwatch")
	WebElement monogramColorsTable;
	
	@FindBy(xpath  = "//img[@class = 'monogramImage']")
	WebElement monogramPreviewImage;
		
	@FindBy(id = "monogramming_add_to_bag")
	WebElement monogramAddToBagButton;
	
	@FindBy(xpath = "//a[contains(.,'Skip')]")
	WebElement monogramSkipButton;
	
	@FindBy(xpath = "//span[@class='selMonogramOption']")
	List<WebElement> MonogramOptions;
	
	
	
	public MonogramConfigurationPage()
	{
	  	PageFactory.initElements(TestCaseConfiguration.driver.get(), this);		
	} 

	public void singleLetterMonogram()
	{
		Utilities.waitForAjaxToFinish();
        singleLetter.click();
        heirLoom.click();
    
        monogramSingleLetterTextField.sendKeys("S");
        
        for(WebElement E1: MonogramOptions)
        {
        	
        	
        	String text = E1.getText();
        	
        	System.out.println(text.replace("Single Letter", ""));
        	
        	
        
        }
        
        monogramAddToBagButton.click();	
	}
}