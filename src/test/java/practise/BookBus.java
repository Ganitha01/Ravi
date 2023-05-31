package practise;

import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BookBus {

	public static void main(String[] args) throws InterruptedException {
		 WebDriverManager.chromedriver().setup();
		 WebDriver driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
driver.get("https://www.makemytrip.com/flights/");
    driver.findElement(By.xpath("//span[text()='Buses']")).click();
//From city
    String fromcity="Tirupati";
    driver.findElement(By.id("fromCity")).click();
    driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(fromcity);
    WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='sr_city blackText']")));
     List<WebElement> fauto = driver.findElements(By.xpath("//span[contains(text(),'"+fromcity+"')]"));
     //to select the city
     for(int i=0;i<fauto.size();i++) {
    	 String data=fauto.get(i).getText();
    	 if(data.contains(fromcity)) {
    		  fauto.get(i).click();
    	 break;
    	 }
     }
  //tocity
String tocity="Bangalore";
    driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys(tocity);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='sr_city blackText']")));
      List<WebElement> tauto = driver.findElements(By.xpath("//span[contains(text(),'"+tocity+"')]"));
      //to select the city
      for(int i=0;i<tauto.size();i++) {
     	 String data=tauto.get(i).getText();
     	 if(data.contains(tocity)) {
     		  tauto.get(i).click();
     	 break;
     	 }
      }
   //travelling date
    Date date=new Date();
    String words[]=date.toString().split(" ");//we are directly calling toString methods.
    String  day=words[0],mon=words[1],dat=words[2],year=words[5];
    String stdate=day+" "+mon+" "+dat+" "+year;
    driver.findElement(By.xpath("//div[@aria-label='"+stdate+"']")).click();
    driver.findElement(By.xpath("//button[text()='Search']")).click();
    Thread.sleep(2000);
    //finding the buses names & prices
    List<WebElement> busname = driver.findElements(By.xpath("//span[@class='latoBlack font22 blackText appendRight15']"));
    List<WebElement> price = driver.findElements(By.xpath("//span[contains(@class,'latoBlack font22 blackText appe')]/ancestor::div[@class='makeFlex']/descendant::span[@id='price']"));
    TreeMap<Integer, String> busprice=new TreeMap<Integer, String>();      
    
    for(int i=0;i<busname.size();i++) {
        	  String busnam=busname.get(i).getText();
        	  String pric=price.get(i).getText().replaceAll("[^0-9]","");
        	 int pri=Integer.parseInt(pric);
        	 busprice.put(pri, busnam);
          }
       for(Integer i : busprice.keySet() ) {
    	   System.out.println(busprice.get(i)+"   "+i);
       }
    
       driver.close();
	}

}
