package com.sms.genericutility;

import java.io.IOException;

public class Demo {

	public static void main(String[] args) throws IOException {

		JavaUtility ju=new JavaUtility();
String date=ju.systemdate("y/m/dat").replace(" ","-");
    System.out.println(date);
   
	
	}

}
