package practise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.mysql.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RmgDatabaseSendingData {
	
	
	public static void main(String[] args) throws SQLException {
		Connection connection=null;
		String pname=null;
		try {
		//Connection  to database
		//step1: Architecure of jdbc says that jdbc connected to drivers & driver connected to ....API's & drivers class is the imp class for apis
		//create driver obj in myl package 
		Driver database=new Driver();
		//step 2:register the Driver in DriverManager class we need to call the registerDriver method we need to pass the Driver obj.
		DriverManager.registerDriver(database);
		//step 3: connection ,connect that registerded driver in Drivermanager class by calling the GetConnection method.we havee to pass the path & pass & username
		connection=DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");//her projects is the database name
		//step4:create Statement in sql every thing is inter link with statements so we have to create a statement.
		 Statement statement = connection.createStatement();
		 //step5 : Write Query to Execute
		 Random ran=new Random();
		 int rannum=ran.nextInt(1000);
		  pname="Project_"+rannum;
		  String pid="TY_PROJ_"+rannum;
		 String query="insert into project values('"+pid+"','Ravichandra','11/05/2023','"+pname+"','On Going',5)";
		 //step6: Execute the query
		 int result = statement.executeUpdate(query);
		    if(result==1)
		    	System.out.println("One row created");
		    else
		    	System.out.println("Not created");
    }
    finally{
	    //step 7:close the database
    	connection.close();
    }		    
		    //Goto Application
      //ChromeOptions option=new ChromeOptions();
      //option.addArguments("--remote-allow-Origins=*");
      WebDriverManager.chromedriver().setup();
      WebDriver driver=new ChromeDriver();
	         driver.manage().window().maximize();
	         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	          driver.get("http://rmgtestingserver:8084/");
	          //login to app
	          driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
	          driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
	          driver.findElement(By.xpath("//button[text()='Sign in']")).click();
	          //click on project
	          driver.findElement(By.linkText("Projects")).click();
	         String projname=driver.findElement(By.xpath("//th[text()='Project Manager']/ancestor::table[@class='table table-striped table-hover']/descendant::td[text()='"+pname+"']")).getText();
	          if(projname.contains(pname))
	        	  System.out.println("Data is Stored Sucessfully");
	          else
	        	  System.out.println("data not stored");
	          
		 
		
	}

}
