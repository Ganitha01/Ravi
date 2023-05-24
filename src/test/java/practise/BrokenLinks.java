package practise;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {

	public static void main(String[] args) throws IOException {
		ChromeOptions opt=new ChromeOptions();
 WebDriverManager.chromedriver().setup();
 WebDriver driver=new ChromeDriver(opt.addArguments("--disable-notifications"));
driver.get("https://www.selenium.dev/downloads/");
driver.manage().window().maximize();
//driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
    List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
    List<String> brokenlinks=new ArrayList<String>();
   
   for(int i=0;i<allLinks.size();i++) {
	        String links=allLinks.get(i).getAttribute("href");
	        int statuscode=0;
	        try {
	     URL url=new URL(links);//her we are upcasting that href into url class in .net 
	     URLConnection urlconnect=url.openConnection();//for that url we are creating the connection by using url.openconncetion method.
	     HttpURLConnection httpurlconn=(HttpURLConnection)urlconnect;//after making the connection we are send that to httpurlconnn in that
	     //we get the responsecode method.
	     statuscode=httpurlconn.getResponseCode();//in httpurlconnection class we get that responsecode method so we have to type her
	      if(statuscode>400) {
	           brokenlinks.add(links+"    "+statuscode);
	      }         
   }
  catch (Exception e) {
      brokenlinks.add(links+"    "+statuscode); 
      continue;
  }
	}
   System.out.println(brokenlinks);
	}
}
