package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MonogramConfigurationPage {

	/**
	 * WebElements
	 */
	
	/** General Elements **/
	
	@FindBy(xpath  = "//div[@class = 'monogrammingTypes ui-grid-b']")
	WebElement monogramTypes;
	
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
}
