package testBase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestBase 
{

	static public WebDriver driver;
	
	@BeforeTest
	public void setup()
	{
	    driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://www.myntra.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	
	}
	
	
	@AfterTest
	public void teardown() throws InterruptedException
	{
		
		//driver.close();;
		
		
	}
	
	
	
}
