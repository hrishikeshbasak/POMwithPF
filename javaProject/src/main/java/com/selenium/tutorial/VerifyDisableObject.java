package com.selenium.tutorial;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyDisableObject {
	WebDriver driver;

	@Test
	public void test() {
	
	System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("https://www.olx.in/bangalore/cars/q-swift/");
	
	String data = driver.findElement(By.xpath("//*[@id=\"param_model\"]")).getAttribute("class");
	System.out.println(data);
	Assert.assertEquals(data, "param paramSelect disabled");
	}

}
