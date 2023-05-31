package practise;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sms.genericutility.JavaScriptUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SpicejectEX {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions opt=new ChromeOptions();
		ChromeOptions opti = opt.addArguments("--disable-notifications");
   WebDriverManager.chromedriver().setup();
    WebDriver driver=new ChromeDriver(opti);
    driver.get("https://www.spicejet.com/");
    /*ChromeOptions option=new ChromeOptions();
    option.addArguments("--allow-remote-Origins=*");*/
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='From']")));
    driver.findElement(By.xpath("//div[text()='round trip']")).click();
     driver.findElement(By.xpath("//div[text()='From']")).click();
     String from="mum";String to="delhi";
     driver.findElement(By.xpath("//div[text()='From']/following-sibling::div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep']/child::input[@autocapitalize='sentences']")).sendKeys(from,to);
   
     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='css-1dbjc4n r-knv0ih r-1k1q3bj r-ql8eny r-1dqxon3']/div[@tabindex='0']")));
     List<WebElement> autosugg = driver.findElements(By.xpath("//div[@class='css-1dbjc4n r-knv0ih r-1k1q3bj r-ql8eny r-1dqxon3']/div[@tabindex='0']/descendant::div[@class='css-76zvg2 r-cqee49 r-ubezar r-1kfrs79']"));
           for(int i=0;i<autosugg.size();i++) {
        	   String data=autosugg.get(i).getText();
        	   if(data.equalsIgnoreCase(to)) {
        		   autosugg.get(i).click();
        		   break;
        	   }
           }
     
     //driver.findElement(By.xpath("//div[text()='GOX']")).click();
     String startmon="June"; String year="2023";String endmon="July";String startdat="11";String enddat="30";
     driver.findElement(By.xpath("//div[text()='"+startmon+" ' and text()='"+year+"']/../../descendant::div[text()='"+startdat+"']")).click();
    // Thread.sleep(1000);
     driver.findElement(By.xpath("//div[text()='"+endmon+" ' and text()='"+year+"']/../../descendant::div[text()='"+enddat+"']")).click();
     driver.findElement(By.xpath("//div[contains(text(),'Adult')]")).click();
     driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1kz6sp']/following-sibling::div/*[name()='svg'][1]")).click();
     driver.findElement(By.xpath("//div[contains(text(),'Adult')]")).click();
     driver.findElement(By.xpath("//div[contains(text(),'Adult')]")).click();
     //driver.findElement(By.xpath("//div[text()='Students']")).click();
     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-testid='home-page-flight-cta']/div[contains(text(),'Search Flight')]")));
     Actions ma=new Actions(driver);
     ma.moveToElement(driver.findElement(By.xpath("//div[@data-testid='home-page-flight-cta']/div[contains(text(),'Search Flight')]"))).click().perform();
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='css-1dbjc4n r-14lw9ot r-3aj1re r-18u37iz']")));
	List<WebElement> data = driver.findElements(By.xpath("//div[@class='css-1dbjc4n r-14lw9ot r-3aj1re r-18u37iz']"));
	TreeSet<WebElement>sortdata=new TreeSet<WebElement>(data);
	    Iterator<WebElement>cursor=sortdata.iterator();
	           while(cursor.hasNext()) {
	        	   String text=cursor.next().getText();
	           }
	           
	}

}
