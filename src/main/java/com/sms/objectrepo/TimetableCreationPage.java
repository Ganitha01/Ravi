package com.sms.objectrepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import com.sms.genericutility.JavaScriptUtility;
import com.sms.genericutility.WebDriverUtility;

public class TimetableCreationPage {

	WebDriverUtility wdu=new WebDriverUtility();
	
	
	@FindAll({@FindBy(id = "btnSubmit"),@FindBy(xpath = "//button[@class='btn btn-info ']"),@FindBy(xpath = "//button[@id='btnSubmit']")})
	private WebElement timetablesubmitbtn;
	
public void createTimeTable(WebDriver driver,String grade,String day,String subject,String teacher,String classRoom,String starttime,String endtime){
		AdminHomePage ahp=new AdminHomePage(driver);
		CommonFeatures cf=new CommonFeatures(driver);
		
		 wdu.customeWait(10, cf.getGradedropbtn(), 1000);
		 wdu.selectEleInDropDown(grade, cf.getGradedropbtn());
		 cf.getSubmitbtn().click();
		 wdu.customeWait(10, cf.getAddbtn(), 1000);
		 wdu.customeWait(10,cf.getDayDropbtn(), 1000);
		 wdu.selectEleInDropDown(day, cf.getDayDropbtn());
		 cf.getSubjectdropbtn().click();
		 wdu.selectEleInDropDown(subject, cf.getSubjectdropbtn());
		 cf.getTeacherdropbtn().click();
		 wdu.selectEleInDropDown(teacher, cf.getTeacherdropbtn());
		 cf.getClassroomDropbtn().click();
		 wdu.selectEleInDropDown(classRoom, cf.getClassroomDropbtn());
		 cf.getStartTimeBtn().sendKeys(starttime);
		 cf.getEndTimeBtn().sendKeys(endtime);
         driver.findElement(By.xpath("//button[@id='btnSubmit']")).click();
        wdu.waitTillEleInvisible(driver, cf.getSuccessmsg());
    }


}
