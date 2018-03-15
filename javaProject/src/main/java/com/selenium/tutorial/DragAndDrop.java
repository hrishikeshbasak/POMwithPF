package com.selenium.tutorial;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DragAndDrop {
	
WebDriver driver;
	
	@Test
	public void test() throws Exception {
		
		System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://jqueryui.com/droppable/");
		
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		WebElement drag = driver.findElement(By.xpath("//*[@id=\"draggable\"]"));
		
		WebElement drop = driver.findElement(By.xpath("//*[@id=\"droppable\"]"));
		
		Actions action = new Actions(driver);
		
		Thread.sleep(3000);
		action.dragAndDrop(drag, drop).perform();;
	

	}
}