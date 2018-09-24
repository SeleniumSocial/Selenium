package Mavsocialpack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class FreeusertoadvTrailuser
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
    public void freeusertoadvtrailuser() throws Exception
    {
    	Thread.sleep(4000);
		 //Go to profile section
		 Actions a=new Actions(driver);
		 Thread.sleep(5000);
		 a.moveToElement(driver.findElement(By.xpath("//a[@class='dropdown-toggle file-upload-bg user-default-padding']"))).click(driver.findElement(By.xpath("//*[@id=\"header_notification_bar\"]/li[1]/a"))).build().perform();
		 Thread.sleep(5000); 
		 //check Upgrade to advanced button is displayed or not in User profile 
		 WebElement uptoadv=driver.findElement(By.name("btnUpgrade"));
		 System.out.println(uptoadv.getText());
		
		 softassert.assertEquals(uptoadv.getText(), "Upgrade to Advanced");
		 //verifyTrue(uptoadv.isTextPresent("Upgrade to Advanced"));
		 System.out.println("Upgrade to Advanced button displayed in User profile section");
		 //Verify Activate 7-day Trail label is displayed or not?
		 WebElement trail=driver.findElement(By.xpath("//a[contains(text(),'Activate 7-day Trial')]"));
		softassert.assertEquals(trail.getText(),"Activate 7-day Trial");
		 System.out.println("Activate 7-day Trial displayed successfully");
		 Thread.sleep(3000);
		 trail.click();
		 //validate the "Are you sure you wish to activate your Advanced trial?" pop up is displayed or not.
		 Thread.sleep(5000);
		 driver.findElement(By.xpath("//html/body/div[5]/div/div/div[2]/button[2]")).click();
		                              //html/body/div[9]/div/div/div[2]/button[2]
		 //html/body/div[5]/div/div/div[2]/button[2]
		//Validate the Trail period box on header.
		 Thread.sleep(5000);
		 WebElement trialperiod=driver.findElement(By.xpath("//div/ul/li[1]/span/p[1]/strong"));
		softassert.assertEquals(trialperiod.getText(),"Trial period");
		 System.out.println("Trail period box displayed");
		 //Verify current plan in Profile section
		 Thread.sleep(4000);
		 //Actions a=new Actions(driver);
		 a.moveToElement(driver.findElement(By.xpath("//a[@class='dropdown-toggle file-upload-bg user-default-padding']"))).click(driver.findElement(By.xpath("//*[@id=\"header_notification_bar\"]/li[1]/a"))).build().perform();
		 //Validate current plan -Advanced(trail).
		 WebElement currentplan=driver.findElement(By.xpath("//div[2]/div[3]/div/span/div[1]"));
		 
		softassert.assertEquals(currentplan.getText(),"Current Plan - Advanced (Trial)");
		 System.out.println("User current plan is Advanced trail");
		 //Click on paynow button
		 driver.findElement(By.linkText("PAY NOW")).click();
    }


}
