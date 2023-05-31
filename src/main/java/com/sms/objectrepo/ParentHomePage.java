package com.sms.objectrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ParentHomePage {

	
	@FindBy(xpath = "//li[@class='dropdown user user-menu']/child::a[@data-toggle='dropdown']/child::img[@alt='User Image']")
	private WebElement userlogo;
	@FindBy(xpath="//a[text()='Sign out']") private WebElement signout;
	@FindBy(xpath = "//span[text()='Teacher']") private WebElement teacherbtn;
	       @FindBy(xpath = "//a[@href='my_sons_teacher.php']") private WebElement mysonsteacherbtn;
	       @FindBy(xpath = "//a[@href='all_teacher3.php']") private WebElement allteacherbtn;
	@FindBy(xpath = "//span[text()='Timetable']") private WebElement timetablebtn;
	       @FindBy(xpath = "//a[@href='my_sons_timetable.php']") private WebElement mysonstimetablebtn;
	       @FindBy(xpath = "//a[@href='all_timetable3.php']") private WebElement alltimetablebtn;
	@FindBy(xpath = "//span[text()='Subject']") private WebElement subjectbtn;
	       @FindBy(xpath = "//a[@href='my_sons_subject.php']") private WebElement mysonssubjectbtn;
	       @FindBy(xpath = "//a[@href='all_subject3.php']") private WebElement allsubjectbtn;
	@FindBy(xpath = "//span[text()='Attendance']") private WebElement attendancebtn;
	       @FindBy(xpath = "//a[@href='my_sons_attendance.php']") private WebElement mysonsattendancebtn;
	       @FindBy(xpath = "//a[@href='my_sons_attendance_history.php']") private WebElement mysonsattendancehisbtn;
	@FindBy(xpath = "//span[text()='Exam']") private WebElement exambtn;
	       @FindBy(xpath = "//a[@href='my_sons_exam_marks_history.php']") private WebElement mysonsexammarkshisbtn;
	       @FindBy(xpath = "//a[@href='my_sons_exam_marks.php']") private WebElement mysonsexammarksbtn;
	       @FindBy(xpath = "//a[@href='my_sons_exam_timetable.php']") private WebElement mysonsexamtimetablebtn;
	       
	       public ParentHomePage(WebDriver driver) {
	    	   PageFactory.initElements(driver,this);
	       }

		public WebElement getUserlogo() {
			return userlogo;
		}

		public WebElement getSignout() {
			return signout;
		}

		public WebElement getTeacherbtn() {
			return teacherbtn;
		}

		public WebElement getMysonsteacherbtn() {
			return mysonsteacherbtn;
		}

		public WebElement getAllteacherbtn() {
			return allteacherbtn;
		}

		public WebElement getTimetablebtn() {
			return timetablebtn;
		}

		public WebElement getMysonstimetablebtn() {
			return mysonstimetablebtn;
		}

		public WebElement getAlltimetablebtn() {
			return alltimetablebtn;
		}

		public WebElement getSubjectbtn() {
			return subjectbtn;
		}

		public WebElement getMysonssubjectbtn() {
			return mysonssubjectbtn;
		}

		public WebElement getAllsubjectbtn() {
			return allsubjectbtn;
		}

		public WebElement getAttendancebtn() {
			return attendancebtn;
		}

		public WebElement getMysonsattendancebtn() {
			return mysonsattendancebtn;
		}

		public WebElement getMysonsattendancehisbtn() {
			return mysonsattendancehisbtn;
		}

		public WebElement getExambtn() {
			return exambtn;
		}

		public WebElement getMysonsexammarkshisbtn() {
			return mysonsexammarkshisbtn;
		}

		public WebElement getMysonsexammarksbtn() {
			return mysonsexammarksbtn;
		}

		public WebElement getMysonsexamtimetablebtn() {
			return mysonsexamtimetablebtn;
		}
	       
		public void setSignOut() {
			userlogo.click();
			signout.click();
		}
		public void examModule(String whichbtn) {
			exambtn.click();
			if(whichbtn.equalsIgnoreCase("my sons exam marks"))
				mysonsexammarksbtn.click();
			else if(whichbtn.equalsIgnoreCase("my sons exam marks history"))
				mysonsexammarkshisbtn.click();
			else if(whichbtn.equalsIgnoreCase("my sons exam timetable"))
				mysonsexamtimetablebtn.click();
		}
		public void attendanceModule(String whichbtn) {
			attendancebtn.click();
			if(whichbtn.equalsIgnoreCase("my sons attendance"))
				mysonsattendancebtn.click();
			else if(whichbtn.equalsIgnoreCase("my sons attendance history"))
				mysonsattendancehisbtn.click();
		}
		public void timetableModule(String whichbtn) {
			timetablebtn.click();
			if(whichbtn.equalsIgnoreCase("my sons timetable"))
				mysonstimetablebtn.click();
			else if(whichbtn.equalsIgnoreCase("all timetable"))
				alltimetablebtn.click();
		}
		public void subjectModule(String whichbtn) {
			subjectbtn.click();
			if(whichbtn.equalsIgnoreCase("my sons subject"))
				mysonssubjectbtn.click();
			else if(whichbtn.equalsIgnoreCase("all subject"))
				allsubjectbtn.click();
		}
		public void teacherModule(String whichbtn) {
			teacherbtn.click();
			if(whichbtn.equalsIgnoreCase("my sons teacher"))
				mysonsteacherbtn.click();
			else if(whichbtn.equalsIgnoreCase("all teacher"))
				allteacherbtn.click();
		}
		
}
