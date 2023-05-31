package com.sms.objectrepo;

import org.openqa.selenium.WebDriver;

import com.sms.genericutility.WebDriverUtility;

public class ExamTimetableCreationPage {

	WebDriverUtility wbu=new WebDriverUtility();
	
	
public void createTimetable(WebDriver driver,String grade,String exname,String day,String subject,String classroom,String starttime,String endtime){
		AdminHomePage ahp=new AdminHomePage(driver);
		CommonFeatures cf=new CommonFeatures(driver);
		
		ahp.examModule(driver,"Exam Timetable");
		wbu.customeWait(10,cf.getGradedropbtn(), 1000);
		wbu.selectEleInDropDown(grade, cf.getGradedropbtn());
		wbu.selectEleInDropDown(exname, cf.getExamDropdownbtn());
		cf.getNextbtn().click();
		wbu.customeWait(10, cf.getAddbtn(), 1000);
		wbu.customeWait(10, cf.getDayDropbtn(), 1000);
		wbu.selectEleInDropDown(day, cf.getDayDropbtn());
		cf.getSubjectdropbtn().click();
		wbu.selectEleInDropDown(subject, cf.getSubjectdropbtn());
		cf.getClassroomDropbtn().click();
		wbu.selectEleInDropDown(classroom, cf.getClassroomDropbtn());
		cf.getStartTimeBtn().sendKeys(starttime);
		cf.getEndTimeBtn().sendKeys(endtime);
		SubjectRoutingCreationPage srcp=new SubjectRoutingCreationPage(driver);
		srcp.getSubmitbtn().click();
		//CommonFeatures cf=new CommonFeatures(driver);
	      wbu.waitTillEleInvisible(driver, cf.getSuccessmsg());
	}


}
