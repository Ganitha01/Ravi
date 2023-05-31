package practise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RmgServerDataCheck {

	public static void main(String[] args) throws InterruptedException, SQLException {
		//ChromeOptions opt=new ChromeOptions();
		//ChromeOptions settings = opt.addArguments("--disable-notifications");
         WebDriverManager.chromedriver().setup();
         WebDriver driver=new ChromeDriver();
         driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://rmgtestingserver:8084/");
     //login to the application   
          //driver.findElement(By.xpath("//label[@for='usernmae']")).click();
          driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
          //driver.findElement(By.xpath("//label[@for='inputPassword']")).click();
         driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
         driver.findElement(By.xpath("//button[text()='Sign in']")).click();
     //click on project
         driver.findElement(By.linkText("Projects")).click();
         driver.findElement(By.xpath("//span[text()='Create Project']")).click();
      //project details
         Random ran=new Random();
         int rannum=ran.nextInt(1000);
         String pname="RMG"+rannum;
         driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys(pname);
         driver.findElement(By.name("createdBy")).sendKeys("RaviChandra");
         WebElement status = driver.findElement(By.xpath("//label[text()='Project Status ']/../child::select[@name='status']"));
         Select s=new Select(status);
         Thread.sleep(2000);
         s.selectByValue("On Going");
         driver.findElement(By.xpath("//input[@class='btn btn-success']")).submit();
        
         //database Checking    
         Connection connection=null;
         try {
         //step 1: Driverclass
         Driver database=new Driver();
         //step2: register the driver
         DriverManager.registerDriver(database);
         //step3: connectin
         connection = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
         //step4 after connection create statement
         Statement statement = connection.createStatement();
         //create query
         String query="select * from project";
         //executeQuery or ExecuteUpdate query
         ResultSet results = statement.executeQuery(query);
           //check data is fetching or not
         while(results.next()) {
        	 String data=results.getString(1)+" "+results.getString(2)+"  "+results.getString(3)+" "+results.getString(4);
        	if(data.contains("Ravichandra")) {
        		System.out.println(data);
        	}
         }
         }
         //close the database connection.
         finally {
        	 connection.close();
		}

         
         //driver.close();    
	}

}
