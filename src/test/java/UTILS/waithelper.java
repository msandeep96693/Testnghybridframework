package UTILS;

import java.time.Duration;
import java.util.List;
import java.util.function.BooleanSupplier;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class waithelper {
	
		WebDriver driver;
	
	public waithelper(WebDriver driver)
	{
		this.driver=driver;
	}

	public void waitElementHelper(WebElement element,Duration time)
	{
		WebDriverWait wait=new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitElementHelper(List<WebElement> elements,Duration time)
	{
		WebDriverWait wait=new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}
	
	public void waitElementHelper(By element,Duration time)
	{
		WebDriverWait wait=new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));
	}
	
	public void waitUntilConditionIsTrue(BooleanSupplier condition, Duration time) 
	{
	    WebDriverWait wait = new WebDriverWait(driver, time);
	    wait.until((WebDriver driver) -> condition.getAsBoolean());
	}
	
	public void waitUntilLoaderToClose(WebElement element,Duration time)
	{
		WebDriverWait wait=new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.invisibilityOf(element));
		
	}

}
