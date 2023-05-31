package com.sms.genericutility;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import com.sms.objectrepo.AdminHomePage;
import com.sms.objectrepo.LoginPage;
import com.sms.objectrepo.ParentHomePage;
import com.sms.objectrepo.TeacherHomePage;
import io.github.bonigarcia.wdm.WebDriverManager;



public class BaseClass {

	PropertyUtility pu = new PropertyUtility();
	ExcelUtility ex = new ExcelUtility();
	WebDriverUtility wbu = new WebDriverUtility();
	public WebDriver driver;
	public static WebDriver sdriver;
	
	@BeforeSuite(groups = {"Smoke testing","Regression Testing"})
	public void opendataBase() {
		
		Reporter.log("open DataBase Connection",true);
	}
    @BeforeClass(groups = {"Smoke testing","Regression Testing"})
	public void openBrowser() throws IOException {
		
		
		String browser = pu.getDataFromPropertyFile("browser");
		if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			 driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("chrome")) {
          WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
		}
		else {
			WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
		}
		sdriver=driver;
		Reporter.log("open Browser",true);
	}
	
	@BeforeMethod(groups = {"Smoke testing","Regression Testing"})
	public void loginToApp() throws IOException {
		wbu.maximisetheBrowser(driver);
		driver.get(pu.getDataFromPropertyFile("url"));

		LoginPage l=new LoginPage(driver);	
		 wbu.explicitlywaitmethod(driver, l.getPstbx());
		 
    String whatlogin = ex.readExceldata("Login", 0, 0);
      if(whatlogin.equalsIgnoreCase("admin")) {
    	   l.loginToSms(pu.getDataFromPropertyFile("adminusername"), pu.getDataFromPropertyFile("password"));
      }
      else if(whatlogin.equalsIgnoreCase("teacher")) {
    	  l.loginToSms(ex.readExceldata("Teacher", 1, 5), ex.readExceldata("teacher", 1, 6));
      }
      else {
    	  l.loginToSms(ex.readExceldata("login", 0, 2), pu.getDataFromPropertyFile("password"));
      }
		
		Reporter.log("Login to the Application",true);
	}
	
	@AfterMethod(groups = {"Smoke testing","Regression Testing"})
	public void logoutToApp() throws EncryptedDocumentException, IOException {
		
	    String whatlogout = ex.readExceldata("Login", 0, 0);
		if(whatlogout.equalsIgnoreCase("admin")) {
			AdminHomePage amp=new AdminHomePage(driver);
			wbu.customeWait(10, amp.getUserlogo(), 1000);
			//amp.getUserlogo().click();
			amp.getSignout().click();
		}
		else if(whatlogout.equalsIgnoreCase("teacher")) {
			TeacherHomePage thp=new TeacherHomePage(driver);
			wbu.customeWait(10, thp.getUserlogo(), 1000);
			thp.getSignout().click();
		}
		else {
			ParentHomePage php=new ParentHomePage(driver);
			wbu.customeWait(10, php.getUserlogo(), 1000);
			php.getSubjectbtn().click();
		}
			
		Reporter.log("Logout to the Application",true);
	}
	
		@AfterClass(groups = {"Smoke testing","Regression Testing"})
	public void closeBrowser() {
		driver.close();
		Reporter.log("close Browser",true);
	}
		@AfterSuite(groups = {"Smoke testing","Regression Testing"})
		public void closeDatabase() {
			Reporter.log("close database",true);
		}
	
}
