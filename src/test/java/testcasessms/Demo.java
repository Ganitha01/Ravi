package testcasessms;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.sms.genericutility.ExcelUtility;
import com.sms.genericutility.JavaScriptUtility;
import com.sms.genericutility.JavaUtility;
import com.sms.genericutility.PropertyUtility;
import com.sms.genericutility.WebDriverUtility;
import com.sms.objectrepo.AdminHomePage;
import com.sms.objectrepo.ClassRoomCreationPage;
import com.sms.objectrepo.CommonFeatures;
import com.sms.objectrepo.ExamCreationPage;
import com.sms.objectrepo.ExamTimetableCreationPage;
import com.sms.objectrepo.GradeCreationPage;
import com.sms.objectrepo.LoginPage;
import com.sms.objectrepo.PettyCashCreationPage;
import com.sms.objectrepo.StudentCreationpage;
import com.sms.objectrepo.SubjectCreationPage;
import com.sms.objectrepo.SubjectRoutingCreationPage;
import com.sms.objectrepo.TeacherCreationPage;
import com.sms.objectrepo.TimetableCreationPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {

	public static void main(String[] args) throws Throwable {
		WebDriverUtility wdu=new WebDriverUtility();
		PropertyUtility pu=new PropertyUtility();
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		AdminHomePage ahp=new AdminHomePage(driver); 
		CommonFeatures cf=new CommonFeatures(driver);
		ExcelUtility eutil=new ExcelUtility();
		ExcelUtility ex=new ExcelUtility();
		PropertyUtility putil=new PropertyUtility();
		JavaUtility jutil=new JavaUtility();
		WebDriverUtility wutil=new WebDriverUtility();
		WebDriverUtility wbu=new WebDriverUtility();
		int num=jutil.rannumber();
       String subjectname;
       String teachername;
		
		
	//login	
		wdu.getUrl(driver,"http://rmgtestingserver/domain/Student_Management_System/view/login.php");
	LoginPage l=new LoginPage(driver);
		wdu.elementClickablemethod(driver,l.getUntbx());
		 cf.loginToSms(pu, driver, wdu);
		 wdu.maximisetheBrowser(driver);
			
   

	//classroom	
		ahp.getClassroombtn().click();
		 ClassRoomCreationPage crp=new ClassRoomCreationPage(driver);
		 String classroom = crp.createClassRoom(driver,"1stclass");
		 wdu.customeWait(10, crp.getSearchbox(), 1000);
		 //wdu.elementClickablemethod(driver, crp.getSearchbox());
		 //Thread.sleep(3000);
		 cf.verifyMethod(driver, classroom);
		 
		 //grade
		ahp.getGradebtn().click();
		GradeCreationPage gcp=new GradeCreationPage(driver);
		String gradename = gcp.createGrade(driver,"Grade");
		//wdu.elementClickablemethod(driver,gcp.getSearchtbx());
		//Thread.sleep(4000);
		wdu.customeWait(10, gcp.getSearchtbx(), 1000);
		cf.verifyMethod(driver, gradename); 
		
		//subject
		 ahp.getSubjectbtn().click();
		 SubjectCreationPage sc=new SubjectCreationPage(driver);
		 subjectname = sc.createSubject(driver, "Mathematics");
		 wdu.customeWait(10, cf.getSearchbox(), 1000);
		 cf.verifyMethod(driver, subjectname);

		 
		 //teacher
		 ahp.teacherModule(driver,"add teacher");
		 TeacherCreationPage tcp=new TeacherCreationPage(driver);
		 //tcp.createTeacherMap(driver);
		
		 
		 String teacher = tcp.createTeacher(driver, "Ravichandra");
		 wdu.explicitlywaitmethod(driver,cf.getSubmitbtn());
		 ahp.teacherModule(driver,"All teacher");
	     wdu.customeWait(10, cf.getSearchbox(), 1000);
	     cf.verifyMethod(driver, teacher);
	
	     /*
		//subjectRouting 
		 ahp.getSubjectroutingbtn().click();
		 SubjectRoutingCreationPage subroutcp=new SubjectRoutingCreationPage(driver);
		 subroutcp.createSubjectRouting(driver, gradename, subjectname,teacher);
		 wdu.customeWait(10, cf.getSearchbox(), 1000);
		 cf.verifyMethod(driver, teacher);
		
		 //timetable
		 wdu.customeWait(10, ahp.getTimetablebtn(), 1000);
		 TimetableCreationPage tbcp=new TimetableCreationPage();
		 tbcp.createTimeTable(driver, "Grade241", "Friday", subjectname, teacher, classroom, "6", "8");
		 

		 //Student
		 StudentCreationpage scp=new StudentCreationpage(driver);
		String sname=scp.createStudent(driver, "Ravi", "Raju","Grade241");
		 scp.verifyStudent(driver,"Grade241",sname);
	
		 
		 //Exam
		 ExamCreationPage ecp=new ExamCreationPage(driver);
		 String exname = ecp.createExam(driver, "UnitRegression Test");
		 ahp.examModule(driver,"create Exam");
		 cf.verifyMethod(driver, exname);

		 //timetable
		 ExamTimetableCreationPage ettable=new ExamTimetableCreationPage();
		 ettable.createTimetable(driver,gradename, exname, "Friday",subjectname,classroom, "7", "9");
		 //pettycash
		 PettyCashCreationPage pcp=new PettyCashCreationPage(driver);
		 pcp.createPettyCash(driver, "Duster", "50");
		*/
		 Thread.sleep(3000);
		 wdu.explicitlywaitmethod(driver,ahp.getUserlogo());
		 cf.setSignOut(driver);
			}
		}