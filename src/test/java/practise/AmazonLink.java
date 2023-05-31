package practise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonLink {
//ravichandrababu
	//ravichandrababu
	//test resources hello
	//bye bye bye
	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
     WebDriverManager.chromedriver().setup();
     WebDriver driver=new ChromeDriver();
     driver.get("https://www.amazon.in/");
     Thread.sleep(2000);
     List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
          
     //excel storeage
     FileInputStream fis=new FileInputStream("./src/test/resources/Vtigerlogindata.xlsx");
     Workbook wb = WorkbookFactory.create(fis);
     Sheet sheet = wb.getSheet("Sheet1");
        for(int i=0;i<allLinks.size();i++) {
        	 String links=allLinks.get(i).getAttribute("href");
        	 if(links==null) {
        		 links="something";
        		 sheet.createRow(i).createCell(1).setCellValue(links);
        	 }else
         sheet.createRow(i).createCell(1).setCellValue(links);
        }
        FileOutputStream fos=new FileOutputStream("./src/test/resources/Vtigerlogindata.xlsx");
        wb.write(fos);
        wb.close();
        //excel fetch
        int lastrnum=sheet.getLastRowNum();
            for(int i=0;i<=lastrnum;i++) {
            	String data=sheet.getRow(i).getCell(1).getStringCellValue();
            	System.out.println(data);
            }
            driver.close();
            
	}

}
