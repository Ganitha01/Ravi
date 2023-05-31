package com.sms.objectrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sms.genericutility.WebDriverUtility;

public class ExamCreationPage {

	WebDriverUtility wbu=new WebDriverUtility();
	
	
	@FindBy(xpath = "//input[@placeholder='Enter exam name']")private WebElement examnametbx;
	
	
	public ExamCreationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String createExam(WebDriver driver,String examname) {
	
		CommonFeatures cf=new CommonFeatures(driver);
		AdminHomePage ahp=new AdminHomePage(driver);
		ahp.examModule(driver,"create Exam");
		wbu.customeWait(10, cf.getAddbtn(), 1000);
		wbu.explicitlywaitmethod(driver, examnametbx);
		examnametbx.sendKeys(examname);
		cf.getSubmitbtn().click();
		//CommonFeatures cf=new CommonFeatures(driver);
	      wbu.waitTillEleInvisible(driver, cf.getSuccessmsg());
		return examname;
	}
	
	
}
