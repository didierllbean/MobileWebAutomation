package Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Pages.HomePageObjects;
import Tools.Constants;

public class TestCaseConfiguration {

     protected ChromeDriver driver = null;
     protected HomePageObjects homePage = null;
     protected DesiredCapabilities  capabilities;
    
     @BeforeMethod(alwaysRun = true)
     public void setup() throws InterruptedException {
    	 System.setProperty("webdriver.chrome.driver", "src/Tools/chromedriver.exe");//chrome driver version 2.20 | We need to have a relative path since no all the user will have the driver on C: 
    	 
    	 capabilities = DesiredCapabilities.chrome();
     	 Map<String, String> mobileEmulation = new HashMap<String, String>();
     	 mobileEmulation.put("deviceName", Constants.DEVICE);
     	 
     	 Map<String, Object> chromeOptions = new HashMap<String, Object>();
   	  	 chromeOptions.put("mobileEmulation", mobileEmulation);
   	  	 
   	  	 capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
     	  
		 driver = new ChromeDriver(capabilities);
		 driver.manage().deleteAllCookies();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
		 driver.get(Constants.DOMAIN);
		 homePage = PageFactory.initElements(driver, HomePageObjects.class);
     }
    
     @AfterMethod(alwaysRun = true)
     public void close() throws InterruptedException {         
         //driver.close();
         //driver.quit();
     }
}