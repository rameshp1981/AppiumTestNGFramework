package com.demo.pages;

import org.openqa.selenium.By;

import com.Base.BaseTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPage extends BaseTest{

	@AndroidFindBy(xpath="//android.widget.EditText[@text='Email address']")
	private MobileElement userName;
	@AndroidFindBy(xpath="//android.widget.EditText[@text='Password']")
	private MobileElement userPassword;
	@AndroidFindBy(xpath="//android.widget.Button[@text='Sign in']")
	private MobileElement loginBtn;

	public LoginPage enterEmail(String uname)
	{
		sendKeys(userName,uname);
		log.debug("Email successfully Entered");
		return this;
	}
	public LoginPage enterEmailPassword(String upwd)
	{
		sendKeys(userPassword,upwd);
		log.debug("Password successfully Entered");

		return this;
	}
	
	
	public LandingPage clickLoginBtn()
	{
		clickElement(loginBtn);
		log.debug("Login button clicked");
		return new LandingPage();
	}
	
}
