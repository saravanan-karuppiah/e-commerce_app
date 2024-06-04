package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class BagPage extends BasePage
{

	public BagPage(WebDriver driver)
	{
		
		super(driver);
	}
	
	@FindBy(css="a.itemContainer-base-itemLink")WebElement bag_pro_name;
	
	@FindBy(css="div.itemComponents-base-size>span")WebElement bag_pro_size;
	
	@FindBy(css="div.itemContainer-base-price")WebElement bag_pro_price;
	
	
	public void pro_confirmation()
	{
		if(bag_pro_name.getText().equalsIgnoreCase(ProductPage.product_name))
		{	
				System.out.println(bag_pro_name.getText());
				System.out.println(bag_pro_size.getText());
				System.out.println( bag_pro_price.getText());
				Assert.assertTrue(true);
		}
		
		
	}
	
	
}
