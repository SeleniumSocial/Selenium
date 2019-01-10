package UiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import BusinessFunctions.*;

public class amazonopr  extends TestBase
{
	WebDriver driver;
    public static final Logger log=Logger.getLogger(amazonopr.class.getName());
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"nav-link-yourAccount\"]/span[1]")
    WebElement hoversignin; //Web Element and Xpath For hover sign in 
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"nav-flyout-ya-signin\"]/a/span")
    WebElement signinbtn; //Web Element and Xpath For hover sign in  
    
    @FindBy(how = How.NAME, using = "email")
    WebElement EnterEmailField; //Web Element and Name For Enter Your Email Field
    
    @FindBy(how = How.ID, using = "continue")
    WebElement continuebtn; //Web Element and id  For continue button
    
    @FindBy(how = How.NAME, using = "password")
    WebElement EnterPasswordField; //Web Element and Name For Enter Your Password Field
    
    @FindBy(how = How.ID, using = "signInSubmit")
    WebElement signbtn; //Web Element and id for sign in button
	
    @FindBy(how = How.XPATH, using = "//select[@id=\"searchDropdownBox\"]")
    WebElement alldropdown; //Web Element and id for sign in button
    
    @FindBy(how = How.ID, using = "twotabsearchtextbox")
    WebElement searchtext; //Web Element and id for search click button
    
    @FindBy(how = How.XPATH, using = "//input[@class='nav-input']")
    WebElement searchclick; //Web Element and id for search click button
    
   
  

public amazonopr(WebDriver driver)
{
	 this.driver=driver;
	 PageFactory.initElements(driver, this);
}

public void amezonoperations(String username, String password) throws Exception
{
	  Thread.sleep(3000);
	  Actions action = new Actions(driver);
	  action.moveToElement(hoversignin);
	 
	  action.moveToElement(hoversignin).click(signinbtn).build().perform();
	  log.info("<===========Sign in button clicked successfully!===========> ");
	  //enter user name 
	  Thread.sleep(5000);
	  EnterEmailField.sendKeys(username);
	  log.info("Entered emailaddress " +username+ " and object is "+EnterEmailField.toString());
	  log.info("<===========User name entered successfully!===========> ");
	  //clicik on continue buttom
	  continuebtn.click();
	  //Enter password 
	  EnterPasswordField.sendKeys(password);
	  log.info("Entered Password " +password+ " and object is "+EnterPasswordField.toString());
	  log.info("<===========Password entered successfully===========> ");
	  //click on log in button
	  signbtn.click();
	  log.info("<===========Signin button clicked successfully!===========> ");
	  log.info("<===========User succcessfully log in into application===========> ");
	  //all drop down button
	  Select alldd=new Select(alldropdown);
	  alldd.selectByVisibleText("Amazon Devices");
	  log.info("<===========Drop down amazon devices selected!===========> ");
	  Thread.sleep(3000);
	  //type data in search bar
	  searchtext.sendKeys("Amazon Fire TV Stick");
	  log.info("<===========search data added successfully!===========> ");
	  //Click on search button
	  searchclick.click();
	  log.info("<===========Search button clicked successfully!===========> ");
	  Thread.sleep(5000);
}
}