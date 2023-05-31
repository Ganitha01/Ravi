package com.sms.objectrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sms.genericutility.JavaUtility;
import com.sms.genericutility.WebDriverUtility;

public class PettyCashCreationPage {
	
	WebDriverUtility wbu=new WebDriverUtility();
	JavaUtility ju=new JavaUtility();
	int ran=ju.rannumber();
	
	@FindBy(id = "textDesc_1")private WebElement descriptiontbx;
	@FindBy(id = "textAmount_1")private WebElement amounttbx;
	@FindBy(xpath = "//input[@class='btn btn-primary' and @type='submit']")private WebElement pettysubmitbtn;
	
	
	
	public PettyCashCreationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public WebElement getPettysubmitbtn() {
		return pettysubmitbtn;
	}


	public WebElement getDescriptiontbx() {
		return descriptiontbx;
	}

	public WebElement getAmounttbx() {
		return amounttbx;
	}


	public String createPettyCash(WebDriver driver,String pettyname,String amount) {
		//AdminHomePage ahp=new AdminHomePage(driver);
		//wbu.customeWait(10, ahp.getPettycashbtn(), 1000);
		 TeacherHomePage thp=new TeacherHomePage(driver);
		 wbu.customeWait(10, thp.getMypettycashbtn(), 1000);
		 
		CommonFeatures cf=new CommonFeatures(driver);
	wbu.customeWait(10, cf.getAddbtn(), 1000);
	wbu.explicitlywaitmethod(driver, descriptiontbx);
	pettyname=pettyname+ran;
	descriptiontbx.sendKeys(pettyname);
	amounttbx.sendKeys(amount);
	pettysubmitbtn.click();
			wbu.waitTillEleInvisible(driver, cf.getSuccessmsg());
			return pettyname;
	}
}
