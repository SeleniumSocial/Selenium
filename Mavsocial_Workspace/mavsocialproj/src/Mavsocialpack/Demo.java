package Mavsocialpack;

import java.io.FileInputStream;		
import java.io.FileNotFoundException;		
import java.io.IOException;		
import java.util.Properties;		

import org.openqa.selenium.By;		
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;		

public class Demo 
{				
     WebDriver driver;
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
		 Assert.assertEquals(driver.getTitle(), "Social Media and Content Management Software | MavSocial");
		 System.out.println("Page ttile verified");
					
  }		
	
	 @Test(priority=0)
	 public void freetoadvanceusertrail() throws Exception
	 {
		try
		{
		 //Read Property file
	     Properties obj = new Properties();					
	     FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\objects.properties");									
	     obj.load(objfile);
		 //go to user profile
		 Actions a=new Actions(driver);
		 Thread.sleep(4000);
		 a.moveToElement(driver.findElement(By.xpath(obj.getProperty("userprofile")))).click(driver.findElement(By.xpath(obj.getProperty("profile")))).build().perform();
		 //Check the User current plan is Advanced(Yearly) or not.
		 WebElement currentplan=driver.findElement(By.xpath("//div[3]/div[2]/div[3]/div/span"));
		 System.out.println(currentplan.getText());
		 Assert.assertEquals(currentplan.getText(), "live");
		 
		}
	 
		catch(Exception e)
		{
			SendMail mail=new SendMail();
			mail.SendAttachment();
		}
	  }
	 
	 
	 
}		