package pageObject;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import seleniumBase.SeleniumBase;

public class ProductPage extends BasePage
{ 
	public static String product_name=" ";
	public static String product_price=" ";

	public ProductPage(WebDriver driver)
	{
		super(driver);	
	}
	
	
	
	@FindBy(className="size-buttons-show-size-chart")WebElement sizechart;
	@FindBy(id="cm")WebElement cmbutton;
	@FindBy(xpath="//td[contains(text(),'M')]") WebElement Msizebutton;
	@FindBy(xpath="//div[@class='sizeChartWeb-size-chart-cta']/div/div[1]") WebElement addtocartbutton;
	@FindBy(css="p.notify-thumbnail-text")WebElement addedtocartpopup;
	@FindBy(css="h1.pdp-name")WebElement pro_name;
	@FindBy(css="div.SelectedSizeSellerInfo-sellerInfoContainer>div>div>span.PriceInfo-price>strong")WebElement Pro_price;
	
	
	
	public ProductPage chooseMsize()
	{
		
		SeleniumBase.click(sizechart, "Clicking the sizechart button");
		SeleniumBase.click(cmbutton, "clicking CM button");
		try {
		SeleniumBase.click(Msizebutton, "clicked size m button");}
		catch(Exception e)
		{
			System.out.println("M size is not available");
			Assert.fail("SIZE NOT AVAILABLE");
		}
		System.out.println(Msizebutton.getCssValue("font-weight"));
		if(Msizebutton.getCssValue("font-weight").equals("700"))
		{Assert.assertTrue(true);}
		else {
			System.out.println("the row m is not bold");
			Assert.fail("size m is not bold");
			
		}
		
		return this;
	}
	
	
	public ProductPage addtoCart() throws InterruptedException 
	{
		product_name=pro_name.getText();
		product_price=Pro_price.getText();
		SeleniumBase.click(addtocartbutton, "clicked add to cart button");
		Thread.sleep(1000);
		try {
		if(addedtocartpopup.isDisplayed())
		{	System.out.println("THE PRODUCT IS ADDED TO THE CART");
			Assert.assertTrue(true);	
		}}
		catch(NoSuchElementException e)
		{
			System.out.println("THE PRODUCT IS NOT ADDED TO THE CART");
			Assert.fail();
			
		}
	
		return this;
	}
	
	
	
	
}
