package practise;

import java.util.Date;

public class SysDate {

	public static void main(String[] args) {
         Date date=new Date();
         System.out.println(date);
         String words[]=date.toString().split(" ");
     String  day=words[0],mon=words[1],dat=words[2],year=words[5];
      String stdate=day+" "+mon+" "+dat+" "+year;
         System.out.println(stdate);  
         
         
  int rdat=Integer.parseInt(dat)+7;
 if(rdat>23)
	  rdat=5;
          int ryear=2023;
         String returndate =rdat+" "+ryear;
         
         System.out.println(rdat);
        System.out.println(returndate);
          
	}

}
