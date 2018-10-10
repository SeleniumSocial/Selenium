package com.mavSocial.LoginPage;

import java.io.IOException;
import java.lang.reflect.Method;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.mavSocial.testBase.TestBase;
import com.mavSocial.uiActions.ChangePassword;
import com.mavSocial.uiActions.LoginPage;
import com.relevantcodes.extentreports.LogStatus;
import jxl.read.biff.BiffException;

public class TC004_ChangePasswordWithWrongCredentials extends TestBase 
{
	
	ChangePassword cp;
	public static final Logger log=Logger.getLogger(TC002_VerifyLoginWithInvalidCredentials.class.getName());
	SoftAssert softAssertion= new SoftAssert();
	
	 @BeforeMethod
	  public void setup(Method result) throws IOException
	  {
		  test = extent.startTest(result.getName());
		  test.log(LogStatus.INFO, result.getName() + " test Started");
		  
	  }
	
	@DataProvider(name="loginData")
	public String[][] getTestData() throws IOException, BiffException
	{
		init();
		String[][] testRecords = getData("TestData1.xls", "Sheet1");
		return testRecords;
	}
	
	@Test (dataProvider="loginData")
	
	public void verify_change_password_with_wrong_credentials(String oldpswd, String newpswd, String confmpswd) throws IOException, InterruptedException
	{
		
		  log.info("<===========Starting Verify Logging With Invalid Credentials Test===========> ");
		  cp=new ChangePassword(driver);
		  //cp.change_password(oldpswd, newpswd, confmpswd);
		  softAssertion.assertEquals(driver.getCurrentUrl(), "https://app.maventus.com/home/home");
		  log.info("<===========Ended Verify Login With Invalid Credentials Test===========> ");
		  Thread.sleep(2000);
		  driver.navigate().refresh();
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws InterruptedException {
		get_result(result);
    
}
	@AfterTest
	public void driverClose() throws InterruptedException {
		driver.close();
	    
	}
	
}


