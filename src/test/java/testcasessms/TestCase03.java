package testcasessms;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import com.sms.genericutility.BaseClass;
import com.sms.genericutility.ExcelUtility;
import com.sms.genericutility.JavaUtility;
import com.sms.genericutility.PropertyUtility;
import com.sms.genericutility.WebDriverUtility;
import com.sms.objectrepo.AdminHomePage;
import com.sms.objectrepo.ClassRoomCreationPage;
import com.sms.objectrepo.CommonFeatures;
import com.sms.objectrepo.ExamCreationPage;
import com.sms.objectrepo.ExamTimetableCreationPage;
import com.sms.objectrepo.GradeCreationPage;
import com.sms.objectrepo.SubjectCreationPage;
import com.sms.objectrepo.SubjectRoutingCreationPage;
import com.sms.objectrepo.TeacherCreationPage;
import com.sms.objectrepo.TeacherHomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase03 extends BaseClass{
	
		ExcelUtility eutil=new ExcelUtility();
		JavaUtility jutil=new JavaUtility();
		WebDriverUtility wutil=new WebDriverUtility();
		PropertyUtility putil=new PropertyUtility();
		WebDriverUtility wbu=new WebDriverUtility();
		
		
		int num=jutil.rannumber();
        String subjectname;
		String teachername;
        String classroomname;
		CommonFeatures cf;
		
		@Test(groups = "Regression Testing",retryAnalyzer = com.sms.genericutility.RetryAnalyserImplementation.class)
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
	           
	  //classroomcreation
	   		ahp.getClassroombtn().click();
	   		ClassRoomCreationPage crp=new ClassRoomCreationPage(driver);
	   		 classroomname = crp.createClassRoom(driver, "MentalRoom");
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
		
		//creationExam
		wbu.explicitlywaitmethod(driver, ahp.getExambtn());
		ahp.examModule(driver, "create Exam");
		ExamCreationPage ecp=new ExamCreationPage(driver);
		String examname = ecp.createExam(driver, "AnnualExam"+num);
		
		
		//timetable creation
		wbu.explicitlywaitmethod(driver, ahp.getExambtn());
		ahp.examModule(driver, "Exam Timetable");
		ExamTimetableCreationPage extp=new ExamTimetableCreationPage();
		extp.createTimetable(driver, gradename, examname, "Friday", subjectname, classroomname, "10", "12");
	
		
        eutil.writeExceldata("Login", 0, 0, "teacher");
	}		
		
		
		
	@Test(dependsOnMethods = "teacherCreationV",groups = "Regression Testing",retryAnalyzer = com.sms.genericutility.RetryAnalyserImplementation.class)
		public void VerifyTimetable() throws EncryptedDocumentException, IOException {
			cf=new CommonFeatures(driver);
			TeacherHomePage tcp=new TeacherHomePage(driver);
			//click on time tale
			tcp.timetableModule("my timetable");
			
		List<WebElement> data=driver.findElements(By.xpath("//table[@class='table table-bordered table-striped']/tbody/tr/td[2]"));
		for(WebElement e:data) {
			String tablevalue=e.getText();
			if(tablevalue.contains(subjectname)&&tablevalue.contains(teachername)&&tablevalue.contains(classroomname))
			{
				System.out.println("time table created");
			}
			else
			{
				System.out.println("time table no created");
			}
			
		}
		//signout the application
         eutil.writeExceldata("Login", 0, 0, "admin");
	}
	
  }
		
