package com.sms.genericutility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyserImplementation implements IRetryAnalyzer{

    int counter=0;
    int retrylimit=2;
    
	public boolean retry(ITestResult result) {

        while(counter<retrylimit) {
        	counter++;
        	return true;
        }
		
		return false;
	}

}
