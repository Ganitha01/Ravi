package practise;

import org.testng.annotations.Test;

public class DataProviderAnotherTest {

	
	@Test(dataProviderClass = DataProviderTest1.class ,dataProvider = "info")
	public void getData(String r,String a,String v,String i) {
		System.out.println(r+"\t"+a+"\t"+v+"\t"+i);
	}
}
