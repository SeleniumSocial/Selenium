package com.mavSocial.LoginPage;

import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.mavSocial.testBase.TestBase;
import com.mavSocial.uiActions.LoginPage;
import com.relevantcodes.extentreports.LogStatus;

public class TC001_LoginWithValidCredentials extends TestBase 
{
	
	LoginPage lp;
	public static final Logger log=Logger.getLogger(TC001_LoginWithValidCredentials.class.getName());
	 SoftAssert softAssertion= new SoftAssert();
	@BeforeMethod
	  public void setup(Method result) throws IOException
	  {
		  test = extent.startTest(result.getName());
		  test.log(LogStatus.INFO, result.getName() + " test Started");
		  init();
	  }
	
	@Test (priority = 3)
	  public void verify_login_with_valid_credentials()
	  { 
		  log.info("<===========Starting Verify Login With Valid Credentials Test===========> ");
		  lp=new LoginPage(driver);
		  lp.login_to_application(OR.getProperty("username"),OR.getProperty("password"));
		  wait_until_url_contains("home");
		  softAssertion.assertEquals(driver.getCurrentUrl(), "https://app.maventus.com/home/home");
		  log.info("<===========Ended Verify Login With Valid Credentials Test===========> ");
	  }
	
	

	@AfterMethod
	public void afterMethod(ITestResult result) {
    get_result(result);
    closeBrowser();
    
}

    /* @AfterClass(alwaysRun = true)
	public void endTest() {
		closeBrowser();
}*/

}
