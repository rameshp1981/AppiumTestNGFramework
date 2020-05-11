package com.demo.pages;

import org.openqa.selenium.By;

import com.Base.BaseTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SearchPage extends BaseTest{

	@AndroidFindBy(xpath="//android.widget.FrameLayout[@index='0']/android.widget.LinearLayout[@index='0']/android.widget.FrameLayout[@index='0']/android.widget.LinearLayout[@index='0']/android.widget.FrameLayout[@index='0']/android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='0']/android.widget.FrameLayout[@index='0']/android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='0']/android.view.ViewGroup[@index='0']/android.widget.Button[@text='Clear all']")
	private MobileElement clearAllButton;
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Enter keywords']")
	private MobileElement keyWordsInput;
	@AndroidFindBy(xpath="//android.widget.EditText[@text='Enter keywords']")
	private MobileElement keyWordsEditInput;
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Enter suburb, city, or region']")
	private MobileElement locationInput;
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Any classification']")
	private MobileElement classificationInput;
	@AndroidFindBy(xpath="//android.widget.Button[@text='SEEK']")
	private MobileElement seekButton;
	@AndroidFindBy(xpath="//android.widget.Button[@text='Home']")
	private MobileElement homeButton;
	@AndroidFindBy(xpath="//androidx.recyclerview.widget.RecyclerView[@index='2']/android.widget.FrameLayout[@index='0']/android.view.ViewGroup[@index='0']/android.widget.TextView[@index='1']")
	private MobileElement keyWordSuggestion;

	public void clickClearAllButton()
	{
		clickElement(clearAllButton);
	}
	
	public void enterKeywordText(String text)
	{
		
		clickElement(keyWordsInput);
		clearText(keyWordsEditInput);
		sendKeys(keyWordsEditInput, text);
		
		
	}
	
	public void clickKeywordSuggestion()
	{
		clickElement(keyWordSuggestion);
	}
	public void enterLocationText(String text)
	{
		sendKeys(classificationInput, text);
		
	}
	
	
	public SearchResultsPage clickSeekButton()
	{
		clickElement(seekButton);
		return new SearchResultsPage();
		
	}
	
	
}
