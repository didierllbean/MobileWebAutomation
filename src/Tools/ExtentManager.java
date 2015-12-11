package Tools;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.NetworkMode;

public class ExtentManager {
	private static ExtentReports extentReport;
	private static ExtentTest extentTest;
    
    public synchronized static ExtentReports getReporter(String filePath) {
        if (extentReport == null) {
        	extentReport = new ExtentReports(filePath, true, NetworkMode.ONLINE);
            
        	extentReport
              .addSystemInfo("Selenium Version", "2.48.2")
              .addSystemInfo("Environment", "Stage")
              .addSystemInfo("Domain URL", Constants.DOMAIN);
        }
        
        return extentReport;
    }
    
    public synchronized static ExtentTest setExtentTest(ExtentReports report, String testName) {
        if (extentTest == null) {
        	extentTest = report.startTest(testName);
        }
        	
        return extentTest;
    }
        
    public synchronized static ExtentTest getExtentTest() {
       return extentTest;
    }
}
