package com.sms.objectrepo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sms.genericutility.IpathConstant;
import com.sms.genericutility.JavaUtility;
import com.sms.genericutility.WebDriverUtility;

public class GradeCreationPage {

	WebDriverUtility wdu=new WebDriverUtility();
	JavaUtility ju=new JavaUtility();
	String classname="";
	int ran=ju.rannumber();
	
	
	
	@FindBy(id = "name")private WebElement gradenametbx;//declaration
	@FindBy(id = "admission_fee")private WebElement adminfeetbx;
	@FindBy(name = "hall_charge")private WebElement hallchargetbx;
	@FindBy(id = "btnSubmit")private WebElement nextBtn;
	@FindBy(name = "mark_range[]")private WebElement marksrangetbx;//we have to give in 75-100 this formate only
	@FindBy(name = "mark_grade[]")private WebElement marksgradetbx;//we have to give abc etc
	@FindBy(xpath = "//button[text()='Submit']")private WebElement submitbtn;
	@FindBy(xpath = "//input[@type='search']")private WebElement searchtbx;
	@FindBy(xpath = "//a[text()='Edit']")private WebElement editbtn;
	@FindBy(xpath = "//a[text()='View eMark']")private WebElement viewmarksbtn;
	
	public GradeCreationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);//initalization
	}

	public WebElement getGradenametbx() {
		return gradenametbx;
	}

	public WebElement getAdmifeetbx() {
		return adminfeetbx;
	}

	public WebElement getHallchargetbx() {
		return hallchargetbx;
	}

	public WebElement getNextBtn() {
		return nextBtn;
	}

	public WebElement getMarksrangetbx() {
		return marksrangetbx;
	}

	public WebElement getMarksgradetbx() {
		return marksgradetbx;
	}

	public WebElement getSubmitbtn() {
		return submitbtn;
	}

	public WebElement getSearchtbx() {
		return searchtbx;
	}

	public WebElement getEditbtn() {
		return editbtn;
	}

	public WebElement getViewmarksbtn() {
		return viewmarksbtn;
	}
	
	//utilization
	public String createGrade(WebDriver driver,String classname) {
       wdu.explicitlywaitmethod(driver,gradenametbx);
        classname=classname+ran;
       gradenametbx.sendKeys(classname);
       adminfeetbx.sendKeys("1000");
       hallchargetbx.sendKeys("420");
       nextBtn.click();
       wdu.explicitlywaitmethod(driver, marksrangetbx);
       marksrangetbx.sendKeys("76-99");
       marksgradetbx.sendKeys("A");
       submitbtn.click();
       CommonFeatures cf=new CommonFeatures(driver);
       wdu.waitTillEleInvisible(driver,cf.getSuccessmsg());
       //String sucess=driver.findElement(By.xpath("//strong[text()='Success!']")).getText();
       //System.out.println(sucess);
       return classname;
	}
	
	public void verifyGradeisCreated(WebDriver driver) {
		wdu.elementClickablemethod(driver, searchtbx);
		 searchtbx.sendKeys(classname);
		 String data=driver.findElement(By.xpath("//td[text()='"+classname+"']")).getText();
		 if(data.equals(classname)) {
			 System.out.println("grade is created");
		 }
		 else
			 System.out.println("grade is not created");
	}
}
