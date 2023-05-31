package practise;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OlympicMedals {

	public static void main(String[] args) throws InterruptedException {
		//ChromeOptions opt=new ChromeOptions();
		//opt.addArguments("--disable-notifications");
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the country name which u want");
		String rcountry=sc.nextLine();
    WebDriverManager.chromedriver().setup();
    WebDriver driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://olympics.com/en/olympic-games/tokyo-2020/medals");
WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'No, manage settings')]")));
    driver.findElement(By.xpath("//button[contains(text(),'No, manage settings')]")).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Reject All')]"))).click();
    List<WebElement> allcountrys = driver.findElements(By.xpath("//span[@data-cy='country-name']"));
    List<WebElement> allmedals = driver.findElements(By.xpath("//div[contains(@data-medal-id,'medals-row')]"));
    
    for(int i=0;i<allcountrys.size();i++) {
    	String country=allcountrys.get(i).getText();
    	int l=(i+1)*4;int k=l-4;
    	    if(country.equalsIgnoreCase(rcountry)){
    	    	System.out.println(country);
    	    	//System.out.println(i);
    	    	for(int j=k;j<l;j++) {
    	    		
    	     	   System.out.print(allmedals.get(j).getText()+"\t");
    	     	  // System.out.println();
    	     	  //System.out.print(j+"  ");
    	    	}
    	    }
       }
    
    
    driver.close();
	}

}
