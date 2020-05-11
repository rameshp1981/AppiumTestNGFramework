package com.qa.tests;

import java.io.InputStream;
import java.lang.reflect.Method;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Base.BaseTest;
import com.demo.pages.LandingPage;
import com.demo.pages.LoginPage;
import com.demo.pages.SearchPage;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class SearchTests extends BaseTest{
	LoginPage loginpage;
	LandingPage landingpage;
	InputStream datais;
	JSONObject loginusers;
	SearchPage searchpage;
	
  @BeforeClass
	  public void beforeClass() throws Exception {
	  try {
	  String dataFileName ="Data/TestData.json";
	  datais =getClass().getClassLoader().getResourceAsStream(dataFileName);
	  JSONTokener tokener = new JSONTokener(datais);
	  loginusers = new JSONObject(tokener);
	  }catch(Exception e)
	  {
		  e.printStackTrace();
		  throw e;
	  }
	  finally {
		  if(datais!=null) {
			  datais.close();
		  }
	  }
	  	    
  }
  

  @BeforeMethod
  public void beforeMethod(Method m) {
	  landingpage= new LandingPage();
	  
	  System.out.println("\n"+"**********Starting test:"+m.getName()+"*********"+"\n");
	  
  }
  @Test
  public void navigateToSearchPage()
  {
	  searchpage=landingpage.clickSearchIcon();
	 searchpage.clickClearAllButton();
	  searchpage.enterKeywordText(loginusers.getJSONObject("searchData").getString("keyword"));
	  //((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));


	  searchpage.enterLocationText(loginusers.getJSONObject("searchData").getString("location"));
	 // ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
	  searchpage.clickSeekButton();
  }
	
}
