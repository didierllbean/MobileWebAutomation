package Pages;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
 
import org.openqa.selenium.WebElement;
 
import org.openqa.selenium.support.FindBy;
 
public class AccountPageObjects {
 
    /**
 
     * All WebElements are identified by @FindBy annotation
 
     */
 
    WebDriver driver;
 
    @FindBy(name = "logonId")

    WebElement LLBLogin;
 
    @FindBy(name="logonPassword")
 
    WebElement LLBPassword;
    
    
    @FindBy(name="un_jtt_login")
    
    WebElement LoginBttn;
    
    
    
    
    
    
}