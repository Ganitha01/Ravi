package com.sms.objectrepo;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sms.genericutility.WebDriverUtility;

public class AddExamMarksPage {


	
	WebDriverUtility wbu=new WebDriverUtility();
	@FindBy(partialLinkText = "Add Exam Marks")private WebElement addexammarksbtn;
	@FindBy(xpath = "//button[@id='btnSubmit3']")private WebElement markssubmitbtn;
	@FindBy(xpath = "//input[@name='exam_mark[]']")private List<WebElement> subjectmarkslisttx;
	@FindBy(partialLinkText = "View Exam Marks")private WebElement viewmarksbtn;
	
	
	public AddExamMarksPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	
  public WebElement getAddexammarksbtn() {
		return addexammarksbtn;
	}


	public WebElement getMarkssubmitbtn() {
		return markssubmitbtn;
	}


	public List<WebElement> getSubjectmarkslisttx() {
		return subjectmarkslisttx;
	}


	public WebElement getViewmarksbtn() {
		return viewmarksbtn;
	}


public void addExamMarks(WebDriver driver,String gradename,String examname,String studentname) {
	  CommonFeatures cf=new CommonFeatures(driver);
	  wbu.customeWait(10, cf.getGradedropbtn(), 1000);
	  wbu.selectEleInDropDown(gradename, cf.getGradedropbtn());
	  wbu.customeWait(10, cf.getExamDropdownbtn(), 1000);
	  wbu.selectEleInDropDown(examname, cf.getExamDropdownbtn());
	  cf.getSubmitbtn().click();
	  
	  
	  wbu.explicitlywaitmethod(driver, cf.getSearchbox());
	  cf.getSearchbox().sendKeys(studentname);
	  wbu.explicitlywaitmethod(driver, addexammarksbtn);
	  addexammarksbtn.click();
	  for(int i=0;i<subjectmarkslisttx.size();i++) {
		  subjectmarkslisttx.get(i).sendKeys("88");
	  }
	  markssubmitbtn.click();
	  wbu.explicitlywaitmethod(driver, viewmarksbtn);

  }

}
