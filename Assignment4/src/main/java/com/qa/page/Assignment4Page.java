package com.qa.page;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.base.TestBase;

public class Assignment4Page extends TestBase {

	@FindBy(id="phrase")
	WebElement searchField;
	
	@FindBy(xpath="//form[@dir='ltr']/input")
	WebElement searchButton;
	
	@FindBy(xpath="//span[contains(text(),' Information, Formalities, Files (s)')]")
	WebElement selectTab;
	
	public Assignment4Page(){
		PageFactory.initElements(driver,this);
	}
	
	public void searchText(String text) throws InterruptedException, IOException {
		
		
			searchField.sendKeys(text);
			Thread.sleep(2000);
			searchButton.click();
			Thread.sleep(3000);
			selectTab.click();
			
			List<WebElement>lst=driver.findElements(By.xpath("//div[@class='ellipsisText']"));
			for(int i=0;i<lst.size();i++) {
				System.out.println(lst.get(i).getText());
			}
		
	}

}