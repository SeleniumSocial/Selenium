package TestCases;

import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import BusinessFunctions.TestBase;
import UiActions.TwitterDmOpr;
import UiActions.amazonopr;
import jxl.read.biff.BiffException;

public class TwitterDMinitiation  extends TestBase
{ 
	TwitterDmOpr Dm;
	public static final Logger log=Logger.getLogger(TwitterDMinitiation.class.getName());
		
		@BeforeMethod
		  public void openbrowser(Method result) throws IOException
		  {
			  test = extent.startTest(result.getName());
			  test.log(LogStatus.INFO, result.getName() + " test Started");
			  init();
			  wait_for_page_load(5000);
		  }
		@DataProvider(name="loginData")
		public String[][] getTestData() throws IOException, BiffException
		{
			String[][] testRecords = getData("TestData.xls", "Sheet2");
			return testRecords;
		}
		
		@Test (dataProvider="loginData")
		public void amezonoperations(String username, String password) throws Exception 
		  { 
			  Dm=new TwitterDmOpr(driver);
			  Thread.sleep(3000);
			  log.info("<===========Starting Twitter DM  operarions===========> ");
			  
			  Dm.TwitterDmoperatopns(username, password);
			  log.info("<=========== Twitter DM  operarions Ended ===========> ");
		  }
		
		@AfterMethod
		public void browserclose()
		{
			closeBrowser();
		}
}
