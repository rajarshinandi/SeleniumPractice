package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	//Page Factory
	
	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	WebElement contactPageLabel;
	
	@FindBy (xpath = "//input[@value = '52744773']")
	WebElement contactCheckbox;
	
	
	//Initialize all the webelements in ContactsPage
	public ContactsPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	//Methods
	public boolean verifyContactsLabel() {
		
		return contactPageLabel.isDisplayed();
		
	}
	
	public void selectContacts() {
		contactCheckbox.click();
		
	}
	
}
