package Test;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Pages.HomePageObjects;
import Tools.Constants;
import Tools.ExtentManager;

public class TestCaseConfiguration {
     protected HomePageObjects homePage = null;
     protected DesiredCapabilities  capabilities;
  	 protected ExtentReports REPORTMANAGER;
  	 protected ExtentTest REPORT;

  	 public static ThreadLocal<ChromeDriver> driver;

	/*@BeforeClass(alwaysRun = true)
	public void beforeClass() {
		REPORTMANAGER = ExtentManager.getReporter(Constants.REPORTFILEPATH);
	}*/

     @BeforeMethod(alwaysRun = true)
     public void setup() throws InterruptedException {
    	 
    	 System.setProperty("webdriver.chrome.driver", "src/Tools/chromedriver.exe");//chrome driver version 2.20 | We need to have a relative path since no all the user will have the driver on C: 
    	    	 
    	 capabilities = DesiredCapabilities.chrome();
     	 Map<String, String> mobileEmulation = new HashMap<String, String>();
     	 mobileEmulation.put("deviceName", Constants.DEVICE);
     	 Map<String, Object> chromeOptions = new HashMap<String, Object>();
   	  	 chromeOptions.put("mobileEmulation", mobileEmulation);
   	  	 
   	  	 capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
     	  
   	  	 /**
   	  	  * dirver is a ThreadLocal<ChromeDriver>. This allows the driver to be static and available for the complete project, and exclusive for each thread. 
   	  	  */
   	  	 driver=new ThreadLocal<ChromeDriver>()
   	                {
   	                    @Override
   	                    protected ChromeDriver initialValue()
   	                    {
   	                        return new ChromeDriver(capabilities); 
   	                    }
   	                };
		 driver.get().manage().deleteAllCookies();
		 //driver.get().manage().window().maximize();
		 driver.get().manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		 driver.get().navigate().to(Constants.DOMAIN);
		 
		 homePage = PageFactory.initElements(driver.get(), HomePageObjects.class);
     }
    
     @AfterMethod(alwaysRun = true)
     public void close(/*ITestResult result*/) throws InterruptedException {   

    	 
 		//driver.get().close();
 		//driver.get().quit();
    	
    	 
 		
		/*if (!result.isSuccess()) {
			REPORT.log(LogStatus.FAIL, result.getThrowable());
		}*/
    	        
		//REPORTMANAGER.endTest(ExtentManager.getExtentTest());// ending test  
     }
     /*
=======
    
>>>>>>> Stashed changes
     @AfterClass
     public void afterClass() {  	 
     }
     
     @AfterSuite
     public void afterSuite() {    	   
 		REPORTMANAGER.close();// write any pending data and close the report 
     }
     
     protected String getStackTrace(Throwable t) {
         StringWriter sw = new StringWriter();
         PrintWriter pw = new PrintWriter(sw);
         t.printStackTrace(pw);
         return sw.toString();
     }*/
}