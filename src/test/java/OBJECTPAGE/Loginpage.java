package OBJECTPAGE;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Loginpage  extends Basepage {
	
	public Loginpage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder='Enter Email']") private WebElement emailaddressfield;
	@FindBy(xpath = "//input[@placeholder='Enter Password']") private WebElement passwordfield;
	@FindBy(xpath = "//button[.='Sign In']") private WebElement signinbutton;
	
	public void signinpage(String un, String pwd)
	{
		waitforElement(emailaddressfield);
		emailaddressfield.sendKeys(un);
		waitforElement(passwordfield);
		passwordfield.sendKeys(pwd);
				// signin button click
				waitforElement(signinbutton);
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("arguments[0].click();", signinbutton );
	}
}
