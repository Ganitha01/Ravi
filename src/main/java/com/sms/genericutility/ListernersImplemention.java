package com.sms.genericutility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListernersImplemention implements ITestListener{

	public void onTestStart(ITestResult result) {

	}

	public void onTestSuccess(ITestResult result) {

	}

	public void onTestFailure(ITestResult result) {

		String testname=result.getMethod().getMethodName();
		System.out.println("============I am Listeneing===========");
		
		TakesScreenshot ts=(TakesScreenshot)BaseClass.sdriver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		LocalDateTime localtime = LocalDateTime.now();
		String time=localtime.toString().replace(" ","_").replace(":","_");
		File destination=new File("./screenShots/"+testname+time+".png");
       try {
		FileUtils.copyFile(src, destination);
	} catch (IOException e) {
	}
		
	}

	public void onTestSkipped(ITestResult result) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {

	}

}
