package com.sms.objectrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sms.genericutility.JavaUtility;
import com.sms.genericutility.WebDriverUtility;

public class SubjectRoutingCreationPage {

	WebDriverUtility wbu=new WebDriverUtility();
	JavaUtility ju=new JavaUtility();
	
	
	@FindAll({@FindBy(xpath = "//a[@class='btn btn-success btn-sm pull-right']"),@FindBy(partialLinkText = "Add ")})private WebElement addbtn;
	@FindAll({@FindBy(id = "grade"),@FindBy(xpath = "//select[@class='form-control']")})private WebElement gradedropbtn;
	@FindBy(id = "subject")private WebElement subjectdropbtn;
	@FindBy(id = "teacher")private WebElement teacherdropbtn;
	@FindBy(id = "fee")private WebElement feetbx;
	@FindBy(xpath = "//button[text()='Submit']")private WebElement submitbtn;
	
	
	public SubjectRoutingCreationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public WebElement getAddbtn() {
		return addbtn;
	}


	public WebElement getGradedropbtn() {
		return gradedropbtn;
	}


	public WebElement getSubjectdropbtn() {
		return subjectdropbtn;
	}


	public WebElement getTeacherdropbtn() {
		return teacherdropbtn;
	}


	public WebElement getFeetbx() {
		return feetbx;
	}


	public WebElement getSubmitbtn() {
		return submitbtn;
	}
	
	public void createSubjectRouting(WebDriver driver,String grade,String subject,String teacher) {
		wbu.explicitlywaitmethod(driver, addbtn);
		addbtn.click();
		wbu.customeWait(10, gradedropbtn, 1000);
		gradedropbtn.click();
		wbu.selectEleInDropDown(grade, gradedropbtn);
		subjectdropbtn.click();
		wbu.selectEleInDropDown(subject, subjectdropbtn);
		teacherdropbtn.click();
		wbu.selectEleInDropDown(teacher, teacherdropbtn);
		feetbx.sendKeys("420");
		CommonFeatures cf=new CommonFeatures(driver);
		cf.getSubmitbtn().click();
		
	      wbu.waitTillEleInvisible(driver, cf.getSuccessmsg());
	}
	
}
