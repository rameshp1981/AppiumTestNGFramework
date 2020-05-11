package com.qa.tests;

import org.testng.annotations.Test;

import com.Base.BaseTest;
import com.demo.pages.LandingPage;
import com.demo.pages.LoginPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class LoginTests extends BaseTest{
	LoginPage loginpage;
	LandingPage landingpage;
	InputStream datais;
	JSONObject loginusers;
	
  @BeforeClass
	  public void beforeClass() throws Exception {
	  try {
	  String dataFileName ="Data/TestData.json";
	  datais =getClass().getClassLoader().getResourceAsStream(dataFileName);
	  JSONTokener tokener = new JSONTokener(datais);
	  loginusers = new JSONObject(tokener);
	  log.debug("Data File Loaded");

	  }
	  catch(Exception e)
	  {
		  log.debug("JSON File loading failed");
		  e.printStackTrace();
		  throw e;
		  
	  }
	  finally {
		  if(datais!=null) {
			  datais.close();
		  }
	  }
	  }
  @AfterClass
	  public void afterClass() {
	  }
  
  @BeforeMethod
  public void beforeMethod(Method m) {
	  loginpage= new LoginPage();
	  System.out.println("\n"+"**********Starting test:"+m.getName()+"*********"+"\n");
	  
  }

  @AfterMethod
  public void afterMethod() {
  }

  
  
  @Test
  public void successfulUserloginTest() {
	  
	  loginpage.enterEmail(loginusers.getJSONObject("validData").getString("userName"));
	  loginpage.enterEmailPassword(loginusers.getJSONObject("validData").getString("password"));
	   landingpage = loginpage.clickLoginBtn();
	  String welcomeTxt = "Recommended for you";
	  String actualWelcomeTxt=landingpage.getRecommendTxt();
	  System.out.println(actualWelcomeTxt);
	  Assert.assertEquals(actualWelcomeTxt, welcomeTxt);
	  log.info("Login test is successfully completed and expected message in landing page is" +actualWelcomeTxt);	  
	  	  
	  
  }

}
