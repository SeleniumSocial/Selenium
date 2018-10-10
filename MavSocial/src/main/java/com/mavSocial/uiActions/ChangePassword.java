package com.mavSocial.uiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.mavSocial.testBase.TestBase;

public class ChangePassword extends TestBase {
	WebDriver driver;
    public static final Logger log=Logger.getLogger(LoginPage.class.getName());
    
    @FindBy(how = How.XPATH, using = "//li[@class='dropdown dropdown-user']/a/i[2]")
    WebElement btn_userdrpdwn; //Web Element and Xpath For Enter Your Email Field
    
    /*@FindBy(how = How.ID, using = "id=\"mavsocial-body-welcome243\"")
    WebElement btn_userdrpdwn; //Web Element and Xpath For Enter Your Email Field */
    
    @FindBy(how = How.XPATH, using = ".//*[@id='header_notification_bar']/li[1]/a")
    WebElement lnk_profile; //Web Element and Xpath For Enter Your Email Field
	
    @FindBy(how = How.XPATH, using = ".//*[@id='change_password_tag']")
    WebElement btn_chngepswd; //Web Element and Xpath For Enter Your Email Field

    @FindBy(how = How.XPATH, using = "//input[@id='old_pwd']")
    WebElement inp_oldpswd; //Web Element and Xpath For Enter Your Email Field
    
    @FindBy(how = How.XPATH, using = "//input[@id='new_pwd']")
    WebElement inp_newpswd; //Web Element and Xpath For Enter Your Email Field
    
    @FindBy(how = How.XPATH, using = "//input[@id='new_conf_pwd']")
    WebElement inp_confmpswd; //Web Element and Xpath For Enter Your Email Field
    
    @FindBy(how = How.XPATH, using = ".//*[@id='change_pwd_btn']")
    WebElement btn_save; //Web Element and Xpath For Enter Your Email Field
/*...................> Method to initialize driver and web elements <..........................*/

public ChangePassword(WebDriver driver)
 {
	 this.driver=driver;
	 PageFactory.initElements(driver, this);
 }

/*...................> Method to Change Password <..........................*/

public void change_password() throws InterruptedException 
{
	   btn_userdrpdwn.click();
	   Actions action = new Actions(driver);
	   btn_userdrpdwn.click();
	   lnk_profile.click();
//	   log.info("Entered Password " +password+ " and object is "+EnterPasswordField.toString());
	   btn_chngepswd.click();
//	   log.info("clicked on submit button and object is "+EnterPasswordField.toString());
	   Thread.sleep(3000);
	   inp_oldpswd.sendKeys("Adithya@01");
	   inp_newpswd.sendKeys("Adithya@011");
	   inp_confmpswd.sendKeys("Adithya@011");
	   btn_save.click();
	}
/*...................> Method to verify Change Password <..........................*/

public String verify_changepassword()
{
	return driver.getCurrentUrl();
}
}


