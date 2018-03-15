package com.selenium.tutorial;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifylowestFirstPriceListInTheProduct_DetailsPage {

	WebDriver driver;

	@Test
	public void test() throws Exception{
	
	System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("http://automationpractice.com/index.php");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	
	driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a")).click();;
	WebElement webElements = driver.findElement(By.xpath("//*[@id=\"selectProductSort\"]"));
	System.out.println(webElements.getText());
	
	Select select = new Select(webElements);
	select.selectByVisibleText("Price: Lowest first");
	
	Thread.sleep(8000);
	List<WebElement> price = driver.findElements(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/div[1]/span[1]"));
	ArrayList<Integer> array  = new ArrayList<Integer>();
	Iterator<WebElement> itr = price.iterator();
	while(itr.hasNext()) {
		String p = itr.next().getText();
		System.out.println(p);
		
		if(p.contains("$")) {
			String actualdata = p.substring(1);
			double p1 = Double.parseDouble(actualdata);
			int productprice = (int)(p1);
			array.add(productprice);
			}
		}
	for(int i=0; i< array.size() -1 ; i++) {
		
		if(array.get(i)<array.get(i+1)) {
		
			System.out.println(array.get(i));	
			System.out.println(array.get(i+1));
		
		}else{
			Assert.assertTrue(false);
		}
	} 
	 
	
 	} 
}







