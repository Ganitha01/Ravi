package practise;

import org.testng.annotations.DataProvider;

import com.sms.genericutility.JavaUtility;

public class DataProviderTest1 {

	
	@DataProvider
	public Object[][] info() {
		//step create the twodimentionalArray
		Object[][] tarr=new Object[4][4];
		
		JavaUtility ju=new JavaUtility();
		for(int i=0;i<4;i++) {
			 for(int j=0;j<4;j++) {
				 int ran=ju.rannumber();
				   tarr[i][j]="Bangalore"+ran;
			    }
		    }
		return tarr;
	}	
}
