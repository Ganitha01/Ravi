package practise;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sms.genericutility.ExcelUtility;

public class DataProviderExcelUtilityTest {

	@Test
	public void getData() throws IOException, Throwable {
		ExcelUtility ex=new ExcelUtility();
		Object[][] tarr = ex.data("DataProvider");
	 
		
	}
}
