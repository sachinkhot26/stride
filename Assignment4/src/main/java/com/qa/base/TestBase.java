package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static FileInputStream ExcelFile;
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;
	
	public static List<String>lst=new ArrayList<String>();
	
	public TestBase(){
		
		try{
			prop=new Properties();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/qa/config/configue.properties");
			prop.load(fis);
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
	}
	


	public static void initialization(){
	
	String browserName = prop.getProperty("browser");
	
	if(browserName.equalsIgnoreCase("chrome")){
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/drivers/chromedriver");
		driver=new ChromeDriver();
		
		
	}
	else if(browserName.equalsIgnoreCase("firefox")){
		
		System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/drivers/geckodriver");
		driver=new FirefoxDriver();
	}
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	
	driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	
	driver.get(prop.getProperty("url"));
	
	
	}
	
	//@Test
	public static void excelReader() throws IOException {
		
		ExcelFile = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/qa/data/testdata.xlsx");
		ExcelWBook = new XSSFWorkbook(ExcelFile);
		ExcelWSheet = ExcelWBook.getSheet("Sheet1");
		int totalRows=ExcelWSheet.getLastRowNum()-ExcelWSheet.getFirstRowNum();
		int totalCols=ExcelWSheet.getRow(0).getLastCellNum();
//	    System.out.println("rows=="+totalRows);
//		System.out.println("colss=="+totalCols);
	
		for(int i=0;i<totalRows;i++) {
			for(int j=0;j<totalCols;j++) {
				
				lst.add(ExcelWSheet.getRow(i+1).getCell(j).getStringCellValue());
			
			}
		}
		
	System.out.println(lst);
	
}
	
}
