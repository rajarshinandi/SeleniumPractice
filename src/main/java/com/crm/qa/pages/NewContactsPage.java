package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class NewContactsPage extends TestBase {
	
	@FindBy(id = "first_name")
	WebElement firstName;
	
	@FindBy(id = "surname")
	WebElement lastName;
	
	@FindBy(name = "client_lookup")
	WebElement company;
	
	@FindBy(xpath = "//input[@type = 'submit' and @value = 'Save']")
	WebElement saveBtn;
	
	public NewContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void createNewContact( String firstname, String lastname, String comp) {
		
//		Select select = new Select(driver.findElement(By.name("title")));
//		select.selectByVisibleText(title);
		
		firstName.sendKeys(firstname);
		lastName.sendKeys(lastname);
		company.sendKeys(comp);
		saveBtn.click();
	}

}
