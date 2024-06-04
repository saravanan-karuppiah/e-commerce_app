package pageObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import seleniumBase.SeleniumBase;

public class RainJacketPage extends BasePage
{
	public List<WebElement>finallist=new <WebElement>ArrayList();
	public RainJacketPage(WebDriver driver) 
	{
		
		super(driver);
		
	}
	
	
	@FindBy(css="ul.results-base li.product-base a div.product-price > span:not(.product-discountPercentage)") List<WebElement> products;
	@FindBy(className="product-price") List <WebElement> prices;
	@FindBy(xpath="//li[@class='pagination-next']") WebElement nextButton;
	@FindBy(className="pagination-prev") WebElement previousButton;
	@FindBy(xpath="//ul[@class='pagination-container']/li[@class='pagination-paginationMeta']")  WebElement pages;
	@FindBy(className="pagination-doubleArrowLeft") WebElement page1DoubleArrow;
	@FindBy(css="a.desktop-cart>span.desktop-userTitle")WebElement bagbutton;
	public int totalPages()
	{
		String pag=pages.getText();
		int pages=Integer.parseInt(pag.substring(10).trim());
		return pages;
	}
	
	public int convertToInteger(String string)
	{
		int value=Integer.parseInt(string);		
		return value;
	}
	
	
  public Map<String,Integer> productList() throws InterruptedException 
	{
		int pages=totalPages();
		Map<String,Integer> productlist=new<String,Integer>HashMap();
		for(int i=1;i<=pages;i++)
		{
		for(WebElement product:products)
		{	
			Pattern pattern = Pattern.compile("Rs\\. (\\d+)");
			 Matcher matcher = pattern.matcher(product.getText());
			 if (matcher.find()) {
				  productlist.put(product.findElement(By.xpath("ancestor::li")).getAttribute("id"),convertToInteger(matcher.group(1)));
	            }
			 else {
				 System.out.println("the matches is not found");
			 }
		}
		System.out.println(i);
		if(i<pages)
		{
			SeleniumBase.click(nextButton, null);
			 Thread.sleep(1500);
		}
		else{
			System.out.println("LAST PAGE REACHED :next button is not displayed");
			SeleniumBase.click(page1DoubleArrow, null);
		}
		}
		
		System.out.println(productlist.size());
		System.out.println(productlist);
		return productlist;
		
     }
	
	
  public void chooseProduct() throws InterruptedException
	{
		Map<String,Integer>finalproductlist=new<String,Integer>HashMap();
		finalproductlist.putAll(productList());
		List<Integer>prices=new <Integer>ArrayList(finalproductlist.values());
		Collections.sort(prices);
		System.out.println(prices.get(prices.size()-1));
	    String key="";
		for(String a:finalproductlist.keySet())
		{
			if(finalproductlist.get(a)==prices.get(prices.size()-1))
                 {	
                	 key=a;
                	 break;
                 }
		}
		 System.out.println(key);
		 System.out.println(finalproductlist.get(key));
		int pages=totalPages();
		 System.out.println(totalPages());
		 
		 for(int i=1;i<=pages;i++)
			{
			  try{ 
				 WebElement CostliestPro=driver.findElement(By.cssSelector("ul.results-base>li[id='"+key+"']"));
		          if(CostliestPro.isDisplayed())
			         {
		        	  CostliestPro.click();
		              break;
			         }
		         }
			  catch(NoSuchElementException e)
			     {
				   SeleniumBase.click(nextButton, "");
			     }
		     }	
	  }
	
  public void clickBagIcon() throws InterruptedException
  {
	  
	 
	  SeleniumBase.click(page1DoubleArrow, null);
	  Thread.sleep(1000);
	  SeleniumBase.click(bagbutton, null);
  }
}
	
	
	

