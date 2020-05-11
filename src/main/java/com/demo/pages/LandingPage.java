package com.demo.pages;

import com.Base.BaseTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LandingPage extends BaseTest{


	@AndroidFindBy(xpath="//android.widget.TextView[@text='Welcome to SEEK!']")
	private MobileElement welcomeText;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Recommended for you']")
	private MobileElement recommendStaticText;
	@AndroidFindBy(xpath="//android.widget.FrameLayout[@index='2']/android.view.ViewGroup[@index='0']/android.widget.FrameLayout[@index='1']/android.widget.ImageView[@index='0']")
	private MobileElement SearchIconText;
	
	public String getWelcomeTxt()
	{
		return getAttribute(welcomeText,"text");
				
	}
	
	public String getRecommendTxt()
	{
		return getAttribute(recommendStaticText,"text");
				
	}
	
	public SearchPage clickSearchIcon()
	{
		clickElement(SearchIconText);
		return new SearchPage();
	}

	
}
