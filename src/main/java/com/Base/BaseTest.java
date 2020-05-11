package com.Base;

import org.testng.annotations.Test;

import com.demo.utils.TestUtils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class BaseTest {
	protected static AppiumDriver driver;
	protected static Properties props;
	protected static String dateTime;
	InputStream inputstream;
	TestUtils utils;
	public static Logger log =Logger.getLogger("devpinoyLogger");

	public BaseTest() 
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	

  
  @Parameters({"platformName","platformVersion","deviceName"})
  @BeforeTest
  public void beforeTest(String platformName,String platformVersion,String deviceName) {
		utils = new TestUtils();
	  dateTime=utils.getDateTime();
	  
	  try {
				props =new Properties();
				String propfilename ="config.properties";
				inputstream=getClass().getClassLoader().getResourceAsStream(propfilename);
				props.load(inputstream);
			  DesiredCapabilities cap = new DesiredCapabilities();
			  cap.setCapability("platformName", platformName);
			  cap.setCapability("platformVersion", platformVersion);
			  cap.setCapability("deviceName", deviceName);
			  cap.setCapability("automationName", props.getProperty("androidAutomationName"));
			  cap.setCapability("appPackage", props.getProperty("androidAppPackage"));
			  cap.setCapability("appActivity", props.getProperty("androidAppActivity"));
			  cap.setCapability("avd", deviceName);
			  
			  String appurl=getClass().getResource(props.getProperty("androidApp")).getFile();
			  System.out.println("app url" + appurl);
			  cap.setCapability("app", appurl);
			  URL url = new URL(props.getProperty("AppiumURL"));
			  
			  driver = new AndroidDriver(url,cap);
			  String sessionId = driver.getSessionId().toString();
			  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			  log.debug("Appium session successfully created");
			}
			catch(Exception e)
			{
				e.printStackTrace();
				log.debug("Appium session creation failed");
			}
  }
  public AppiumDriver getDriver()
  {
	  return driver;
  }
  
  public String getDateTime()
  {
	  return dateTime;
  }
  public void waitforVisibility(MobileElement e) {
	  WebDriverWait wait=new WebDriverWait(driver,TestUtils.WAIT);
	  wait.until(ExpectedConditions.visibilityOf(e)); 
  }
  public void clickElement(MobileElement e) {
	  waitforVisibility(e);
	  e.click();
	  
  }
  
  public void sendKeys(MobileElement e,String txt) {
	  waitforVisibility(e);
	  e.sendKeys(txt);
	  
  }
  public void clearText(MobileElement e)
  {
	  waitforVisibility(e);
	  e.clear();
  }
 public String getAttribute(MobileElement e,String attribute)
 {
	  waitforVisibility(e);
	 return e.getAttribute(attribute);
 }
  
  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
