package com.qa.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.base.TestBase;

public class Assignment3Page extends TestBase {

	@FindBy(xpath="//label[contains(text(),'Keyword Identifier')]")
	WebElement keywordIdentifier;
	
	@FindBy(id="text-identify")
	WebElement keywordTextArea;
	
	@FindBy(id="analyze-identify")
	WebElement keywordAnalyze;
	
	@FindBy(id="wikifier")
	WebElement keywordOutput;
	
	@FindBy(id="text-sentiment")
	WebElement sentimantTextArea;
	
	@FindBy(id="analyze-sentiment")
	WebElement sentimentAnalyze;
	
	@FindBy(xpath="//label[contains(text(),'Sentiment Analysis')]")
	WebElement sentimentAnalysis;
	
	@FindBy(xpath="//span[@class='avg']")
	WebElement avg;
	
	@FindBy(xpath="//span[@class='num-sc']")
	WebElement numAvg;
	
	@FindBy(xpath="//label[contains(text(),'Text Summarization')]")
	WebElement textSummarization;
	
	@FindBy(id="text-summary")
	WebElement summaryTextArea;
	
	@FindBy(id="analyze-summary")
	WebElement summaryAnalyze;
	
	@FindBy(id="sent-count")
	WebElement sentences;
	
	@FindBy(id="word-count")
	WebElement words;
	
	public Assignment3Page(){
		PageFactory.initElements(driver,this);
	}
	
	public void keywordIdentify() throws InterruptedException {
		keywordIdentifier.click();
		Thread.sleep(3000);
		keywordTextArea.sendKeys(prop.getProperty("keywordIdentifierText"));
		Thread.sleep(3000);
		keywordAnalyze.click();
		Thread.sleep(3000);
		String actualText=keywordOutput.getText();
		System.out.println("actualText====="+actualText);
		Assert.assertEquals(actualText, prop.getProperty("keywordIdentifierText"), "both texts not matching");
	}
	
	public void sentimentAnalyze() throws InterruptedException {
		
		//sentimentAnalysis.click();
		Thread.sleep(3000);
		sentimantTextArea.sendKeys(prop.getProperty("sentimentAnalyzerText"));
		Thread.sleep(3000);
		sentimentAnalyze.click();
		Thread.sleep(5000);
		
		String num= numAvg.getText();
		String average=avg.getText();
		String actualAverage=num+average;
		System.out.println("actualAverage====="+actualAverage);
		Assert.assertEquals(actualAverage, prop.getProperty("average"));
	}
	
	public void textSummerization() throws InterruptedException {
		
		textSummarization.click();
		Thread.sleep(3000);
		summaryTextArea.sendKeys(prop.getProperty("summaryText"));
		Thread.sleep(3000);
		summaryAnalyze.click();
		Thread.sleep(3000);
		String actualSentenceCount=sentences.getText();
		System.out.println("actualSentenceCount====="+actualSentenceCount);
		Assert.assertEquals(actualSentenceCount,prop.getProperty("sentences"), "sentence count not matching");
	}
}
