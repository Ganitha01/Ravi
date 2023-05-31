package com.sms.genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ExcelUtility {

	/**
	 * this method is used to fetch the data from the Excel file..
	 * @param sheetname
	 * @param rownum
	 * @param cellnum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readExceldata(String sheetname,int rownum,int cellnum) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(IpathConstant.Excelfilepath);
		Workbook wb = WorkbookFactory.create(fis);
		Cell cellAdd= wb.getSheet(sheetname).getRow(rownum).getCell(cellnum);
		DataFormatter df=new DataFormatter();
		String value = df.formatCellValue(cellAdd);
		return value;
	}
	/**
	 * this method is used to Write the data to the Excel file..
	 * @param sheetname
	 * @param rownum
	 * @param cellnum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeExceldataCreate(String sheetname,int rownum,int cellnum,String cellvalue) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(IpathConstant.Excelfilepath);
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetname).createRow(rownum).createCell(cellnum).setCellValue(cellvalue);
		FileOutputStream fos=new FileOutputStream(IpathConstant.Excelfilepath);
		wb.write(fos);
		wb.close();
		
	}
	public void writeExceldata(String sheetname,int rownum,int cellnum,String cellvalue) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(IpathConstant.Excelfilepath);
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetname).getRow(rownum).getCell(cellnum).setCellValue(cellvalue);
		FileOutputStream fos=new FileOutputStream(IpathConstant.Excelfilepath);
		wb.write(fos);
		wb.close();
		
	}
	/**
	 * this method is used to return the lastRownum
	 * @param sheetname
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getLastRownumofExcel(String sheetname) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(IpathConstant.Excelfilepath);
		Workbook wb = WorkbookFactory.create(fis);	
		int lastrow = wb.getSheet(sheetname).getLastRowNum();
		return lastrow;
	}
	/**
	 * this method is used to return the last cellnum
	 * @param sheetname
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getLastCellnumofExcel(String sheetname,int rownum) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(IpathConstant.Excelfilepath);
		Workbook wb = WorkbookFactory.create(fis);	
		int lastcell = wb.getSheet(sheetname).getRow(rownum).getLastCellNum();
		return lastcell;
	}
	@DataProvider
	public Object[][] data(String sheetname) throws Throwable, IOException {
		FileInputStream fis=new FileInputStream(IpathConstant.Excelfilepath);
		Workbook wb = WorkbookFactory.create(fis);
		int lastrow = wb.getSheet(sheetname).getLastRowNum()+1;
		int lastcell = wb.getSheet(sheetname).getRow(0).getLastCellNum();
		DataFormatter df=new DataFormatter();
		Object[][] tarr=new Object[lastrow][lastcell];
		for(int i=0;i<lastrow;i++) {
		    	    for(int j=0;j<lastcell;j++) {
		    	    	 Cell cell = wb.getSheet(sheetname).getRow(i).getCell(j);
		    	    	 String data = df.formatCellValue(cell);
		    	    	 tarr[i][j]=data;
		    	    }
		     }
		return tarr;
	}
	
	public HashMap<String, String> getMapData(String sheetname) throws Throwable {
		FileInputStream fis=new FileInputStream(IpathConstant.Excelfilepath);
		Workbook wb = WorkbookFactory.create(fis);
		 Sheet shee = wb.getSheet(sheetname);
		 int lastrow=shee.getLastRowNum();
		//DataFormatter df=new DataFormatter();
		HashMap<String, String> hm=new HashMap<String, String>();
		for(int i=0;i<=lastrow;i++) {
			String key=wb.getSheet(sheetname).getRow(i).getCell(0).getStringCellValue();
			String value=wb.getSheet(sheetname).getRow(i).getCell(1).getStringCellValue();
			   hm.put(key, value);
		}
		return hm;
	}
	
}
