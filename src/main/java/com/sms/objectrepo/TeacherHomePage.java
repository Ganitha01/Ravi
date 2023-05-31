package com.sms.objectrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TeacherHomePage {

	@FindBy(xpath = "//li[@class='dropdown user user-menu']/child::a[@data-toggle='dropdown']/child::img[@alt='User Image']")
	private WebElement userlogo;
	@FindBy(xpath="//a[text()='Sign out']") private WebElement signout;
	@FindBy(xpath = "//span[text()='My Student']") private WebElement mystudentbtn;
	@FindBy(xpath = "//span[text()='Subject']") private WebElement subjectbtn;
	        @FindBy(xpath = "//a[contains(text(),'My Subject')]") private WebElement mysubjectbtn;
	        @FindBy(xpath = "//a[contains(text(),'All Subject')]") private WebElement allsubjectbtn;
	@FindBy(xpath = "//span[text()='Timetable']") private WebElement timetablebtn;
	      @FindBy(xpath = "//a[contains(text(),'My Timetable')]") private WebElement mytimetablebtn;
	      @FindBy(xpath = "//a[contains(text(),'All Timetable')]") private WebElement alltimetablebtn;
	@FindBy(xpath = "//span[text()='Exam']") private WebElement exambtn;
	        @FindBy(xpath = "//a[text()=' My Student Exam Marks']") private WebElement mystudentexammarksbtn;
	        @FindBy(xpath = "//a[contains(text(),'Exam Timetable')]") private WebElement examtimetablebtn;
	        @FindBy(xpath ="//a[contains(text(),'My Student Exam Marks History')]") private WebElement mystudentexammarkshisbtn;
	@FindBy(xpath = "//span[text()='My Petty Cash']") private WebElement mypettycashbtn;
	@FindBy(xpath = "//span[text()='Attendance']") private WebElement attendancebtn;
            @FindBy(xpath = "//a[text()=' My Attendance']") private WebElement myattendancebtn;
            @FindBy(xpath = "//a[contains(text(),'My Attendance History')]") private WebElement myattendancehistorybtn;

            public TeacherHomePage(WebDriver driver) {
            	PageFactory.initElements(driver, this);
            }

			public WebElement getUserlogo() {
				return userlogo;
			}

			public WebElement getSignout() {
				return signout;
			}

			public WebElement getMystudentbtn() {
				return mystudentbtn;
			}

			public WebElement getSubjectbtn() {
				return subjectbtn;
			}

			public WebElement getMysubjectbtn() {
				return mysubjectbtn;
			}

			public WebElement getAllsubjectbtn() {
				return allsubjectbtn;
			}

			public WebElement getTimetablebtn() {
				return timetablebtn;
			}

			public WebElement getMytimetablebtn() {
				return mytimetablebtn;
			}

			public WebElement getAlltimetablebtn() {
				return alltimetablebtn;
			}

			public WebElement getExambtn() {
				return exambtn;
			}

			public WebElement getMystudentexammarksbtn() {
				return mystudentexammarksbtn;
			}

			public WebElement getExamtimetablebtn() {
				return examtimetablebtn;
			}

			public WebElement getMystudentexammarkshisbtn() {
				return mystudentexammarkshisbtn;
			}

			public WebElement getMypettycashbtn() {
				return mypettycashbtn;
			}

			public WebElement getAttendancebtn() {
				return attendancebtn;
			}

			public WebElement getMyattendancebtn() {
				return myattendancebtn;
			}

			public WebElement getMyattendancehistorybtn() {
				return myattendancehistorybtn;
			}
            
            
			public void setSignOut() {
				userlogo.click();
				signout.click();
			}
			public void examModule(String whichbtn) {
				exambtn.click();
				if(whichbtn.equalsIgnoreCase("my student exam marks"))
					mystudentexammarksbtn.click();
				else if(whichbtn.equalsIgnoreCase("my student exam marks history"))
					mystudentexammarkshisbtn.click();
				else if(whichbtn.equalsIgnoreCase("exam timetable"))
					examtimetablebtn.click();
			}
			public void attendanceModule(String whichbtn) {
				attendancebtn.click();
				if(whichbtn.equalsIgnoreCase("my attendance"))
					myattendancebtn.click();
				else if(whichbtn.equalsIgnoreCase("my attendance history"))
					myattendancehistorybtn.click();
			}
			public void timetableModule(String whichbtn) {
				timetablebtn.click();
				if(whichbtn.equalsIgnoreCase("my timetable"))
					mytimetablebtn.click();
				else if(whichbtn.equalsIgnoreCase("all timetable"))
					alltimetablebtn.click();
			}
			public void subjectModule(String whichbtn) {
				subjectbtn.click();
				if(whichbtn.equalsIgnoreCase("my subject"))
					mysubjectbtn.click();
				else if(whichbtn.equalsIgnoreCase("all subject"))
					allsubjectbtn.click();
			}

}
