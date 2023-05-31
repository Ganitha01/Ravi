package com.sms.objectrepo;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sms.genericutility.JavaUtility;
import com.sms.genericutility.WebDriverUtility;

public class StudentCreationpage {

	WebDriverUtility wbu=new WebDriverUtility();
	JavaUtility ju=new JavaUtility();
	int ran=ju.rannumber();
	String sname="";
	String gname="";


	
	@FindBy(id = "index_number")private WebElement indexnumtbx;
	@FindBy(name = "full_name")private WebElement fullnametbx;
	@FindBy(name = "i_name")private WebElement inametbx;
	@FindAll({@FindBy(xpath = "//input[@placeholder='Enter address']"),@FindBy(name = "address")})private WebElement addresstbx;
	@FindBy(xpath = "//select[@name='gender']")private WebElement genderdropbtn;
	@FindBy(name = "phone")private WebElement phonetbx;//123-123-1234 in this formate only
	@FindBy(id = "email")private WebElement emailtbx;
	@FindBy(id = "fileToUpload")private WebElement photoChosseFilebtn;
	@FindBy(id = "b_date")private WebElement dobtbx;
	
	@FindBy(name = "g_full_name")private WebElement gfullnametbx;
	@FindBy(name = "g_i_name")private WebElement ginametbx;
	@FindAll({@FindBy(id = "g_address"),@FindBy(name = "g_address")})private WebElement gaddresstbx;
	@FindBy(xpath = "//select[@name='g_gender']")private WebElement gardengenderdropbtn;
	@FindBy(name = "g_phone")private WebElement gphonetbx;//123-123-1234 in this formate only
	@FindBy(id = "g_email")private WebElement gemailtbx;
	@FindBy(id = "g_fileToUpload")private WebElement gphotoChosseFilebtn;
	@FindBy(id = "g_b_date")private WebElement gdobtbx;
	@FindBy(xpath = "//button[@id='btnSubmit' and @type='submit']")private WebElement nextBtn;
	@FindBy(xpath = "//select[@class='form-control' and @name='grade']")private WebElement screationgradebtn;
	@FindBy(xpath = "//table[@class='table ']/child::tbody/tr[*]/td[1]/input[@name='checkbox[]']")private List<WebElement> addsubjcheckboxs;
	@FindBy(xpath = "//button[@class='btn btn-info ' and @id='btnSubmit1']")private WebElement addsubjsubmitbtn;
	//@FindBy(xpath = "//button[@class='btn btn-primary btn-md']")private WebElement paidbtn;
	@FindBy(xpath = "//button[@onclick='addSPayment(this)']")private WebElement paidbtn;
	
	
	
	public StudentCreationpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public String getSname() {
		return sname;
	}


	public String getGname() {
		return gname;
	}


	public WebElement getScreationgradebtn() {
		return screationgradebtn;
	}


	public List<WebElement> getAddsubjcheckboxs() {
		return addsubjcheckboxs;
	}


	public WebElement getAddsubjsubmitbtn() {
		return addsubjsubmitbtn;
	}


	public WebElement getPaidbtn() {
		return paidbtn;
	}


	public WebElement getIndexnumtbx() {
		return indexnumtbx;
	}


	public WebElement getFullnametbx() {
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


	public WebElement getDobtbx() {
		return dobtbx;
	}


	public WebElement getGfullnametbx() {
		return gfullnametbx;
	}


	public WebElement getGinametbx() {
		return ginametbx;
	}


	public WebElement getGaddresstbx() {
		return gaddresstbx;
	}


	public WebElement getGardengenderdropbtn() {
		return gardengenderdropbtn;
	}


	public WebElement getGphonetbx() {
		return gphonetbx;
	}


	public WebElement getGemailtbx() {
		return gemailtbx;
	}


	public WebElement getGphotoChosseFilebtn() {
		return gphotoChosseFilebtn;
	}


	public WebElement getGdobtbx() {
		return gdobtbx;
	}


	public WebElement getNextBtn() {
		return nextBtn;
	}
	
	public String createStudent(WebDriver driver,String sname,String gname,String grade) throws AWTException, InterruptedException {
		AdminHomePage ahp=new AdminHomePage(driver);
	
		ahp.studentModule(driver,"Add student");
		
		wbu.explicitlywaitmethod(driver,indexnumtbx);
		indexnumtbx.sendKeys(""+ran);
		sname=sname+ran;
		fullnametbx.sendKeys(sname);
		inametbx.sendKeys(sname);
		addresstbx.sendKeys("TY");
		String email=sname+"@gmail.com";
		emailtbx.sendKeys(email);
		phonetbx.sendKeys("123-123-1234");
		dobtbx.sendKeys("01/01/0001");
		genderdropbtn.click();
		wbu.selectEleInDropDown("Male", genderdropbtn);
		File f=new File("C:\\Users\\ravi\\OneDrive\\Pictures\\Saved Pictures\\A1.jpg");
        photoChosseFilebtn.sendKeys(f.getAbsolutePath());
        
        gname=gname+ran;
        gfullnametbx.sendKeys(gname);
		ginametbx.sendKeys(gname);
		gaddresstbx.sendKeys("TY");
		String gemail=gname+"@gmail.com";
		gemailtbx.sendKeys(gemail);
		gphonetbx.sendKeys("123-123-1234");
		gdobtbx.sendKeys("01/01/0001");
		gardengenderdropbtn.click();
		wbu.selectEleInDropDown("Male", gardengenderdropbtn);
		//File f=new File("C:\\Users\\ravi\\OneDrive\\Pictures\\Saved Pictures\\A1.jpg");
        gphotoChosseFilebtn.sendKeys(f.getAbsolutePath());
        nextBtn.click();
        wbu.customeWait(10, screationgradebtn, 1000);
        wbu.selectEleInDropDown(grade, screationgradebtn);
        wbu.explicitlywaitmethod(driver, addsubjsubmitbtn);
        List<WebElement> chebox = addsubjcheckboxs;
        for(int i=0;i<chebox.size();i++) {
		       chebox.get(i).click();
	}
        addsubjsubmitbtn.click();
      wbu.customeWait(10, paidbtn, 1000);
      Thread.sleep(2000);
       Robot r=new Robot();
       r.keyPress(KeyEvent.VK_TAB);
       r.keyRelease(KeyEvent.VK_TAB);
       r.keyPress(KeyEvent.VK_ENTER);
       r.keyRelease(KeyEvent.VK_ENTER);
       Thread.sleep(1000);
       CommonFeatures cf=new CommonFeatures(driver);
       
      wbu.waitTillEleInvisible(driver, cf.getSuccessmsg());
      
        return sname;
	}	
	
	public void verifyStudent(WebDriver driver,String grade,String stuname) {
		
		AdminHomePage ahp=new AdminHomePage(driver);
		ahp.studentModule(driver,"All student");
		CommonFeatures cf=new CommonFeatures(driver);
		wbu.customeWait(10, cf.getGradedropbtn(), 1000);
		wbu.selectEleInDropDown(grade, cf.getGradedropbtn());
		cf.getSubmitbtn().click();
		cf.verifyMethod(driver, stuname);
	
	}
	
	
	
}
