package Mavsocialpack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LoggingPreferences;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login_scenarios 
{
  WebDriver driver;
  @Test(priority=0)
  public void login() throws Exception 
  {
	//launch application
	 driver.get("https://app.maventus.com/");
	 System.out.println("Mavsocial application launched successfully");
	 System.out.println("Scenario1 :- Testing login functionality by valid user name and valid password");
	 System.out.println("--------------------------------------------------------------------------------");
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
	 Assert.assertEquals(driver.getTitle(), "Social Media and Content Management Software | MavSocial");
	 System.out.println("Page ttile verified");
	 //click on log out button 
	 Actions a=new Actions(driver);
	 Thread.sleep(4000);
	 a.moveToElement(driver.findElement(By.xpath("//div[2]/div[3]/div/ul/li[7]/a"))).click(driver.findElement(By.xpath("//*[@id='header_notification_bar']/li[9]/a"))).build().perform();
	//*[@id="mavsocial-body-welcome243"]/div[1]/div[2]/div/div[2]/div[3]/div/ul/li[7]/a
	 Thread.sleep(4000);
	 System.out.println("Trail user looged out successfully");
  }
  @Test(priority=1)
  public void logininvalidmail() throws Exception 
  {
	//launch application
	 driver.get("https://app.maventus.com/");
	 System.out.println("Mavsocial application launched successfully");
	 System.out.println("Scenario2 :-Testing login functionality by invalid user name and valid password");
	 System.out.println("--------------------------------------------------------------------------------");
	 //Enter user name(invalid) 
	 driver.findElement(By.name("email")).sendKeys("haritest599@gmil.com");
	 System.out.println("user name entered");
	 //Enter password(valid)
	 driver.findElement(By.name("pwd")).sendKeys("social@123");
	 System.out.println("password entered");
	 //click on log in button
	 driver.findElement(By.xpath("//button[@type='submit']")).click();
	 Thread.sleep(4000);
	 WebElement invalidmailid=driver.findElement(By.xpath("//html/body/div[2]/form[1]/div[1]/div/div"));
	 System.out.println(invalidmailid.getText());
	 Assert.assertEquals(invalidmailid.getText(), "This Email Id does not exist.");
	 System.out.println("Trail user not logged in due to invalid email id");
	 Thread.sleep(4000);
  }  
  @Test(priority=2)
  public void logininvalidpassword() throws Exception 
  {
	//launch application
	 driver.get("https://app.maventus.com/");
	 System.out.println("Mavsocial application launched successfully");
	 System.out.println("Scenario3 :-Testing login functionality by valid user name and invalid password");
	 System.out.println("--------------------------------------------------------------------------------");
	 //Enter user name(valid) 
	 driver.findElement(By.name("email")).sendKeys("haritest599@gmail.com");
	 System.out.println("user name entered");
	 //Enter password(invalid)
	 driver.findElement(By.name("pwd")).sendKeys("test");
	 System.out.println("password entered");
	 //click on log in button
	 driver.findElement(By.xpath("//button[@type='submit']")).click();
	 Thread.sleep(4000);
	 WebElement invalidmailid=driver.findElement(By.xpath("//html/body/div[2]/form[1]/div[1]/div/div"));
	 System.out.println(invalidmailid.getText());
	 Assert.assertEquals(invalidmailid.getText(), "Wrong Email or Password");
	 System.out.println("Trail user not logged in due to invalid password");
	 Thread.sleep(4000);
  } 
  
  @Test(priority=3)
  public void logininvalidmailandpassword() throws Exception 
  {
	//launch application
	 driver.get("https://app.maventus.com/");
	 System.out.println("Mavsocial application launched successfully");
	 System.out.println("Scenario4 :-Testing login functionality by invalid user name and invalid password");
	 System.out.println("--------------------------------------------------------------------------------");
	 //Enter user name(invalid) 
	 driver.findElement(By.name("email")).sendKeys("test");
	 System.out.println("user name entered");
	 //Enter password(invalid)
	 driver.findElement(By.name("pwd")).sendKeys("test");
	 System.out.println("password entered");
	 //click on log in button
	 driver.findElement(By.xpath("//button[@type='submit']")).click();
	 Thread.sleep(4000);
	 WebElement invalidmailid=driver.findElement(By.xpath("//html/body/div[2]/form[1]/div[1]/span"));
	 System.out.println(invalidmailid.getText());
	 Assert.assertEquals(invalidmailid.getText(), "Enter Valid Email and Password.");
	 System.out.println("Trail user not logged in due to invalid mail id and password");
	 Thread.sleep(4000);
  } 
  
  @Test(priority=4)
  public void loginblankmailandpassword() throws Exception 
  {
	//launch application
	 driver.get("https://app.maventus.com/");
	 System.out.println("Mavsocial application launched successfully");
	 System.out.println("Scenario5 :-Testing login functionality by blank user name and blank password");
	 System.out.println("--------------------------------------------------------------------------------");
	 // user name(blank) 
	 driver.findElement(By.name("email")).sendKeys("");
	 System.out.println("user name entered");
	 //Enter password(blank)
	 driver.findElement(By.name("pwd")).sendKeys("");
	 System.out.println("password entered");
	 //click on log in button
	 driver.findElement(By.xpath("//button[@type='submit']")).click();
	 Thread.sleep(4000);
	 WebElement invalidmailid=driver.findElement(By.xpath("//html/body/div[2]/form[1]/div[1]/span"));
	 System.out.println(invalidmailid.getText());
	 Assert.assertEquals(invalidmailid.getText(), "Enter Valid Email and Password.");
	 System.out.println("Trail user not logged in due to blank mail id and password");
	 System.out.println("------------------------------------------------------------------------------");
	 Thread.sleep(4000);
  }
  @BeforeMethod
  public void openbrowser() throws Exception 
  {
	 
		System.setProperty("webdriver.chrome.driver", "I:\\hari\\Automation\\Workspaces\\Mavsocial_Workspace\\Lib\\chromedriver_win32\\chromedriver.exe");
		/*LoggingPreferences loggingPrefs = new org.openqa.selenium.logging.LoggingPreferences();
	    loggingPrefs.enable(org.openqa.selenium.logging.LogType.DRIVER, java.util.logging.Level.OFF);*/
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(5000);
	  
	 /* if(browser.equalsIgnoreCase("FF"))
		{
			
		  System.setProperty("webdriver.gecko.driver", "I:\\hari\\Automation\\Workspaces\\Mavsocial_Workspace\\Lib\\geckodriver-v0.21.0-win64\\geckodriver.exe");
	        System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");
	        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"I:\\hari\\Logs\\log.txt");
			driver=new FirefoxDriver();
			
		}
		else if(browser.equalsIgnoreCase("GC"))
		{
			System.setProperty("webdriver.chrome.driver", "I:\\hari\\Automation\\Workspaces\\Mavsocial_Workspace\\Lib\\chromedriver_win32\\chromedriver.exe");
			  LoggingPreferences loggingPrefs = new org.openqa.selenium.logging.LoggingPreferences();
		        
		        loggingPrefs.enable(org.openqa.selenium.logging.LogType.DRIVER, java.util.logging.Level.OFF);
			driver=new ChromeDriver();
			driver.manage().window().maximize();
		}*/
	   }

  @AfterMethod
  public void closebrowser() 
  {
	  driver.close();
  }

}
