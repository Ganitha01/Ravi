package com.sms.objectrepo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.sms.genericutility.JavaUtility;
import com.sms.genericutility.WebDriverUtility;

public class ClassRoomCreationPage {

	JavaUtility ju=new JavaUtility();
	int ran=0;
	String classname="";
	WebDriverUtility wbu=new WebDriverUtility();
	
	
	
	
	@FindBys({@FindBy(id = "name"),@FindBy(xpath = "//input[@placeholder='Enter classroom name']")})
	private WebElement classnameTf;
	@FindBys({@FindBy(id = "student_count"),@FindBy(xpath = "//input[@placeholder='Enter student count']")})
	private WebElement studentcountTf;
	@FindBy(id = "btnSubmit")private WebElement submitbtn;
	
	@FindAll({@FindBy(xpath = "//input[@type='search']"),@FindBy(xpath = "//input[@class='form-control input-sm']")})
	private WebElement searchbox;
	
	@FindBy(xpath = "//a[normalize-space()='Edit']")private WebElement classRoomeditoptbtn;
	
	//it will return all the row of the table
	@FindBy(xpath = "//tr[@role=\"row\"]")
	private List<WebElement> tableRows;
	
	public ClassRoomCreationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getClassnameTf() {
		return classnameTf;
	}

	public WebElement getStudentcountTf() {
		return studentcountTf;
	}

	public WebElement getSubmitbtn() {
		return submitbtn;
	}

	public WebElement getSearchbox() {
		return searchbox;
	}

	public List<WebElement> getTableRows() {
		return tableRows;
	}
	public WebElement getClassRoomeditoptbtn() {
		return classRoomeditoptbtn;
	}
	
	public String createClassRoom(WebDriver driver,String classname){
		ran=ju.rannumber();
		classname=classname+ran;
		classnameTf.sendKeys(classname);
		studentcountTf.sendKeys(""+ran);
		submitbtn.click();
		CommonFeatures cf=new CommonFeatures(driver);
		wbu.waitTillEleInvisible(driver, cf.getSuccessmsg());
		//String sucess=driver.findElement(By.xpath("//strong[text()='Success!']")).getText();
	      // System.out.println(sucess);
	       return classname;
	}
	public void verifyClassRoomCreated(WebDriver driver) {
		wbu.ignorenosuchElementExcep(driver);
		wbu.elementClickablemethod(driver, searchbox);
		searchbox.sendKeys(classname);
		wbu.explicitlywaitmethod(driver, classRoomeditoptbtn);
		boolean flag=false;
		 for(int i=0;i<tableRows.size();i++) {
			 String data=tableRows.get(i).getText();
			    if(data.contains(classname)) {
			    	System.out.println("class room was created");
			    	flag=true;
			    	break;
			    }
		 }
		 if(!flag) {
			 System.out.println("class room was not created");
		 }
	}
	
}
