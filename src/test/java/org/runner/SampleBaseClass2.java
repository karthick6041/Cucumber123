package org.runner;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleBaseClass2 {
	public static  WebDriver driver;
	static Actions a;
	public static void browserLaunch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
public static void urlLaunch(String url) {
driver.get(url);
}
public static void titleGet() {
	String t = driver.getTitle();
System.out.println(t);

}
public static void maxWindow() {
	driver.manage().window().maximize();

}
public static void fillTxt(WebElement ele,String val) {
	ele.sendKeys(val);

}
public static void btnClick(WebElement btn) {
btn.click();


}
public static void startTime() {
	Date d = new Date();
	System.out.println(d);
}
public static void endTime() {
	Date d = new Date();
	System.out.println(d);
}
public static void clkDouble(WebElement p) {
	a=new Actions(driver);
	a.doubleClick(p).perform();
	a.contextClick(p).perform();
	
     

}
public static String getData(int rowNumber,int cellNumber) throws IOException {
	File f = new File("C:\\Users\\KARTHICK\\eclipse-workspace\\Project1\\testdata\\PBI-1_Test Cases_v1.0.xlsx");
	FileInputStream fl = new FileInputStream(f);
    Workbook w = new XSSFWorkbook(fl);
    Sheet sh = w.getSheet("PBI-1");
    Row ro = sh.getRow(rowNumber);
    Cell cl = ro.getCell(cellNumber);
  
		int type = cl.getCellType();
		String s = "" ;
		if (type==1) {
			 s = cl.getStringCellValue();

		}
		else if (type==0) {
		if (DateUtil.isCellDateFormatted(cl)) {
			Date d = cl.getDateCellValue();
			SimpleDateFormat date = new SimpleDateFormat("dd mmm YYYY z");
			s = date.format(d);
		
		}
		else {
		double ncv = cl.getNumericCellValue();
		long l = (long)ncv;
		s = String.valueOf(l);
		
		}
			
		}
		return s;
		
		} 
		
    }
    
