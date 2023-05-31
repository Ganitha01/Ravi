package com.sms.genericutility;

import java.util.Date;
import java.util.Random;

import org.apache.poi.ss.usermodel.DataFormatter;

import com.google.common.collect.Table.Cell;

public class JavaUtility {

	/**
	 * this method is used to get the random number for concatination.
	 * @return
	 */
	public int rannumber() {
		Random ran=new Random();
		int rannum = ran.nextInt(10000);
		return rannum;
	}
	/**
	 * this method is used to get the system date 
	 * @param whichformate
	 * @return
	 */
	public String systemdate(String whichformate) {
		Date date=new Date();
		//System.out.println(date);
            String words[] = date.toString().split(" ");
         int month=date.getMonth()+1;
         String day=words[0];
         String mon=words[1];
         String dat=words[2];
         String year=words[5];
         String dateformate=year+" "+month+" "+dat;
         if(whichformate.equals("y/m/dat")) {
        	 return dateformate;
         }
         else if(whichformate.equals("y/m/dd/d")) {
        	 return dateformate=year+" "+mon+" "+day+" "+dat;
         }
         else if(whichformate.equals("dd/m/y")) {
        	 return dateformate=dat+" "+mon+" "+year;
         }
         else if(whichformate.equals("m/dd/y")) {
        	 return dateformate=mon+" "+day+" "+year;
         }
         return year;
	}
}
