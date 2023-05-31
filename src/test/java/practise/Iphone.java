package practise;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Iphone {

	public static void main(String[] args) {
 WebDriverManager.chromedriver().setup();
 WebDriver driver=new ChromeDriver();
 driver.manage().window().maximize();
 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
 driver.get("https://www.amazon.in/");
 driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone 14 pro max"+Keys.ENTER);
      List<WebElement> phonenames = driver.findElements(By.xpath("//span[@class='a-price-whole']/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']/descendant::span[contains(text(),'Apple iPhone 14 Pro Max')]"));
      List<WebElement> price = driver.findElements(By.xpath("//span[contains(text(),'Apple iPhone 14 Pro Max ')]/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']/descendant::span[@class='a-price-whole']"));
    
      for(int i=0;i<phonenames.size();i++) {
    	System.out.println(phonenames.get(i).getText()+"    "+price.get(i).getText());
    }
    
	}

}
