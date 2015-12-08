
package Tools;

import Test.TestCaseConfiguration;

import com.relevantcodes.extentreports.ExtentReports;

public class Constants {
	
	public static final String DOMAIN = "http://m-ecwebs01.llbean.com"; //this needs to be dynamic using the ends user interface
	public static final String DEVICE = "Apple iPhone 6";
	public static final String PDPURL = DOMAIN+"/product.html?#";
	public static final String FULLPRICEPDP = "61708";
	public static final String SALEPRICEPDP = "80051";
	static final ExtentReports extent = ExtentReports.get(TestCaseConfiguration.class);
	String FilePath = "C:/Users/ssafdar/git/MobileWebAutomation/Report/TestResults.html";

}
