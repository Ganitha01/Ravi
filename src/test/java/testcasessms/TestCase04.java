package testcasessms;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.sms.genericutility.BaseClass;
import com.sms.genericutility.ExcelUtility;
import com.sms.genericutility.JavaUtility;
import com.sms.genericutility.PropertyUtility;
import com.sms.genericutility.WebDriverUtility;
import com.sms.objectrepo.AdminHomePage;
import com.sms.objectrepo.ClassRoomCreationPage;
import com.sms.objectrepo.CommonFeatures;
import com.sms.objectrepo.GradeCreationPage;
import com.sms.objectrepo.StudentCreationpage;
import com.sms.objectrepo.SubjectCreationPage;
import com.sms.objectrepo.SubjectRoutingCreationPage;
import com.sms.objectrepo.TeacherCreationPage;

import io.github.bonigarcia.wdm.WebDriverManager;

//@Listeners(com.sms.genericutility.ListernersImplemention.class)
public class TestCase04 extends BaseClass{

				ExcelUtility eutil=new ExcelUtility();
				ExcelUtility ex=new ExcelUtility();
				PropertyUtility putil=new PropertyUtility();
				JavaUtility jutil=new JavaUtility();
				WebDriverUtility wutil=new WebDriverUtility();
				WebDriverUtility wbu=new WebDriverUtility();
				int num=jutil.rannumber();
               String subjectname;
               String teachername;
				
				CommonFeatures cf;
				
	@Test(groups = "Smoke testing",retryAnalyzer = com.sms.genericutility.RetryAnalyserImplementation.class)
     public void studentUpdationV() throws EncryptedDocumentException, IOException, InterruptedException, AWTException {
			
		cf=new CommonFeatures(driver);
				AdminHomePage ahp=new AdminHomePage(driver);
				String GRADE=eutil.readExceldata("Student", 1, 2);
				String PHONENO=eutil.readExceldata("Student", 1, 3);
				String STUDENTNAME=eutil.readExceldata("Student", 1, 4);

				//click on add teacher 
	           // AdminHomePage ahp=new AdminHomePage(driver);
				ahp.teacherModule(driver, "add teacher");	
	            TeacherCreationPage tcp=new TeacherCreationPage(driver);
	            teachername = tcp.createTeacher(driver, "Dhanalakshi");
				
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
						subjectname = scp.createSubject(driver, "Science");
						
						
						
						//subjectRoutingcreation
						wbu.explicitlywaitmethod(driver, ahp.getSubjectroutingbtn());
						ahp.getSubjectroutingbtn().click();
						SubjectRoutingCreationPage sbcp=new SubjectRoutingCreationPage(driver);
						sbcp.createSubjectRouting(driver, gradename, subjectname, teachername);
						
						
						//studentcreationpage
						wbu.explicitlywaitmethod(driver, ahp.getStudentbtn());
						StudentCreationpage stp=new StudentCreationpage(driver);
						String stuname = stp.createStudent(driver, "Ganesh", "Subhan", gradename);
						
						ahp.studentModule(driver,"All student");
						wbu.customeWait(10, cf.getGradedropbtn(), 1000);
						wbu.selectEleInDropDown(gradename, cf.getGradedropbtn());
						cf.getSubmitbtn().click();
						wbu.explicitlywaitmethod(driver, cf.getSearchbox());
						cf.getSearchbox().sendKeys(stuname);
		//goto particulastudent and click on edit button
		    cf.getEditbtn().click();
		    
		//edit phoneno  and address of the student
		WebElement parentphno=driver.findElement(By.xpath("//input[@id='g_phone']"));
		parentphno.click();
		
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_A);
		r.keyPress(KeyEvent.VK_BACK_SPACE);
		r.keyRelease(KeyEvent.VK_BACK_SPACE);
		Thread.sleep(1000);
		
		parentphno.sendKeys(PHONENO);
		Thread.sleep(1000);
		WebElement stuphno=driver.findElement(By.xpath("//input[@id='phone']"));
		stuphno.click();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_A);
		r.keyPress(KeyEvent.VK_BACK_SPACE);
		r.keyRelease(KeyEvent.VK_BACK_SPACE);
		Thread.sleep(1000);
		stuphno.sendKeys(PHONENO);
		Thread.sleep(1000);
		
		//click on update
		driver.findElement(By.xpath("//button[.='Update']")).click();
 wbu.waitTillEleInvisible(driver, cf.getSuccessmsg());                                                                                   
}
}
