package com.sms.objectrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(id = "email")
	private WebElement untbx;//declaration is done
	@FindBy(id = "password")
	private WebElement pstbx;
	@FindBy(id = "btnSubmit")
	private WebElement subtn;
	
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);//constructer is the nbest palace to insitalize
	}
	
	//utilization
	public WebElement getUntbx() {
		return untbx;
	}

	public WebElement getPstbx() {
		return pstbx;
	}

	public void setPstbx(WebElement pstbx) {
		this.pstbx = pstbx;
	}

	public WebElement getSubtn() {
		return subtn;
	}

	public void setSubtn(WebElement subtn) {
		this.subtn = subtn;
	}

	public void setUntbx(WebElement untbx) {
		this.untbx = untbx;
	}
	public void loginToSms(String username,String password) {
		untbx.sendKeys(username);
		pstbx.sendKeys(password);
		subtn.click();
			}	
}
