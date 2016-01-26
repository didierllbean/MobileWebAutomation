package Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import Pages.HomePageObjects;
import Tools.Constants;

public class TestCaseConfiguration {
     protected HomePageObjects homePage = null;
     protected DesiredCapabilities  capabilities;
  	 protected ExtentReports REPORTMANAGER;
  	 protected ExtentTest REPORT;

  	 public static ThreadLocal<ChromeDriver> driver;
  	 private static Set<ChromeDriver> drivers = new HashSet<ChromeDriver>();
     
  	 @BeforeSuite(alwaysRun = true)
     public void initDriver() {
        System.setProperty("webdriver.chrome.driver", "src/Tools/chromedriver.exe");//chrome driver version 2.20 | We need to have a relative path since no all the user will have the driver on C:

        final DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        Map<String, String> mobileEmulation = new HashMap<String, String>();
        mobileEmulation.put("deviceName", Constants.DEVICE);
        Map<String, Object> chromeOptions = new HashMap<String, Object>();
        chromeOptions.put("mobileEmulation", mobileEmulation);

        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

        /**
         * dirver is a ThreadLocal<ChromeDriver>. This allows the driver to be static and available for the complete project, and exclusive for each thread.
         */
        driver = new ThreadLocal<ChromeDriver>() {
            @Override
            protected ChromeDriver initialValue() {
                return new ChromeDriver(capabilities);
            }
        };
        
        drivers.add(driver.get());
    }

    @BeforeMethod(alwaysRun = true)
    public void setup() throws InterruptedException {
        driver.get().manage().deleteAllCookies();
        driver.get().manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.get().navigate().to(Constants.DOMAIN);
		driver.get().manage().addCookie(new Cookie("LLBSS","A"));
        homePage = PageFactory.initElements(driver.get(), HomePageObjects.class);
    }
    
    @AfterSuite(alwaysRun = true)
    public void closeBrowser() throws InterruptedException {  
    	
    	for (ChromeDriver chromeDriver : drivers) {
            try {
            	chromeDriver.close();
                chromeDriver.quit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    	       
    	System.gc();
    }
}