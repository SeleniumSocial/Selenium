package UiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import BusinessFunctions.TestBase;

public class AddimgsinFBtwitterreplyOpr extends TestBase
{

	WebDriver driver;
    public static final Logger log=Logger.getLogger(AddimgsinFBtwitterreplyOpr.class.getName());
	public AddimgsinFBtwitterreplyOpr(WebDriver driver)
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
	 
	 @FindBy(how = How.XPATH, using = "//*[@id=\"Facebook\"]/img")
	 WebElement facebook; //Web Element for face book
	 
	 @FindBy(how = How.XPATH, using = "//*[@id=\"131328115\"]/div[2]/p")
	 WebElement firstpost; //Web Element for first post
	 
	 @FindBy(how = How.XPATH, using = "//div[@id='imageFBReplyMultiUpload']/i")
	 WebElement addattachment; //Web Element for first post

	 @FindBy(how = How.XPATH, using = "//*[@id=\"131308521\"]/div[2]/p")
	 WebElement secondpost; //Web Element for first post

	//*[@id="131308521"]/div[2]/p
	 
	 
	 
	 public void Addimgsinfblogin(String username, String password) throws Exception 
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
	      facebook.click();     
	      log.info("<===========Social inbox facebook Tab clicked successfully!===========> ");
	      //firstpost.click();
	      log.info("<===========Social inbox facebook First post clicked successfully!===========> ");
	      secondpost.click();
	      log.info("<===========Social inbox facebook Second post clicked successfully!===========> ");
	      Thread.sleep(4000);
	      addattachment.click();
	      
	      
	      
	      
	      
	      
	      
	 }
	 
	 
	 
	 
	 
	 
	 
	 
}
