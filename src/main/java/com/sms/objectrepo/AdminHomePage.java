package com.sms.objectrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sms.genericutility.WebDriverUtility;

public class AdminHomePage {
	
	
	WebDriverUtility wbu=new WebDriverUtility();
	
	
//declaration
	@FindBy(xpath = "//li[@class='dropdown user user-menu']/child::a[@data-toggle='dropdown']/child::img[@alt='User Image']")
	private WebElement userlogo;
	@FindBy(xpath="//a[text()='Sign out']") private WebElement signout;
	@FindBy(xpath = "//span[text()='Classroom']") private WebElement classroombtn;
	@FindBy(xpath = "//span[text()='Grade']") private WebElement gradebtn;
	@FindBy(xpath = "//span[text()='Subject']") private WebElement subjectbtn;
	//remmber if we want to click any thing inside the teacher module 1st we have to click the teacher buttoon.
	@FindBy(xpath = "//span[text()='Teacher']") private WebElement teacherbtn;
	    @FindBy(xpath = "//a[contains(text(),'Add Teacher')]") private WebElement addteacherbtn;
	    @FindBy(xpath = "//a[contains(text(),'All Teacher')]") private WebElement allteacherbtn;
	@FindBy(xpath = "//span[text()='Subject Routing']") private WebElement subjectroutingbtn;
	@FindBy(xpath = "//span[text()='Timetable']") private WebElement timetablebtn;
	//remmber if we want to click any thing inside the student module 1st we have to click the student buttoon.
	@FindBy(xpath = "//span[text()='Student']") private WebElement studentbtn;
	     @FindBy(xpath = "//a[contains(text(),'Add Student')]") private WebElement addstudentbtn;
	     @FindBy(xpath = "//a[contains(text(),'All Student')]") private WebElement allstudentbtn;
	     @FindBy(xpath = "//a[contains(text(),'Leave Student')]") private WebElement leavestudentbtn;
	@FindBy(xpath = "//span[text()='Exam']") private WebElement exambtn;
             @FindBy(xpath = "//a[contains(text(),'Create Exam')]") private WebElement createexambtn;
             @FindBy(xpath = "//a[contains(text(),'Exam Timetable')]") private WebElement examtimetablebtn;
             @FindBy(linkText = "Student Exam Marks") private WebElement exammarksbtn;
             @FindBy(xpath = "//a[contains(text(),'Student Exam Marks History')]") private WebElement markshistorybtn;
	@FindBy(xpath = "//span[text()='Petty Cash']") private WebElement pettycashbtn;
	@FindBy(xpath = "//span[text()='Attendance']") private WebElement attendancebtn;
	@FindBy(xpath = "//span[text()='Student Payment']") private WebElement studentpaymentbtn;
//initalization
	public AdminHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
//utilization
	public WebElement getUserlogo() {
		return userlogo;
	}
	public WebElement getSignout() {
		return signout;
	}
	public WebElement getClassroombtn() {
		return classroombtn;
	}
	public WebElement getGradebtn() {
		return gradebtn;
	}
	public WebElement getSubjectbtn() {
		return subjectbtn;
	}
	public WebElement getTeacherbtn() {
		return teacherbtn;
	}
	public WebElement getAddteacherbtn() {
		return addteacherbtn;
	}
	public WebElement getAllteacherbtn() {
		return allteacherbtn;
	}
	public WebElement getSubjectroutingbtn() {
		return subjectroutingbtn;
	}
	public WebElement getTimetablebtn() {
		return timetablebtn;
	}
	public WebElement getStudentbtn() {
		return studentbtn;
	}
	public WebElement getAddstudentbtn() {
		return addstudentbtn;
	}
	public WebElement getAllstudentbtn() {
		return allstudentbtn;
	}
	public WebElement getLeavestudentbtn() {
		return leavestudentbtn;
	}
	public WebElement getExambtn() {
		return exambtn;
	}
	public WebElement getCreateexambtn() {
		return createexambtn;
	}
	public WebElement getExamtimetablebtn() {
		return examtimetablebtn;
	}
	public WebElement getExammarksbtn() {
		return exammarksbtn;
	}
	public WebElement getMarkshistorybtn() {
		return markshistorybtn;
	}
	public WebElement getPettycashbtn() {
		return pettycashbtn;
	}
	public WebElement getAttendancebtn() {
		return attendancebtn;
	}
	public WebElement getStudentpaymentbtn() {
		return studentpaymentbtn;
	}
	public void studentModule(WebDriver driver,String whichbtn) {
		studentbtn.click();
		if(whichbtn.equalsIgnoreCase("add student")) {
			wbu.elementClickablemethod(driver, addstudentbtn);
			addstudentbtn.click();  
			 }
		else if(whichbtn.equalsIgnoreCase("all student")) {
			wbu.elementClickablemethod(driver, allstudentbtn);
			allstudentbtn.click();
		}
		else if(whichbtn.equalsIgnoreCase("leave student")) {
			wbu.elementClickablemethod(driver, leavestudentbtn);
			leavestudentbtn.click();
		}
	}
	public void examModule(WebDriver driver,String whichbtn) {
		exambtn.click();
		if(whichbtn.equalsIgnoreCase("create exam")) {
			wbu.elementClickablemethod(driver, createexambtn);
			createexambtn.click();}
		else if(whichbtn.equalsIgnoreCase("exam timetable")) {
			wbu.elementClickablemethod(driver, examtimetablebtn);
			examtimetablebtn.click();}
		else if(whichbtn.equalsIgnoreCase("student exam marks")) {
			wbu.elementClickablemethod(driver, exammarksbtn);
			exammarksbtn.click();}
		else if(whichbtn.equalsIgnoreCase("student exam marks history"))
			markshistorybtn.click();
	}
	public void teacherModule(WebDriver driver,String whichbtn) {
		teacherbtn.click();
		if(whichbtn.equalsIgnoreCase("add teacher"))
			addteacherbtn.click();
		else if(whichbtn.equalsIgnoreCase("all teacher")) {
			wbu.explicitlywaitmethod(driver, allteacherbtn);
			allteacherbtn.click();
		                 }
	}
	public void setSignOut() {
		userlogo.click();
		signout.click();
	}
}
