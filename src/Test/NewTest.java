package Test;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import Pages.AccountPageObjects;
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
	
	//Fetch excelreader;
	//Dictionary dict1;
	
	AccountPageObjects AccPage;
	HomePageObjects HP;
	MenuPageObjects MP;
	ProductListPageObjects plp;
	//LoginPageObjects LoginObj;
    WebDriver driver;
    
    
    
    static DesiredCapabilities  capabilities;
	static String DeviceName;
   //WebDriver driver = new ChromeDriver(capabilities);
    
  
   
  
  
  
  @Test
  public void f() {
	  
	  //Fetch excelreader=new Fetch();
	//  Dictionary dict1=obj.readfromExcel();
	  MP = new MenuPageObjects();
	  HP = new HomePageObjects();
	  plp = new ProductListPageObjects();
	  AccPage = new AccountPageObjects();
	 // LoginObj= new LoginPageObjects();
	  
	  MP.NavigateToPlp(driver);
	  String verifiedtxt = plp.PLPVerification(driver);
	  //LoginObj.login(dict1.get("username"),dict1.get("password"));
	  
  }
  
  
  
	}
  
  
  
 
