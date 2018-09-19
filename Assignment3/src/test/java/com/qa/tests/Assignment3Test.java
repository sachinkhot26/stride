package com.qa.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.page.Assignment3Page;


public class Assignment3Test extends TestBase {
	Assignment3Page page;
	public Assignment3Test(){
		super();
	}
	
	@BeforeMethod
	
	public void setUp(){
		
		initialization();
		
	    page=new Assignment3Page();
	}
	
	@Test(priority=1)
	public void keywordIdentifier() throws InterruptedException {
		
		page.keywordIdentify();
	}
	
	@Test(priority=2)
	public void sentimentAnalyzer() throws InterruptedException {
		
		page.sentimentAnalyze();
	}
	
	
	@Test(priority=3)
	public void summaryAnalyzer() throws InterruptedException {
		
		page.textSummerization();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
