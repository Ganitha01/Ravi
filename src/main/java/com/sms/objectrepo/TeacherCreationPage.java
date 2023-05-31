package com.sms.objectrepo;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.sms.genericutility.ExcelUtility;
import com.sms.genericutility.JavaUtility;
import com.sms.genericutility.WebDriverUtility;

public class TeacherCreationPage {

	WebDriverUtility wbu=new WebDriverUtility();
	JavaUtility ju=new JavaUtility();
	String iname="";
	int ran=ju.rannumber();
	
	
	@FindBy(id = "index_number")private WebElement indexnumtbx;
	@FindBy(name = "full_name")private WebElement fullnametbx;
	@FindBy(name = "i_name")private WebElement inametbx;
	@FindAll({@FindBy(xpath = "//input[@placeholder='Enter address']"),@FindBy(name = "address")})private WebElement addresstbx;
	@FindBy(xpath = "//select[@name='gender']")private WebElement genderdropbtn;
	@FindBy(name = "phone")private WebElement phonetbx;//123-123-1234 in this formate only
	@FindBy(id = "email")private WebElement emailtbx;
	@FindBy(id = "fileToUpload")private WebElement photoChosseFilebtn;
	@FindBy(xpath = "//button[text()='Submit']")private WebElement submitbtn;
	
	public TeacherCreationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getIndexnumtbx() {
		return indexnumtbx;
	}

	public WebElement getNametbx() {
		return fullnametbx;
	}

	public WebElement getInametbx() {
		return inametbx;
	}

	public WebElement getAddresstbx() {
		return addresstbx;
	}

	public WebElement getGenderdropbtn() {
		return genderdropbtn;
	}

	public WebElement getPhonetbx() {
		return phonetbx;
	}

	public WebElement getEmailtbx() {
		return emailtbx;
	}

	public WebElement getPhotoChosseFilebtn() {
		return photoChosseFilebtn;
	}

	public WebElement getSubmitbtn() {
		return submitbtn;
	}
	
	//bussiness Logic Method
	public String createTeacher(WebDriver driver,String iname) throws EncryptedDocumentException, IOException {
		AdminHomePage ahp=new AdminHomePage(driver);
		
		ahp.teacherModule(driver, "add teacher");
		wbu.explicitlywaitmethod(driver, indexnumtbx);
		String ind=""+ran;
		indexnumtbx.sendKeys(ind);
		String fullname=iname+ran;
		fullnametbx.sendKeys(fullname);
		inametbx.sendKeys(fullname);
		String add="TY";
		addresstbx.sendKeys(add);
		wbu.selectEleInDropDown("Male", genderdropbtn);
		String phone="123-123-1234";
		phonetbx.sendKeys(phone);
		String email=fullname+"@gmail.com";
		emailtbx.sendKeys(email);
		File f=new File("C:\\Users\\ravi\\OneDrive\\Pictures\\Saved Pictures\\A1.jpg");
        photoChosseFilebtn.sendKeys(f.getAbsolutePath());
		submitbtn.click();
		ExcelUtility ex=new ExcelUtility();
		ex.writeExceldata("Teacher", 1, 0, ind);
		ex.writeExceldata("Teacher", 1, 1, fullname);
		ex.writeExceldata("Teacher", 1, 2, fullname);
		ex.writeExceldata("Teacher", 1, 3, add);
		ex.writeExceldata("Teacher", 1, 4, phone);
		ex.writeExceldata("Teacher", 1, 5, email);
		CommonFeatures cf=new CommonFeatures(driver);
		wbu.waitTillEleInvisible(driver,cf.getSuccessmsg());
		return fullname;
	}
	public void createTeacherMap(WebDriver driver) throws Throwable {
		ExcelUtility ex=new ExcelUtility();
		WebDriverUtility wbu=new WebDriverUtility();
		
		HashMap<String, String> data = ex.getMapData("kv");
		 for(String i: data.keySet()) {
			 if(i.equalsIgnoreCase("i_name")||i.equalsIgnoreCase("full_name")||i.equalsIgnoreCase("address")||i.equalsIgnoreCase("phone")||i.equalsIgnoreCase("fileToUpload")) {
			 driver.findElement(By.name(i)).sendKeys(data.get(i));
		
			 }
			 else if(i.equalsIgnoreCase("index_number")) {
				 driver.findElement(By.name(i)).sendKeys(" "+ran);
			 }
			 else if(i.equalsIgnoreCase("gender")) {
				 wbu.selectEleInDropDown(data.get(i), driver.findElement(By.name(i)));
			
			 }
			 else if(i.equalsIgnoreCase("email")) {
				 driver.findElement(By.name(i)).sendKeys(data.get(i)+ran+"@gmail.com");
				
			 }
			 }
		 Thread.sleep(3000);
		 submitbtn.click();
		 }
	
	
	}
	
