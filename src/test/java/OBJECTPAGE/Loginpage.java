package OBJECTPAGE;

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
	
	
	public void emailaddresstextfield() throws InterruptedException
	{
		waitforElement(emailaddressfield);
		emailaddressfield.sendKeys("admin@opend.com");
	}
	
	public void passwordtextfield() throws InterruptedException
	{
		waitforElement(passwordfield);
		passwordfield.sendKeys("1234");
	}
	
	public void clickonsigninbutton() throws InterruptedException
	{
		waitforElement(signinbutton); 
		signinbutton.click();
	}
}
