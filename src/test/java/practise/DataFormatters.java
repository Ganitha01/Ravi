package practise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataFormatters {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
    FileInputStream fis=new FileInputStream("./src/test/resources/Vtigerlogindata.xlsx");
       Workbook wb = WorkbookFactory.create(fis);
       Random ran=new Random();
       int rannum=ran.nextInt(10);
       Sheet sheet = wb.createSheet("Ravi"+rannum);
       sheet.createRow(1).createCell(1).setCellValue(89);
       FileOutputStream fos=new FileOutputStream("./src/test/resources/Vtigerlogindata.xlsx");
        wb.write(fos);
        //step1: fetch the cell location
        Cell dat = sheet.getRow(1).getCell(1);
        //step2: create the obj for dataformatters from apachi poi package.
       DataFormatter formater=new DataFormatter();//apachi poi package
       //step3: call one method formatecellvalue it will take para as a cell & store that & print it.
         String data=formater.formatCellValue(dat);
   System.out.println(data);
        wb.close();
	}

}
