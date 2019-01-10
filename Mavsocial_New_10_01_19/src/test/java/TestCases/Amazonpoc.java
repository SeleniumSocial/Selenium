package TestCases;

import java.io.IOException;
import java.lang.reflect.Method;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.*;
import com.relevantcodes.extentreports.LogStatus;
import BusinessFunctions.TestBase;
import UiActions.amazonopr;
import jxl.read.biff.BiffException;

public class Amazonpoc extends TestBase
{
	amazonopr ap;
public static final Logger log=Logger.getLogger(Amazonpoc.class.getName());
	
	@BeforeMethod
	  public void openbrowser(Method result) throws IOException
	  {
		  test = extent.startTest(result.getName());
		  test.log(LogStatus.INFO, result.getName() + " test Started");
		  init();
	  }
	@DataProvider(name="loginData")
	public String[][] getTestData() throws IOException, BiffException
	{
		String[][] testRecords = getData("TestData.xls", "Sheet1");
		return testRecords;
	}
	
	@Test (dataProvider="loginData")
	  public void amezonoprations(String username, String password) throws Exception 
	  { 
		  ap=new amazonopr(driver);
		  Thread.sleep(3000);
		  log.info("<===========Starting amazon operarions===========> ");
		  
		  ap.amezonoperations(username, password);
		  log.info("<===========Ended amazon operations===========> ");
	  }
	
	@AfterMethod
	public void browserclose()
	{
		closeBrowser();
	}
	
}
