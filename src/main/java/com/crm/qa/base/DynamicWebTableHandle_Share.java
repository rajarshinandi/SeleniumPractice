package com.crm.qa.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class DynamicWebTableHandle_Share extends TestBase {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://classic.crmpro.com/");

		//Login into Application
		driver.findElement(By.name("username")).sendKeys("batchautomation");
		driver.findElement(By.name("password")).sendKeys("Test@12345");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(3000);

		//Navigate to Contacts page
		driver.switchTo().frame("mainpanel");
		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();

		//Step -1: Locate and select the complete table
		WebElement toGetRow = driver.findElement(By.xpath("//*[@id='vContactsForm']/table/tbody"));
		
		//Step -2: Store complete rows inside the ArrayList
		ArrayList<WebElement> rowlist = new ArrayList<WebElement>(toGetRow.findElements(By.tagName("tr")));
		
		//Number of rows
		int totalRows = rowlist.size();
		System.out.println("Total number of Rows in the table are : "+ totalRows);
				
		//Step -3: Locate the row containing column headers
		WebElement toGetCol = driver.findElement(By.xpath("//*[@id='vContactsForm']/table/tbody/tr[3]"));
		
		//Step -4: Store complete row (containing columns) inside the ArrayList
		ArrayList<WebElement> colList = new ArrayList<WebElement>(toGetCol.findElements(By.tagName("td")));

		//Number of column
		int totalCols = colList.size();
		System.out.println("Total number of Rows in the table are : "+ totalCols);
		
		//Print Columns with the help of Iterator
		System.out.println("Columns are as below:");
		Iterator<WebElement> it = colList.iterator();
		while(it.hasNext())
			System.out.println(it.next().getText());

		driver.quit();

	}

}
