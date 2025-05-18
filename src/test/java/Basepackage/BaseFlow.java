package Basepackage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseFlow {
	
	public WebDriver driver;
	
	@BeforeMethod
	public  void setup()
	{
		String Browsername = "chrome";
		
		if(Browsername.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		} 
		else if (Browsername.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if(Browsername.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		else {
			System.out.println("Given Browsername is not matching :- "+Browsername);
		}
		
		driver.manage().window().maximize();
		driver.get("https://v3opend.tech-active.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	
	@AfterMethod
	public void tear(ITestResult result)
	{
		if (ITestResult.FAILURE == result.getStatus()) {
	        // Take screenshot if scenario failed
			TakesScreenshot ts = (TakesScreenshot) driver;
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
			
         // Save screenshot to folder
            String screenshotName = "screenshots/" + result.getName() + ".png";
            try {
                Files.createDirectories(Paths.get("screenshots"));
                Files.write(Paths.get(screenshotName), screenshot);
                System.out.println("Screenshot saved: " + screenshotName);
            } catch (IOException e) {
                e.printStackTrace();
            }   
	    }
		
		if(driver != null)
		{
			driver.quit();
		}
	}
}
