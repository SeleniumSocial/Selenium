package Mavsocialpack;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Promonthlyusertoproannual 
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
	 @Test
	 public void Promonthlyusertoproannual() throws Exception
	 {
		//Read Property file
	     Properties obj = new Properties();					
	     FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\objects.properties");									
	     obj.load(objfile);
		 //go to user profile
		 Actions a=new Actions(driver);
		 Thread.sleep(4000);
		 a.moveToElement(driver.findElement(By.xpath(obj.getProperty("userprofile")))).click(driver.findElement(By.xpath(obj.getProperty("profile")))).build().perform();
		 //Check the user current plan is Pro monthly or not?
		 WebElement currentplan=driver.findElement(By.xpath(obj.getProperty("currentplan")));
		 System.out.println(currentplan.getText());
		 softassert.assertEquals(currentplan.getText(),"Current Plan - PRO (monthly)");
		 System.out.println("User current plan is  - pro (monthly)");
		 //Verify cancel Pro subscription is displayed or not 
		 softassert.assertEquals(driver.findElement(By.xpath(obj.getProperty("cancleadvsub"))).getText(),"Cancel PRO Subscription");
		 System.out.println("Cancel PRO Subscription label displayed successfully!");
		 //Verify Upgrade to pro button is displayed or not
		 WebElement uptopro=driver.findElement(By.xpath(obj.getProperty("upgradetopro")));
		 softassert.assertEquals(uptopro.getText(),"Upgrade to Annual");
		 Thread.sleep(4000);
		 uptopro.click();
		 //Verify Pro plan subscription label is displayed or not
		 softassert.assertEquals(driver.findElement(By.xpath(obj.getProperty("proplansub"))).getText(),"PRO PLAN SUBSCRIPTION");
		 System.out.println("PRO PLAN SUBSCRIPTION label displayed successfully");
		 //Verify Annual payment amount is $936 or not
		 WebElement annualamt=driver.findElement(By.xpath(obj.getProperty("aamt")));
		 softassert.assertEquals(annualamt.getText(),"$936");
		 System.out.println("Annual payment  $936 is diplayed");
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
		 System.out.println("Now Pro user monthly is converted to Pro user annaual");
		 Thread.sleep(4000);
		 a.moveToElement(driver.findElement(By.xpath(obj.getProperty("userprofile")))).click(driver.findElement(By.xpath(obj.getProperty("profile")))).build().perform();
		//Check the user current plan is Pro monthly or not?
		 WebElement currentplan2=driver.findElement(By.xpath(obj.getProperty("currentplan")));
		 System.out.println(currentplan2.getText());
		 softassert.assertEquals(currentplan2.getText(),"Current Plan - PRO (yearly)");
		 System.out.println("User current plan is  - pro (yearly)");
	 }
}
