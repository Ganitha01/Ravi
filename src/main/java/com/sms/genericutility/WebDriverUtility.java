package com.sms.genericutility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.commons.math3.analysis.function.Exp;
import org.apache.commons.math3.geometry.spherical.twod.Edge;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverUtility {

	
	
	public void browserSetup() throws IOException {
		PropertyUtility pu=new PropertyUtility();
		String browser = pu.getDataFromPropertyFile("browser");
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			WebDriver driver=new EdgeDriver();
		}
		else{
			WebDriverManager.chromedriver().setup();
			WebDriver driver=new ChromeDriver();
		}
	}
	
	/**
	 * this method is used to open the url.
	 * @param driver
	 * @param url
	 */
	public void getUrl(WebDriver driver,String url) {
		driver.get(url);
	}
	/**
	 * this method is used to maximise the browser
	 * @param driver
	 */
	public void maximisetheBrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}
	/**
	 * this method is used to minimise the browser
	 * @param driver
	 */
	public void minimisethebrowser(WebDriver driver) {
		driver.manage().window().minimize();
	}
	public void implicitlywaitmethod(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IpathConstant.implicitlywaitduration));
	}
	/**
	 * this method is used to wait until the element is visible in the page or load in the page
	 * @param driver
	 * @param element
	 */
	public void explicitlywaitmethod(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(IpathConstant.explicitlywaitduration));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * this method is used to clikable..
	 * @param driver
	 * @param element
	 */
	public void elementClickablemethod(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(IpathConstant.explicitlywaitduration));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void alertexplicitlywait(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(IpathConstant.explicitlywaitduration));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	public void waitforatitle(WebDriver driver,String title) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(IpathConstant.explicitlywaitduration));
		wait.until(ExpectedConditions.titleContains(title));
	}
	public void waitforurlcontains(WebDriver driver,String url) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(IpathConstant.explicitlywaitduration));
		wait.until(ExpectedConditions.urlContains(url));
	}
	/**
	 * this method is used for ignoring the nosuchelementException
	 * @param driver
	 * @param element
	 */
	public void ignorenosuchElementExcep(WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(IpathConstant.explicitlywaitduration));
		wait.ignoring(NoSuchElementException.class);
	}
	public void selectEleInDropDown(WebElement element,int index) {
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	public void selectEleInDropDown(WebElement element,String value) {
		Select s=new Select(element);
		s.selectByValue(value);
	}
	public void selectEleInDropDown(String visibletext,WebElement element){
		Select s=new Select(element);
		s.selectByVisibleText(visibletext);
	}
	public String getAllOptionsFromDropDownWrapped(WebElement element) {
		Select s=new Select(element);
		String alloptions = s.getWrappedElement().getText();
		return alloptions;
	}
	
	public List<String> getAllOptionsFromDropDown(WebElement element) {
		Select s=new Select(element);
		List<WebElement> alloptions = s.getOptions();
		List<String>alloptionss=new ArrayList();
		for(int i=0;i<alloptions.size();i++) {
			String data=alloptions.get(i).getText();
			alloptionss.add(i,data);
		}
		return alloptionss;
	}
	public void mouseActionsElement(WebDriver driver,WebElement element,String whatMaction) {
		Actions ma=new Actions(driver);
		if(whatMaction.equalsIgnoreCase("mousehover")) {
		ma.moveToElement(element).perform();
		}
		else if(whatMaction.equalsIgnoreCase("contantClick")) {
		ma.contextClick(element).perform();	
		}
		else if(whatMaction.equalsIgnoreCase("doubleclick")) {
			ma.doubleClick(element).perform();
		}
		else if(whatMaction.equalsIgnoreCase("Click and hold")) {
			ma.clickAndHold(element);
		}
	}
	public void mouseDragandDrop(WebDriver driver,WebElement src,WebElement desti) {
		Actions ma=new Actions(driver);
		ma.dragAndDrop(src, desti);
	}
	public void switchFrameInd(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	public void switchFrameWebEle(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
	}
	public void switchFrameString(WebDriver driver,String attribute) {
		driver.switchTo().frame(attribute);
	}
	public void switchFrameTODefault(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	public void switchFrameToParent(WebDriver driver) {
		driver.switchTo().parentFrame();
	}
	public void switchToAlertPopupAndAccept(WebDriver driver,String text) {
		Alert alt=driver.switchTo().alert();
		if(alt.getText().trim().equalsIgnoreCase(text.trim())){
			System.out.println("alert is present and handled");
		}
		else {
			System.out.println("alert is not present ");
		}
		alt.accept();	
	}
	public void switchToAlertPopupAndDismiss(WebDriver driver,String text) {
		Alert alt=driver.switchTo().alert();
		if(alt.getText().trim().equalsIgnoreCase(text.trim())){
			System.out.println("alert is present and dismissed");
		}
		else {
			System.out.println("alert is not present ");
		}
		alt.dismiss();	
	}
	
	public void fileUploadpopup(WebElement element,String path) {
		element.sendKeys(path);
	}
	/**
	 * this method is example for fluent wait also very imp..
	 * @param duration
	 * @param element
	 * @param pollingtime
	 */
	public void customeWait(int duration,WebElement element,long pollingtime) {
		int count=0;
		while(count<duration) {
			 try {
				 element.click();
				 break;
			 }
			 catch(Exception e){
				 try {
					 Thread.sleep(pollingtime);
				 }
				 catch(InterruptedException e1) {
					 e1.printStackTrace();
				 }
				 count++;
			 }
		}	
	}
	
	public String takeScreenShot(WebDriver driver,String screenshotname) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		LocalDateTime local=LocalDateTime.now();
		String dateTime=local.toString().replace(" ","_").replace(":","-");//*******************************************
		File destination=new File("./screenShots/"+screenshotname+dateTime+".png");
		FileUtils.copyFile(src, destination);
		return screenshotname;
		}
	public void switchwindow(WebDriver driver,String title) {
		Set<String> allAddress = driver.getWindowHandles();
		Iterator<String> cursor=allAddress.iterator();
		while(cursor.hasNext()==true) {
			driver.switchTo().window(cursor.next());
			String text=driver.getTitle();
			if(text.contains(title)) {
				break;
			}
		}
	}
	
	public void switchwindowurl(WebDriver driver,String url) {
		Set<String> allAdd = driver.getWindowHandles();
		for(String i : allAdd) {
			driver.switchTo().window(i);
			String text=driver.getCurrentUrl();
			if(text.contains(url)) {
				break;
			}
		}	
	}
	public void disableNotifications() {
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disable-notifications");
	}
	public void waitTillElementToBeClickable(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(IpathConstant.explicitlywaitduration));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitTillPageGetLoad(WebDriver driver) {
		//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(IpathConstant.explicitlywaitduration));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(IpathConstant.implicitlywaitduration));
	}
	public void waitTillEleInvisible(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(IpathConstant.explicitlywaitduration));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
}
