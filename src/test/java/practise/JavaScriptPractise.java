package practise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.sms.genericutility.JavaScriptUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptPractise {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
      WebDriver driver=new ChromeDriver();
      //driver.get("http://rmgtestingserver/domain/Student_Management_System/view/login.php");
      //lunchApplication
      JavaScriptUtility jss=new JavaScriptUtility(driver);
      jss.lunchApplication("http://rmgtestingserver/domain/Student_Management_System/view/login.php");
      //get url of current page
      String url=jss.getUrlOfCurrentPage();
      System.out.println(url);
      
      //get title of the current page
      String title=jss.getTitleOfCurrentPage();
      System.out.println(title);
      //getText of the Ele
      WebElement ele = driver.findElement(By.xpath("//label[text()='Password']"));
      String text = jss.getTheText(ele);
      System.out.println(text);
      
      //click on element
      WebElement username = driver.findElement(By.id("email"));
      jss.senddkeys(username, "admin@gmail.com");
      WebElement password=driver.findElement(By.id("password"));
      jss.senddkeys(password, "12345");
      WebElement sub= driver.findElement(By.id("btnSubmit"));
      jss.click(sub);
      
      //scrolldown
      jss.scrollDown();
      //scrollup
      Thread.sleep(2000);
      jss.scrollUP();
      WebElement frdstab = driver.findElement(By.xpath("//span[text()='Friends']"));
      int frdtab = driver.findElement(By.xpath("//span[text()='Friends']")).getLocation().getY();
      Thread.sleep(2000);
       jss.scrollTillElement(frdstab);
       
      
	}

}
