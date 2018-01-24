package Selenium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Login_Page {
 
  @BeforeTest
   public void beforeTest() {
   
  // Create a new instance of the Firefox driver
   
        driver = new FirefoxDriver();
   
        //Put a Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception
   
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
   
        //Launch the Online Store Website
   
        driver.get("https://app.maventus.com/user/login");
   }
 
  @Test
 
  driver.findElement(By.name("email")).sendkeys("nihanthenter@gmail.com");
   
        driver.findElement(By.name("pwd")).sendKeys("pwdfbads");
  
     driver.findElement(By.class("btn green uppercase")).click();
  
       // Print a Log In message to the screen
  
       System.out.println(" Login Successfully,.");
  
       // Find the element that's ID attribute is 'account_logout' (Log Out)
  
       //driver.findElement(By.id("account_logout"));//
  
   }

  @AfterTest
  public void afterTest() {
   
   driver.quit();