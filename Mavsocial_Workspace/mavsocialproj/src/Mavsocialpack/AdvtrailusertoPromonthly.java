package Mavsocialpack;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AdvtrailusertoPromonthly 
{
	WebDriver driver;
	SoftAssert softassert=new SoftAssert();
	@BeforeClass
	public void openbrowser() throws Exception 
	  {
		 System.setProperty("webdriver.chrome.driver", "I:\\hari\\Automation\\Workspaces\\Mavsocial_Workspace\\Lib\\chromedriver_win32\\chromedriver.exe");
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 Thread.sleep(5000);
		 //launch Dev.maventus.com
	     driver.get("https://dev.maventus.com");
	 	 //Enter user name 
		 driver.findElement(By.name("email")).sendKeys("haritest599@gmail.com");
		 System.out.println("user name entered");
		 //Enter password
		 driver.findElement(By.name("pwd")).sendKeys("social@123");
		 System.out.println("password entered");
		 //click on log in button
		 driver.findElement(By.xpath("//button[@type='submit']")).click();
		 System.out.println("Trail user logged in successfully");
		 //verify page title
		 softassert.assertEquals(driver.getTitle(), "Social Media and Content Management Software | MavSocial");
		 System.out.println("Page ttile verified");
	  }
	 @AfterClass
	 public void closebrowser()
		{
			driver.close();
		}
	 
	 @Test
	 public void advtrailusertoPromonthly() throws Exception
	 {
		//Validate the Trail period box on header.
		 Thread.sleep(5000);
		 WebElement trialperiod=driver.findElement(By.xpath("//div/ul/li[1]/span/p[1]/strong"));
		 softassert.assertEquals(trialperiod.getText(),"Trial period");
		 System.out.println("Trail period box displayed");
		 //Verify current plan in Profile section
		 Thread.sleep(4000);
		 Actions a=new Actions(driver);
		 a.moveToElement(driver.findElement(By.xpath("//a[@class='dropdown-toggle file-upload-bg user-default-padding']"))).click(driver.findElement(By.xpath("//*[@id=\"header_notification_bar\"]/li[1]/a"))).build().perform();
		 //Validate current plan -Advanced(trail).
		 WebElement currentplan=driver.findElement(By.xpath("//div[2]/div[3]/div/span/div[1]"));
		 //Read Property file
		 Properties obj = new Properties();					
		 FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\objects.properties");									
		 obj.load(objfile);
		 softassert.assertEquals(currentplan.getText(),"Current Plan - Advanced (Trial)");
		 System.out.println("User current plan is Advanced trail");
		 //Click on paynow button
		 driver.findElement(By.linkText("PAY NOW")).click();
		 Thread.sleep(4000);
		 //Check the page is navigated to advanced plan subscription page 
		 WebElement advplansub=driver.findElement(By.className("welcome_hedding"));
		 System.out.println(advplansub.getText());
		softassert.assertEquals(advplansub.getText(),"BUY ADVANCED PLAN SUBSCRIPTION");
		 System.out.println("Advanced Plan Subscription label displayed");
		 
		//Verify Upgrade to pro button is displayed or not
		 WebElement uptopro=driver.findElement(By.xpath(obj.getProperty("upgradetopro")));
		 softassert.assertEquals(uptopro.getText(),"Upgrade to PRO");
		 Thread.sleep(4000);
		 uptopro.click();
		 //Verify Pro plan subscription label is displayed or not
		 softassert.assertEquals(driver.findElement(By.xpath(obj.getProperty("proplansub"))).getText(),"PRO PLAN SUBSCRIPTION");
		 System.out.println("PRO PLAN SUBSCRIPTION label displayed successfully");
		//Verify Go back to advanced button is displayed or not
		 WebElement gobckadv=driver.findElement(By.xpath(obj.getProperty("upgradetopro")));
		 softassert.assertEquals(gobckadv.getText(),"Go back to Advanced Plan"); 
		 System.out.println("Go back to Advanced Plan button displayed successfully");
		 //Validate Start my Pro trail is displayed or not 
		 WebElement protrail=driver.findElement(By.xpath(obj.getProperty("statmyprotrail")));
		 softassert.assertEquals(protrail.getText(),"Start My PRO Trial");
		 System.out.println("Start My PRO Trial Button displayed successfully");
	     
		//Check Monthly toggle is enable or not
		 //check toggle button
		 Thread.sleep(4000);
		 WebElement togglemonthly=driver.findElement(By.xpath(obj.getProperty("togglem")));
		 Thread.sleep(3000);
		 //check toggle button is monthly or not
		 softassert.assertEquals(togglemonthly.getText(),"MONTHLY");
		 System.out.println("Now toggle button is in monthly payment mode");
		 //check monthly payment amount
		 WebElement monthlyamt=driver.findElement(By.xpath(obj.getProperty("mamt")));
		 softassert.assertEquals(monthlyamt.getText(),"$78");
		 System.out.println("Monthly payment amoumt $78 verified");
		//Scroll window 
		 for (int n=0;n<10;n++)
	     {
	        ((RemoteWebDriver) driver).executeScript("window.scrollBy(0,200)", "");
	        Thread.sleep(2000);
	     }
		 //click on radio button of credit cards 
		 driver.findElement(By.xpath(obj.getProperty("creditcard"))).click();
		 System.out.println("Credit cards radio button clicked successfully");
		 
		//Give credit card number
		 driver.findElement(By.id(obj.getProperty("creditcardnumber"))).sendKeys("4111 1111 1111 1111");
		 //Give Name on Card 
		 driver.findElement(By.id(obj.getProperty("cardname"))).sendKeys("Hari chandra");
		 //Give CVV Value
		 driver.findElement(By.id(obj.getProperty("cvv"))).sendKeys("123");
		 //Click on Place order button
		 Thread.sleep(4000);
		 driver.findElement(By.id(obj.getProperty("placeorder"))).click();
		 //wait some time for payment processing 
		 Thread.sleep(4000);
		 WebDriverWait wait=new WebDriverWait(driver,30);
		 WebElement cong=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(obj.getProperty("congratulations"))));
		 softassert.assertEquals(cong.getText(),"Congratulations !");
		 System.out.println("Congratulations message verified successfully");
		 //click on Take me to the Dash board
		 Thread.sleep(4000);
		 driver.findElement(By.xpath(obj.getProperty("Takemedb"))).click();
		 //Verify User is navigated to Dash board or not(Verify dash board label).
		 WebElement dash=driver.findElement(By.xpath(obj.getProperty("dashboard")));
		 System.out.println(dash.getText());
		 Thread.sleep(4000);
		 softassert.assertEquals(dash.getText(),"Dashboard");
		 System.out.println("Dash board label verified successfully");
		 System.out.println("User successfully Navigated to Dashbaord");
		 System.out.println("Now Advanced trail user is converted to Pro monthly user");
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
	 }
}
