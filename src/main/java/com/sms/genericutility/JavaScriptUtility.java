package com.sms.genericutility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtility {
    JavascriptExecutor js;
    
    public JavaScriptUtility(WebDriver driver) {
    	js=(JavascriptExecutor)driver;
    }
    
    public void scrollUP() {
    	js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
    }
    public void scrollTillElement(WebElement element) {
    	js.executeScript("arguments[0].scrollIntoView()",element);
    }
    public void scrollDown() {
    	js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }
    public void lunchApplication(String url) {
    	js.executeScript("window.location=arguments[0]",url);
    }
    public void senddkeys(WebElement element,String data) {
    	js.executeScript("arguments[0].value=arguments[1]",element,data);
    }
    public void click(WebElement element) {
    	js.executeScript("arguments[0].click()", element);
    }
    public void clickElementByID(String elementId) {
    	js.executeScript("document.getElementById('elementId').click()");
    }
    public String getTheText(WebElement element) {
    	String textFieldValue=(String)js.executeScript("return arguments[0].value;",element);
    	return textFieldValue;
    }
    public String getUrlOfCurrentPage() {
    String url=(String)js.executeScript("return window.location.href");
    return url;
    }
    public String getTitleOfCurrentPage() {
    	String title=(String)js.executeScript("return document.title");
    	return title;
    }
    
}
