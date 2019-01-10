package UiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import BusinessFunctions.TestBase;

public class TwitterDmOpr extends TestBase
{

	WebDriver driver;
    public static final Logger log=Logger.getLogger(TwitterDmOpr.class.getName());
    
    public TwitterDmOpr(WebDriver driver)
    {
    	 this.driver=driver;
    	 PageFactory.initElements(driver, this);
    }
    @FindBy(how = How.NAME, using = "email")
    WebElement musername; //Web Element and id For user name 
    
    @FindBy(how = How.NAME, using = "pwd")
    WebElement mpassword; //Web Element and id For user name 
    
    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    WebElement loginbutton; //Web Element  For login button click 
    
    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Social Inbox')]")
    WebElement socialinbox; //Web Element for social inbox
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"Twitter\"]/img")
    WebElement Twitter; //Web Element for twitter
    
    @FindBy(how = How.XPATH, using = "//span[@id='twitter_dm']/i")
    WebElement dminitiation; //Web Element for twitterdm initiation icon

    @FindBy(how = How.ID, using = "dm_msg")
    WebElement typemessage; //Web Element for typing message 
    
    @FindBy(how = How.ID, using = "sendDM")
    WebElement Dmsend; //Web Element for typing message 
    
    
    
    
    public void TwitterDmoperatopns(String username, String password) throws Exception
    {

  	  //enter user name 
  	  Thread.sleep(5000);
  	  musername.sendKeys(username);
  	  log.info("Entered user name " +username+ " and object is "+musername.toString());
  	  log.info("<===========User name entered successfully!===========> ");
  	  mpassword.sendKeys("social@123");
  	  log.info("Entered user name " +password+ " and object is "+mpassword.toString());
	  log.info("<===========password entered successfully!===========> ");
      loginbutton.click();
      log.info("<===========Login button clicked successfully!===========> ");
      socialinbox.click();
      log.info("<===========Social inbox clicked successfully!===========> ");
      Twitter.click();
      log.info("<===========Twitter tab clicked successfully!===========> ");
      dminitiation.click();
      log.info("<===========Twitter DM initiation icon clicked successfully!===========> ");
      typemessage.sendKeys("Hi");
      log.info("<===========Message entered in Twitter Direct message box successfully!===========> ");
      Dmsend.click();
      log.info("<===========Send button clicked successfully!===========> ");
      Thread.sleep(5000);
      
      
      
      
      
    }
  
	
	
}
