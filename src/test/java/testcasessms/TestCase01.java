package testcasessms;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.sms.genericutility.BaseClass;
import com.sms.genericutility.ExcelUtility;
import com.sms.genericutility.JavaUtility;
import com.sms.genericutility.PropertyUtility;
import com.sms.genericutility.WebDriverUtility;
import com.sms.objectrepo.AdminHomePage;
import com.sms.objectrepo.CommonFeatures;
import com.sms.objectrepo.PettyCashCreationPage;
import com.sms.objectrepo.TeacherCreationPage;
import com.sms.objectrepo.TeacherHomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
public class TestCase01 extends BaseClass{
	
	ExcelUtility eutil=new ExcelUtility();
	PropertyUtility putil=new PropertyUtility();
	JavaUtility jutil=new JavaUtility();
	WebDriverUtility wutil=new WebDriverUtility();
	WebDriverUtility wbu=new WebDriverUtility();
	int num=jutil.rannumber();
	String teachername="";
	String PettyCashDes="";
	CommonFeatures cf;
	
	@Test(retryAnalyzer = com.sms.genericutility.RetryAnalyserImplementation.class)
    public void teacherCreationV() throws EncryptedDocumentException, IOException, InterruptedException {
		 cf=new CommonFeatures(driver);
						
				//click on add teacher 
            AdminHomePage ahp=new AdminHomePage(driver);
			ahp.teacherModule(driver, "add teacher");	
            TeacherCreationPage tcp=new TeacherCreationPage(driver);
            teachername = tcp.createTeacher(driver, "Dhanalakshi");
			
             //click on all teacher links
			ahp.teacherModule(driver, "all teacher");

			//enter teacher name in search bar

           cf.verifyMethod(driver, teachername);
           
				//logout                                                                                    
        eutil.writeExceldata("Login", 0, 0, "teacher");
	}
	
	
	@Test(groups = "Regression Testing",retryAnalyzer = com.sms.genericutility.RetryAnalyserImplementation.class)
	public void creatingPettyCash() throws EncryptedDocumentException, IOException {
		cf=new CommonFeatures(driver);
         PettyCashCreationPage pccp=new PettyCashCreationPage(driver);
         pccp.createPettyCash(driver, "Marker", "99.9");
         
				//click on serch bar enter date
         
				String CURRENTDATE=jutil.systemdate("y/m/dat").replace(" ","-");
				WebElement element2=driver.findElement(By.xpath("//input[@class='form-control input-sm']"));
				wutil.customeWait(10, element2, 1000);
				element2.sendKeys(CURRENTDATE);
				
				//select show drop down with 100
				WebElement show=driver.findElement(By.xpath("//select[@name='example1_length']"));
				wutil.selectEleInDropDown(show, "100");
				//save all the Webelements of view button and compare with description
				List<WebElement> element1=driver.findElements(By.xpath("//a[@class='btn btn-info btn-xs']"));
				for(int i=element1.size()-1;i>=0;i--)
				{	//click on view button
					element1.get(i).click();
					//fectch description from petty cash
					String Description=driver.findElement(By.xpath("(//table[@class='table table-bordered']/descendant::td)[5]")).getText();
					
					//Assert.assertTrue(Description.equalsIgnoreCase(PettyCashDes)==true, "pettycash request created successfully");
					if(Description.equalsIgnoreCase(PettyCashDes))
					{
						System.out.println("pettycash request created successfully");
						//close the description pop up
						driver.findElement(By.xpath("(//div[@class='msk-heading']//button[@class='close'])[2]")).click();
						break;
					}
				}
			eutil.writeExceldata("Login", 0, 0, "admin");	
	}
	
	
	@Test(groups = "Regression Testing")
	public void pettycashApproval() throws EncryptedDocumentException, IOException, InterruptedException {
		cf=new CommonFeatures(driver);
		
				//click on pettycash
				driver.findElement(By.xpath("//a[@href='petty_cash.php']")).click();
				//search with teacher name
				driver.findElement(By.xpath("//input[@type='search']")).sendKeys(teachername);
				//change show dropdown to 100 value

				//fetch the view details of all the pettycash requests
				List<WebElement> pettycashdetails=driver.findElements(By.xpath("//a[@class='btn btn-info btn-xs']"));
				for(int i=pettycashdetails.size()-1;i>=0;i--)
				{
					//click on one pettycash
					pettycashdetails.get(i).click();
					//fetch the description of petty cash
					
					WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
					wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//table[@class='table table-bordered']/tbody/tr[1]/td[2])[2]")));
					String pettecahdescription=driver.findElement(By.xpath("(//table[@class='table table-bordered']/tbody/tr[1]/td[2])[2]")).getText();
					//close the description pop up
					wbu.explicitlywaitmethod(driver, driver.findElement(By.xpath("(//div[@class='msk-heading']//button[@class='close'])[2]")));
					driver.findElement(By.xpath("(//div[@class='msk-heading']//button[@class='close'])[2]")).click();
					//compare the fetched description and given description
					if(pettecahdescription.equalsIgnoreCase(PettyCashDes))
					{
						//if both are same click on approve
						driver.findElement(By.xpath("//a[.='Approve']")).click();
						Thread.sleep(1000);
						
						driver.findElement(By.xpath("//a[@id='btnYesApprove']")).click();
						System.out.println("pettycash approved successfully");
						break;
					}
				} 
			}
         }

