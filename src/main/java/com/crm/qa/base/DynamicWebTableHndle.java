package com.crm.qa.base;

import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class DynamicWebTableHndle extends TestBase {

	public DynamicWebTableHndle() {
		super();
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		new DynamicWebTableHndle();
		initialization();
		TestUtil testUtil = new TestUtil();
		LoginPage loginPage = new LoginPage();

		// Navigate to ContactsPage
		HomePage homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame("mainpanel");
		homePage.clickOnContactsLink();

		/**
		//Store complete rows inside the ArrayList
		ArrayList<WebElement> rowlist = new ArrayList<WebElement>(
				driver.findElement(By.xpath("//*[@id='vContactsForm']/table/tbody"))
				.findElements(By.tagName("tr"))
				);
		
		//Number of rows
		int totalRows = rowlist.size();
		System.out.println("Total number of Rows in the table are : "+ totalRows);
				
		//Store complete 1 row (containing columns) inside the ArrayList
		ArrayList<WebElement> colList = new ArrayList<WebElement>(
				driver.findElement(By.xpath("//*[@id='vContactsForm']/table/tbody/tr[3]"))
				.findElements(By.tagName("td"))
				);

		//Number of column
		int totalCols = colList.size();
		System.out.println("Total number of Rows in the table are : "+ totalCols);
		
		//Print Columns
		Iterator<WebElement> it = colList.iterator();
		while(it.hasNext())
			System.out.println(it.next().getText());
		
		int i;
		//Click the checkbox for certain person
		for(i = 4; i <totalRows-1; i++) {
			if(driver.findElement(By.xpath("//*[@id='vContactsForm']/table/tbody/tr["+i+"]/td[2]")).getText().contains("Abhi Yadav")||
					driver.findElement(By.xpath("//*[@id='vContactsForm']/table/tbody/tr["+i+"]/td[2]")).getText().contains("AP Kumar")) {
				
				driver.findElement(By.xpath("//*[@id='vContactsForm']/table/tbody/tr["+i+"]/td[1]")).click();		
			}
		
		}
		*/
		
		//Method 2:
		
		driver.findElement(By.xpath("//a[contains(text(),'Abhi Yadav')]/parent::td//preceding-sibling::td//input[@name='contact_id']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'AP Kumar')]/parent::td//preceding-sibling::td//input[@name='contact_id']")).click();
		
		Thread.sleep(4000);
		driver.quit();

	}

}
