package testcasessms;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganisation {
	public static WebDriver driver;
static {
	System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
}
	public static void main(String[] args)throws FileNotFoundException,IOException {
//WebDriver driver=new ChromeDriver();
com.sms.genericutility.PropertyUtility pu=new com.sms.genericutility.PropertyUtility();
String browser = pu.getDataFromPropertyFile("browser");

if(browser.equalsIgnoreCase("chrome")) {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
}
else if(browser.equalsIgnoreCase("edge")) {
	WebDriverManager.edgedriver().setup();
	driver=new EdgeDriver();
}
else {
	driver=new ChromeDriver();
                 }

driver.get(pu.getDataFromPropertyFile("url"));
driver.switchTo().activeElement().sendKeys(pu.getDataFromPropertyFile("username"));
driver.findElement(By.name("user_password")).sendKeys(pu.getDataFromPropertyFile("password"));
driver.findElement(By.id("submitButton")).submit();

com.sms.genericutility.WebDriverUtility wb=new com.sms.genericutility.WebDriverUtility();
wb.implicitlywaitmethod(driver);

driver.findElement(By.partialLinkText("Organizations")).click();
driver.findElement(By.xpath("//img[contains(@alt,'Create Organization...')]")).click();

com.sms.genericutility.ExcelUtility ex=new com.sms.genericutility.ExcelUtility();
com.sms.genericutility.JavaUtility jlib=new com.sms.genericutility.JavaUtility();
int ran=jlib.rannumber();
String oname=ex.readExceldata("Organisation", 1, 0)+ran;
driver.findElement(By.name("accountname")).sendKeys(oname);
driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

String etext = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
String atext=oname;
    if(etext.contains(atext))
System.out.println("pass");
    else
    	 System.out.println("fail");
    driver.close();
	}

}
