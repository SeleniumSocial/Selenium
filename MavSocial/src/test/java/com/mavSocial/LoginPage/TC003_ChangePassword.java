package com.mavSocial.LoginPage;

import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mavSocial.testBase.TestBase;
import com.mavSocial.uiActions.ChangePassword;
import com.mavSocial.uiActions.LoginPage;
import com.relevantcodes.extentreports.LogStatus;

public class TC003_ChangePassword extends TestBase{
	LoginPage lp;
	ChangePassword cp;
	public static final Logger log=Logger.getLogger(TC001_LoginWithValidCredentials.class.getName());
	
	@BeforeMethod
	  public void setup(Method result) throws IOException
	  {
		  test = extent.startTest(result.getName());
		  test.log(LogStatus.INFO, result.getName() + " test Started");
		  init();
	  }
	
	
	@Test (priority = 2)
	  public void verify_change_password() throws InterruptedException
	  { 
		lp=new LoginPage(driver);
		  lp.login_to_application(OR.getProperty("username"),OR.getProperty("password"));
		  wait_until_url_contains("home");
		  Thread.sleep(3000);
		  log.info("<===========Starting Forgot Password funcitonality===========> ");
		  cp=new ChangePassword(driver);
		  cp.change_password();
		  Assert.assertEquals(cp.verify_changepassword(), "https://app.maventus.com/account/manage-profile");
		  log.info("<===========Ended Verify Password Changed===========> ");
	  }
	
}
