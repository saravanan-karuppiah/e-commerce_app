package testCases;

import org.testng.annotations.Test;

import pageObject.BagPage;
import pageObject.HomePage;
import pageObject.ProductPage;
import pageObject.RainJacketPage;
import seleniumBase.SeleniumBase;
import testBase.TestBase;

public class Tc_001_Order_costliest_rainjacket extends TestBase
{

	
	@Test
	public void searchProduct() throws InterruptedException 
	{
		new HomePage(driver)
		.chooseMen(null).clickRainJacket(null);
		
		RainJacketPage rp =new RainJacketPage(driver);
		rp.totalPages();
		rp.chooseProduct();
		SeleniumBase.switchWindow(driver,1);
		
		new ProductPage(driver)
		.chooseMsize()
		.addtoCart();
		SeleniumBase.switchWindow(driver,0);
		
		rp.clickBagIcon();
		
		new BagPage(driver)
		.pro_confirmation();
		
		
		
		
		
	}
	
	
	
	
	
}
