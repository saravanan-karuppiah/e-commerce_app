package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import seleniumBase.SeleniumBase;

public class HomePage extends BasePage 
    {
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//a[@class='desktop-main'][normalize-space()='Men']") WebElement men;
	@FindBy(xpath="//a[normalize-space()='Rain Jackets']")WebElement rainjackets;
	

	public HomePage chooseMen(String description) 
	{   
		SeleniumBase.moveTheCurzorTo(driver,men,description);
		return this;

	}
	public HomePage clickRainJacket(String description)
	{
		SeleniumBase.moveTheCurzorToandClick(driver,rainjackets, description );
		return this;

	}
	


	
	
	

}
