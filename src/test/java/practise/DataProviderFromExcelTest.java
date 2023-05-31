package practise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.hssf.extractor.ExcelExtractor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sms.genericutility.IpathConstant;

public class DataProviderFromExcelTest {
 
	@Test(dataProvider = "data")
	public void getData(String src,String des,String price) {
		System.out.println(src+"\t"+"\t"+des+"\t"+price);
	}
	
	
	@DataProvider
	public Object[][] data() throws Throwable {
		FileInputStream fis=new FileInputStream(IpathConstant.Excelfilepath);
		Workbook wb = WorkbookFactory.create(fis);
		int lastrow = wb.getSheet("DataProvider").getLastRowNum()+1;
		int lastcell = wb.getSheet("DataProvider").getRow(0).getLastCellNum();
		DataFormatter df=new DataFormatter();
		Object[][] tarr=new Object[lastrow][lastcell];
		for(int i=0;i<lastrow;i++) {
		    	    for(int j=0;j<lastcell;j++) {
		    	    	 Cell cell = wb.getSheet("DataProvider").getRow(i).getCell(j);
		    	    	 String data = df.formatCellValue(cell);
		    	    	 tarr[i][j]=data;
		    	    }
		     }
		return tarr;
		
	}
}
