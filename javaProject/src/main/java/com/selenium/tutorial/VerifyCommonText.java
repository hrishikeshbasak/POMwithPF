package com.selenium.tutorial;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyCommonText {
	
	WebDriver driver;
	@Test
	public void test() {
		
		System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.hdfcbank.com/nri_banking/payments/BillPay/BillPay.htm");
		
		ArrayList<String> expectedArray = new ArrayList<String>();
		expectedArray.add("Features & Benefits");
		expectedArray.add("Mobile Phone Bills");
		expectedArray.add("Electricity and Telephone Bills");
		expectedArray.add("Insurance Premium");
		expectedArray.add("How to register for BillPay");
		expectedArray.add("FAQs");
		
		List<WebElement> totalText = driver.findElements(By.xpath("//div[@id='nre_savings_acc']/ul/li"));
		Iterator<WebElement> itr = totalText.iterator();
		ArrayList<String> actualArray = new ArrayList<String>();
		while(itr.hasNext()) {
			actualArray.add(itr.next().getText());
		}
		
		Assert.assertEquals(actualArray, expectedArray);;
	}
}













