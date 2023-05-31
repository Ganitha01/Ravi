package practise;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
@DataProvider
	public Object[][] data() {
		//step1: we have to create the twodimentionsal arr & store the data
		Object[][] tarr=new Object[3][3];
		//provide the data
		tarr[0][0]="Bangalore";
		tarr[0][1]="mysore";
		tarr[0][2]=200;
	
		tarr[1][0]="tirupathi";
		tarr[1][1]="bangalore";
		tarr[1][2]=500;

		tarr[2][0]="tirupathi";
		tarr[2][1]="hyderabad";
		tarr[2][2]=1000;
		return tarr;
	}

	@Test(dataProvider = "data")
	public void getData(String src,String des,int price) {
		System.out.println("from address  ="+src+"\t"+"to address  ="+des+"\t"+"price  ="+price);
	}
}
