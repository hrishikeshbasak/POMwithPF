package com.selenium.tutorial;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ZoomInZoomOut {
	
	WebDriver driver;

	@Test
	public void test() throws Exception {
	
	System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("https://www.olx.in/bangalore/cars/q-swift/");
	
	
	((JavascriptExecutor)driver).executeScript("document.body.style.zoom='80%'");
	
	Thread.sleep(5000);
	
	((JavascriptExecutor)driver).executeScript("document.body.style.zoom='100%'");
	}
}