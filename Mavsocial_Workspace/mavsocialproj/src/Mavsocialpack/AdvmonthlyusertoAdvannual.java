package Mavsocialpack;

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

public class AdvmonthlyusertoAdvannual 
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
	 public void advmonthlytoadvannual() throws Exception
	 {
		 Actions a = new Actions(driver);
         Thread.sleep(4000);
		 a.moveToElement(driver.findElement(By.xpath("//a[@class='dropdown-toggle file-upload-bg user-default-padding']"))).click(driver.findElement(By.xpath("//*[@id=\"header_notification_bar\"]/li[1]/a"))).build().perform();
		//Validate current plan -Advanced(trail).
		 WebElement currentplan=driver.findElement(By.xpath("//div[3]/div[2]/div[3]/div/span"));
		 System.out.println(currentplan.getText());
	 	softassert.assertEquals(currentplan.getText(), "Current Plan - Advanced (monthly)");
	 	 Thread.sleep(4000);
		 //Verify upgrade to annual button is displayed or not
		 WebElement uptoan=driver.findElement(By.xpath("//a[@class='btn btn-primary']"));
		 System.out.println(uptoan.getText());
		softassert.assertEquals(uptoan.getText(), "Upgrade to Annual");
		 System.out.println("Upgrade to Annual button displayed successfully");
		 //click on upgrade to annual button
		 Thread.sleep(4000);
		 uptoan.click();
	     //Verify advanced plan subscription label
		 WebElement advplansub=driver.findElement(By.className("welcome_hedding"));
		 System.out.println(advplansub.getText());
		softassert.assertEquals(advplansub.getText(),"ADVANCED PLAN SUBSCRIPTION");
		 System.out.println("Advanced Plan Subscription label displayed");
		 //Verify Annual payment amount is $228 or not
		 WebElement aamt=driver.findElement(By.xpath("//span[@class='ultra_price ultra_price_annual']"));
		 System.out.println(aamt.getText());
		softassert.assertEquals(aamt.getText(),"$228");
		 System.out.println("Annual payment $228 is diplayed");
	     
		//click on radio button of credit cards 
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//table/tbody/tr[3]/td/label/div/input")).click();
		 System.out.println("Credit cards radio button clicked successfully");
		 //Scroll window 
		 for (int n=0;n<10;n++)
	     {
	        ((RemoteWebDriver) driver).executeScript("window.scrollBy(0,200)", "");
	        Thread.sleep(2000);
	     }
		 //Give credit card number
		 driver.findElement(By.id("txtCardNum")).sendKeys("4111 1111 1111 1111");
		 //Give Name on Card 
		 driver.findElement(By.id("txtCardName")).sendKeys("Hari chandra");
		 //Give CVV Value
		 driver.findElement(By.id("txtCVV")).sendKeys("123");
		 //Click on Place order button
		 Thread.sleep(4000);
		 driver.findElement(By.id("add_new_payment_proceed")).click();
		 //wait some time for payment processing 
		 Thread.sleep(4000);
		 WebDriverWait wait=new WebDriverWait(driver,30);
		 WebElement cong=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='bold_font']")));
		 System.out.println(cong.getText());	
		softassert.assertEquals(cong.getText(),"Congratulations !");
		 System.out.println("Congratulations message verified successfully");
		 //click on Take me to the Dash board
		 Thread.sleep(4000);
		 driver.findElement(By.xpath("//button[(@class='btn btn-success btn_padding margin_top')]")).click();
		 //Verify User is navigated to Dash board or not(Verify dash board label).
		 WebElement dash=driver.findElement(By.xpath("//h3[@class='dBHeading']"));
		 System.out.println(dash.getText());
		 Thread.sleep(4000);
		softassert.assertEquals(dash.getText(),"Dashboard");
		 System.out.println("Dash board label verified successfully");
		 System.out.println("User successfully Navigated to Dashbaord");
		 //Verify The User is successfully converted his plan from Advanced-Monthly user to advanced Annual user 
		 //Verifyy the User current plan in his profile section
		 //Actions a = new Actions(driver);
	     Thread.sleep(4000);
		 a.moveToElement(driver.findElement(By.xpath("//a[@class='dropdown-toggle file-upload-bg user-default-padding']"))).click(driver.findElement(By.xpath("//*[@id=\"header_notification_bar\"]/li[1]/a"))).build().perform();
		//Validate current plan -Advanced(annual).
		 WebElement currentplan2=driver.findElement(By.xpath("//div[3]/div[2]/div[3]/div/span"));
		 System.out.println(currentplan2.getText());
		softassert.assertEquals(currentplan2.getText(), "Current Plan - Advanced (yearly)");
		 System.out.println("The User is successfully converted his plan from Advanced-Monthly user to advanced annual user ");
		 
	 
	 
	 }
			 
		@AfterClass
		public void closebrowser()
		{
			driver.close();
		}
	 }

