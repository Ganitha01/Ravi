package practise;

import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BookFlight {
	
	public static void main(String[] args) throws InterruptedException {
		 WebDriverManager.chromedriver().setup();
		 WebDriver driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 driver.get("https://www.makemytrip.com/flights/");
  //roundtrip
 driver.findElement(By.xpath("//li[@data-cy='roundTrip']")).click();
 //fromcity
 driver.findElement(By.id("fromCity")).sendKeys("Tirupathi");
 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Tirupati, India')]"))).click();
  //tocity
 driver.findElement(By.id("toCity")).sendKeys("MUmbai");
 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Mumbai, India')]"))).click();
 //startdate from system
 Date date=new Date();
  String []words=date.toString().split(" ");
  String  day=words[0],mon=words[1],dat=words[2],year=words[5];
  String stdate=day+" "+mon+" "+dat+" "+year;
  driver.findElement(By.xpath("//div[@aria-label='"+stdate+"']")).click();//dynamic Xpath
  //returndate
  int rdat=Integer.parseInt(dat)+7;
 if(rdat>23)
	  rdat=5;
          int ryear=2023;
         String returndate =rdat+" "+ryear;
         driver.findElement(By.xpath("//div[contains(@aria-label,'"+returndate+"')]")).click();
    //passengers list
         Thread.sleep(1000);
         driver.findElement(By.xpath("//span[@data-cy='travellerText']")).click();
         driver.findElement(By.xpath("//li[@data-cy='adults-5']")).click();
         driver.findElement(By.xpath("//button[@data-cy='travellerApplyBtn']")).click();
         driver.findElement(By.xpath("//a[text()='Search']")).click();
         Thread.sleep(2000);
         
         driver.close();
	}

}
