package com.selenium.tutorial;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MouseHoverOver {
	WebDriver driver;
	@Test
	public void test() {
		
		System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
		WebElement electronics = driver.findElement(By.xpath("//*[@id=\"container\"]/div/header/div[3]/div/ul/li[1]/a/span"));
		Actions action = new Actions(driver);
	
		action.moveToElement(electronics).perform();
		
	}
}