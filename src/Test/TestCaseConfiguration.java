package Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import Pages.HomePageObjects;
import Tools.Constants;

import com.relevantcodes.extentreports.Chart;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class TestCaseConfiguration {

     protected ChromeDriver driver = null;
     protected HomePageObjects homePage = null;
     protected DesiredCapabilities  capabilities;
     
    
	 static final ExtentReports extent = ExtentReports.get(TestCaseConfiguration.class);
     
	 String FilePath = "C:/Users/ssafdar/git/MobileWebAutomation/Report/TestResults.html";


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
		 driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		 driver.get(Constants.DOMAIN);
		 homePage = PageFactory.initElements(driver, HomePageObjects.class);
     }
    
     @AfterMethod(alwaysRun = true)
     public void close() throws InterruptedException {         
        // driver.close();
        // driver.quit();
     }
     
     @BeforeClass
     public void beforeClass() {
   	  
   	  extent.init(FilePath, true);
   	  extent.config().reportHeadline("LLBEAN MobileWeb Smoke Test Results Summary");
   	  //HTMLReport report1 = new HTMLReport();
   	  //report1.InitializeReport();
   	  
   	  System.out.println("Before Class");

     }

     @AfterClass
     public void afterClass() {
   	  extent.config().chartTitle(Chart.TEST,"Test Steps");
   	  extent.config().chartTitle(Chart.TEST_SET,"Test Cases");

   	  System.out.println("After Class");
     
     }
     
     @BeforeSuite(groups = {"Initialize"})
     public void beforeSuite() {
   	  
   	  extent.init(FilePath, true);
   	  extent.config().reportHeadline("LLBEAN MobileWeb Smoke Test Results Summary");
   	  System.out.println("Before Suite");

     }
     
     @AfterSuite(groups = {"Destroy"})
     public void afterSuite() {
   	  extent.config().chartTitle(Chart.TEST,"Test Steps");
   	  extent.config().chartTitle(Chart.TEST_SET,"Test Cases");
   	  System.out.println("After Suite");
   	  try {
   		  
   		  
             String content = FileUtils.readFileToString(new File(FilePath), "UTF-8");
             content = content.replaceAll("<div id='footer'>", "");
             content = content.replaceAll("<div class='footer'>","");
             content = content.replaceAll("<div id='footer-section-1'>","");
             content = content.replaceAll("<h4>ExtentReports Library</h4>","");
             content = content.replaceAll("<li><a href='http://relevantcodes.com/extentreports-for-selenium/'>ProjectHome</a></span></li>","");
             content = content.replaceAll("<a href='http://relevantcodes.com/extentreports-for-selenium/'>Project Home</a>","");
             content = content.replaceAll("<li><a href='https://github.com/relevantcodes/extentreports/wiki'>Wiki</a></span></li>","");
             content = content.replaceAll("<li><a href='https://github.com/relevantcodes/extentreports/graphs/contributors'>Contributors</a></span></li>","");
             content = content.replaceAll("<li><a href='https://github.com/relevantcodes/extentreports/issues'>Issues</a></span></li>","");
             content = content.replaceAll("<li><a href='http://relevantcodes.com/extentreports-documentation/'>Documentation</a></span></li>","");
             content = content.replaceAll("extent-reports","Custom Report");
             File tempFile = new File(FilePath);
             FileUtils.writeStringToFile(tempFile, content, "UTF-8");
          } catch (IOException e) {
             //Simple exception handling, replace with what's necessary for
             throw new RuntimeException("Generating file failed", e);


          }
     
     }
}