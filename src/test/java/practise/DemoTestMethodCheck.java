package practise;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.sms.genericutility.BaseClass;
import com.sms.genericutility.ExcelUtility;

public class DemoTestMethodCheck extends BaseClass{

	
	ExcelUtility ex=new ExcelUtility();
	
	@Test
	public void loginasAdmin() throws EncryptedDocumentException, IOException {
		Reporter.log("Login to admin");
		
		ex.writeExceldata("Login", 0, 0, "teacher");
	}
	
	@Test(dependsOnMethods = "loginasAdmin")
	public void loginasTeacher() throws EncryptedDocumentException, IOException {
		Reporter.log("teacher login");
		ex.writeExceldata("Login", 0, 0, "admin");
	}
}
