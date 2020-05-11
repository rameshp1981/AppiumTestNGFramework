package com.demo.pages;

import com.Base.BaseTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SearchResultsPage extends BaseTest {
	@AndroidFindBy(xpath="//android.widget.TextView[containg(text(),'jobs']")
	private MobileElement resultTotal;
	@AndroidFindBy(xpath="//android.widget.Buton[@resource-id='fab']")
	private MobileElement saveSearchButton;
	@AndroidFindBy(xpath="//android.widget.Buton[@resource-id='btn_save']")
	private MobileElement savePopupButton;
	@AndroidFindBy(xpath="//android.widget.ImageButton[@content-desc='Navigate up']")
	private MobileElement backButton;
	public void clickSaveSearchButton()
	{
		clickElement(saveSearchButton);

	}
	
	public void clickSavePopupButton()
	{
		clickElement(saveSearchButton);

	}
	public SearchPage clickBackButton()
	{
		clickElement(backButton);
		return new SearchPage();
	}

}
