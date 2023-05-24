package practise;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSugg {

	public static void main(String[] args) {
		 WebDriverManager.chromedriver().setup();
		 WebDriver driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.get("https://www.google.com/");
		 driver.switchTo().activeElement().sendKeys("java");
		 List<WebElement> autosugg = driver.findElements(By.xpath("//span[contains(text(),'java')]"));
		  for(int i=0;i<autosugg.size();i++) {
			  String data=autosugg.get(i).getText();
			  if(data.contains("javatpoint")) {
				  autosugg.get(i).click();
				  break;
			  }
		  }
	}

}
