package seleniumBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class SeleniumBase 
{
	
	
	public static void click(WebElement element,String descripition)
	{
		element.click();
		//descripition for logs and report	
	}
	
	public static void moveTheCurzorTo(WebDriver driver,WebElement element,String descripition) 
	{
	
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
		
		
	}
	
	public static void moveTheCurzorToandClick(WebDriver driver,WebElement element,String descripition)
	{
	     element.click();
		//Actions act = new Actions(driver);
		//act.moveToElement(element).click().build().perform();
		
	}
	public static void switchWindow(WebDriver driver,int windownumber)
	{
	
		List<String>windows=new <String>ArrayList(driver.getWindowHandles());
		
				driver.switchTo().window(windows.get(windownumber));
		System.out.println(driver.getTitle());
		
	}
	

}
