package com.sms.objectrepo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sms.genericutility.JavaUtility;
import com.sms.genericutility.WebDriverUtility;

public class SubjectCreationPage {

	WebDriverUtility wbu=new WebDriverUtility();
	JavaUtility ju=new JavaUtility();
	String subname="";
	int ran=ju.rannumber();	
	
	
	@FindBy(id = "name")private WebElement subjectnametbx;
	@FindBy(xpath = "//button[text()='Submit']")private WebElement submitbtn;

	
	public SubjectCreationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public WebElement getSubjectnametbx() {
		return subjectnametbx;
	}


	public WebElement getSubmitbtn() {
		return submitbtn;
	}
	public String createSubject(WebDriver driver,String subname) {
		
		wbu.explicitlywaitmethod(driver, subjectnametbx);
		subname=subname+ran;
		subjectnametbx.sendKeys(subname);
		submitbtn.click();
CommonFeatures cf=new CommonFeatures(driver);
	      wbu.waitTillEleInvisible(driver, cf.getSuccessmsg());
	       return subname;
	}
	public void verifySubject(WebDriver driver) {
		CommonFeatures cf=new CommonFeatures(driver);
		cf.getSearchbox().sendKeys(subname);
		wbu.elementClickablemethod(driver,cf.getEditbtn());
		 List<WebElement> tabledata = cf.getTablerows();
		 boolean flag=false;
		 for(int i=0;i<tabledata.size();i++) {
			 String data=tabledata.get(i).getText();
			 if(data.contains(subname)) {
				 System.out.println("created");
				 flag=true;
				 break;
			 }
		 }
		if(!flag)System.out.println("not created");
	}
	
	
	
	
}
