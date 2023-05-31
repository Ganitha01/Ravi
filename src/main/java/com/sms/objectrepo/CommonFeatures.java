package com.sms.objectrepo;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.sms.genericutility.JavaUtility;
import com.sms.genericutility.PropertyUtility;
import com.sms.genericutility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonFeatures {

	WebDriverUtility wbu=new WebDriverUtility();
	JavaUtility ju=new JavaUtility();
	
	
	
	@FindAll({@FindBy(xpath = "//input[@type='search']"),@FindBy(xpath = "//input[@class='form-control input-sm']")})
	private WebElement searchbox;
	@FindBy(xpath = "//a[text()='Edit']")private WebElement editbtn;
	@FindBy(xpath = "//a[text()='Delete']")private WebElement deletebtn;
	@FindBy(xpath = "//table[@id='example1']/descendant::tr[@class='odd' or @class='even']")private List<WebElement> tablerows;
	@FindBy(xpath = "//button[text()='Submit']")private WebElement submitbtn;
	@FindBy(xpath = "//strong[text()='Success!']")private WebElement successmsg;
	@FindAll({@FindBy(xpath = "//a[@class='btn btn-success btn-sm pull-right']"),@FindBy(partialLinkText = "Add ")})private WebElement addbtn;
	@FindAll({@FindBy(id = "grade"),@FindBy(xpath = "//select[@class='form-control']")})private WebElement gradedropbtn;
	@FindBy(id = "subject")private WebElement subjectdropbtn;
	@FindBy(id = "teacher")private WebElement teacherdropbtn;
	@FindBy(id = "day")private WebElement dayDropbtn;
	@FindBy(name = "classroom_id")private WebElement classroomDropbtn;
	@FindBy(name = "start_time")private WebElement startTimeBtn;
	@FindBy(name = "end_time")private WebElement endTimeBtn;
	@FindBy(xpath = "//select[@id='exam']")private WebElement examDropdownbtn;
	@FindBy(xpath = "//button[@class='btn btn-primary']")private WebElement nextbtn;
	

	
	public CommonFeatures(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	public WebElement getExamDropdownbtn() {
		return examDropdownbtn;
	}


	public WebElement getNextbtn() {
		return nextbtn;
	}


	public WebElement getDayDropbtn() {
		return dayDropbtn;
	}

	public WebElement getClassroomDropbtn() {
		return classroomDropbtn;
	}

	public WebElement getStartTimeBtn() {
		return startTimeBtn;
	}

	public WebElement getEndTimeBtn() {
		return endTimeBtn;
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

	public WebElement getSearchbox() {
		return searchbox;
	}

	public WebElement getEditbtn() {
		return editbtn;
	}

	public WebElement getDeletebtn() {
		return deletebtn;
	}

	public List<WebElement> getTablerows() {
		return tablerows;
	}

	public WebElement getSubmitbtn() {
		return submitbtn;
	}

	public WebElement getSuccessmsg() {
		return successmsg;
	}

	
	
	
	public void loginToSms(PropertyUtility pu,WebDriver driver,WebDriverUtility wdu) throws IOException {
		LoginPage l=new LoginPage(driver);
		//l.loginToSms(null, null);
		l.getUntbx().sendKeys(pu.getDataFromPropertyFile("adminusername"));
		l.getPstbx().sendKeys(pu.getDataFromPropertyFile("password"));
		l.getSubtn().click();
			}
	public void setSignOut(WebDriver driver) {
		AdminHomePage amp=new AdminHomePage(driver);
		wbu.customeWait(10, amp.getUserlogo(), 1000);
		//amp.getUserlogo().click();
		amp.getSignout().click();
	}
	
	public void verifyMethod(WebDriver driver,String what) {
	
		searchbox.sendKeys(what);
		//wbu.elementClickablemethod(driver,editbtn);
		wbu.explicitlywaitmethod(driver,searchbox);
		 List<WebElement> tabledata = tablerows;
		 boolean flag=false;
		 for(int i=0;i<tabledata.size();i++) {
			 String data=tabledata.get(i).getText();
			//Assert.assertEquals(data.contains(what), true, "Created");
			 if(data.contains(what)) {
				 System.out.println("created");
				 flag=true;
				 break;
			 }
		 }
		if(!flag)System.out.println("not created");
		
	}
  }
	
