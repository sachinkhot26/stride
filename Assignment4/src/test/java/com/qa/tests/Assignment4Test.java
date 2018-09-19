package com.qa.tests;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;

import com.qa.page.Assignment4Page;


public class Assignment4Test extends TestBase {
	Assignment4Page page;
	public Assignment4Test(){
		super();
	}
	
	@BeforeMethod
	
	public void setUp(){
		
		initialization();
		
	    page=new Assignment4Page();
	}
	
	@Test(priority=1)
	
	public void searchText() throws InterruptedException, IOException {
		
		excelReader();
		for(int i=0;i<lst.size();i++) {
		page.searchText(lst.get(i));
		}
		
	}

	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}
}
