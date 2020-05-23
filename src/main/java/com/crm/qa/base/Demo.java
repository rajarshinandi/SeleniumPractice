package com.crm.qa.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Demo {

	public static void main(String[] args) throws InterruptedException{
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get("https://www.spicejet.com/");
		Thread.sleep(5000);
		
		WebElement addons_menuItem = driver.findElement(By.xpath("//a[contains(text(),'Add-Ons')]"));

		Actions act = new Actions(driver);		
		act.moveToElement(addons_menuItem).click().build().perform();
		
		WebElement excess_submenuItem = driver.findElement(By.xpath("//a[contains(text(),'International Connection Baggage')]"));
		act.moveToElement(excess_submenuItem).click().build().perform();

		
		WebElement excessLbl = driver.findElement(By.xpath("//span[contains(text(),'EXCESS BAGGAGE')]"));

		if(excessLbl.isDisplayed()) {
			System.out.println("Test case: Pass" );
		}
		else
			System.out.println("Test case: Fail" );
		
		driver.quit();
		
	}
}
