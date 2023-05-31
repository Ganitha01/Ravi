package practise;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ICC {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
	      System.out.println("enter the team name to find the details");
	     String name=sc.next();
		 WebDriverManager.chromedriver().setup();
		 WebDriver driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
      List<WebElement> teams = driver.findElements(By.xpath("//span[@class='u-hide-phablet']/../.."));
      boolean flag= false;
      for(int i=0;i<teams.size();i++) {
    	   String data=teams.get(i).getText();
    	   if(data.contains(name)) {
    		   System.out.println("present");
    		   System.out.println(teams.get(i).getText());
    		   flag=true;
    		    break;
    		        }
       }
       if(!flag)
    	   System.out.println("County not present");
       
       driver.close();
	}

}
