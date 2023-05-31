package testcasessms;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.sms.genericutility.BaseClass;
import com.sms.genericutility.ExcelUtility;
import com.sms.genericutility.JavaUtility;
import com.sms.genericutility.ListernersImplemention;
import com.sms.genericutility.PropertyUtility;
import com.sms.genericutility.WebDriverUtility;
import com.sms.objectrepo.AdminHomePage;
import com.sms.objectrepo.ClassRoomCreationPage;
import com.sms.objectrepo.CommonFeatures;
import com.sms.objectrepo.GradeCreationPage;
import com.sms.objectrepo.SubjectCreationPage;
import com.sms.objectrepo.SubjectRoutingCreationPage;
import com.sms.objectrepo.TeacherCreationPage;

import io.github.bonigarcia.wdm.WebDriverManager;

//@Listeners(com.sms.genericutility.ListernersImplemention.class)
public class TestCase06 extends BaseClass{

	
	ExcelUtility eutil=new ExcelUtility();
	PropertyUtility putil=new PropertyUtility();
	JavaUtility jutil=new JavaUtility();
	WebDriverUtility wutil=new WebDriverUtility();
	WebDriverUtility wbu=new WebDriverUtility();
	int num=jutil.rannumber();
	String teachername="";
	CommonFeatures cf;
	
	@Test(groups = "Smoke testing",retryAnalyzer = com.sms.genericutility.RetryAnalyserImplementation.class)
    public void subjectRoutingV() throws EncryptedDocumentException, IOException, InterruptedException {
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
 
   		//classroomcreation
   		ahp.getClassroombtn().click();
   		ClassRoomCreationPage crp=new ClassRoomCreationPage(driver);
   		String classroomname = crp.createClassRoom(driver, "MentalRoom");
   		wbu.explicitlywaitmethod(driver, ahp.getGradebtn());
           
           
   		//gradecreation
   		ahp.getGradebtn().click();
   		GradeCreationPage gcp=new GradeCreationPage(driver);
   		String gradename = gcp.createGrade(driver, classroomname);
   		
		//subjectcreation
		wbu.explicitlywaitmethod(driver, ahp.getSubjectbtn());
		ahp.getSubjectbtn().click();
		SubjectCreationPage scp=new SubjectCreationPage(driver);
		String subjectname = scp.createSubject(driver, "Science");
		
		//subjectRoutingcreation
		wbu.explicitlywaitmethod(driver, ahp.getSubjectroutingbtn());
		ahp.getSubjectroutingbtn().click();
		SubjectRoutingCreationPage sbcp=new SubjectRoutingCreationPage(driver);
		sbcp.createSubjectRouting(driver, gradename, subjectname, teachername);

		
		//verify whether the shubjectrouting added or not
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(teachername);
		List<WebElement> subjectroutings=driver.findElements(By.xpath("//td[@class='sorting_1']"));
		for(int i=0;i<subjectroutings.size();i++)
		{int k=1;
			String localgrade=driver.findElement(By.xpath("//td[@class='sorting_1']/following-sibling::td["+k+"]")).getText();
			k++;
			String localsubject=driver.findElement(By.xpath("//td[@class='sorting_1']/following-sibling::td["+k+"]")).getText();
			k++;
			String localteacher=driver.findElement(By.xpath("//td[@class='sorting_1']/following-sibling::td["+k+"]")).getText();
			if(localgrade.equalsIgnoreCase(gradename)&&localsubject.equalsIgnoreCase(subjectname)&&localteacher.equals(teachername))
			{
				System.out.println("subject routing added successfully");
			}
		 }
	 }

}
