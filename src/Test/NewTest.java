package Test;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import Pages.MenuPageObjects;
import Pages.ProductListPageObjects;
import Pages.HomePageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class NewTest {
	HomePageObjects HP;
	MenuPageObjects MP;
	ProductListPageObjects plp;
    WebDriver driver;
    
    
    static DesiredCapabilities  capabilities;
	static String DeviceName;
   //WebDriver driver = new ChromeDriver(capabilities);
    
  @BeforeTest
  public void setup(){	  
	  
	    
	 String DeviceName = "Apple iPhone 6";
	    
  	System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
  	
  	capabilities = DesiredCapabilities.chrome();
 	 Map<String, String> mobileEmulation = new HashMap<String, String>();
 	  mobileEmulation.put("deviceName", DeviceName);
 	  
 	  Map<String, Object> chromeOptions = new HashMap<String, Object>();
 	  chromeOptions.put("mobileEmulation", mobileEmulation);

	capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
    WebDriver driver = new ChromeDriver(capabilities);
  
   driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
   
   driver.get("https://m-ecwebq.llbean.com/index.html?nav=ftlink#userlogin");

  }
   
  @Test
  public void f() {
	  
	  MP = new MenuPageObjects();
	  HP = new HomePageObjects();
	  plp = new ProductListPageObjects();
	  
	  MP.NavigateToPlp(driver);
	  String verifiedtxt = plp.PLPVerification(driver);
	  
	  
  }
}
