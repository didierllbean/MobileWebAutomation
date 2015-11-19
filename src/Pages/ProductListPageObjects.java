package Pages;
 
import org.openqa.selenium.WebDriver;
 
import org.openqa.selenium.WebElement;
 
import org.openqa.selenium.support.FindBy;
 
import org.openqa.selenium.support.PageFactory;
 
public class ProductListPageObjects {
 
    /**
 
     * All WebElements are identified by @FindBy annotation
 
     */
 
    WebDriver driver;
    
    @FindBy(xpath = "//div[@id='id_scfContent_productlistpage']/div[1]/div[6]")

     WebElement PLPSearchRsName;
    
    
    @FindBy(xpath ="//div[@id='id_scfContent_productlistpage']/div[1]/div[12]")
    
    WebElement PLPFilterRst;
    
    @FindBy(xpath ="//div[5]//div[4]/h3")
    
    WebElement PLPFLSizeRng;
    
    
    @FindBy(xpath ="//div[5]/div//div[4]/div/div[1]/div[2]")
    
    WebElement PLPFLSizeRngReg;
   
 
    @FindBy(name="btnLogin")
 
    WebElement login;
    
    
    public String PLPVerification (WebDriver driver){
    	
    	this.driver = driver;
    	PageFactory.initElements(driver, this);
    	String text1 = PLPSearchRsName.getText();
    	return text1;
    }
}