package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class HomePage extends TestBase{
	
	//Object Repository
	
	@FindBy(xpath = "//td[contains(text(),'User')][@class='headertext']")
	WebElement userNameLabel;
	
	@FindBy(xpath = "//a[contains(text(), 'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	
	@FindBy(linkText = "Deals")
	WebElement dealsLink;
	
	@FindBy(xpath = "//a[contains(text(), 'Tasks')]")
	WebElement tasksLink;
	
	//Constructor
	public HomePage() {
		//Initialize all the webelements in HomePage
		PageFactory.initElements(driver, this);
		
	}
	
	//Methods for HomePage
	public String verifyHomePageTitle() {
		
		return driver.getTitle();
	}
	
	public boolean verifyUserName() {
		return userNameLabel.isDisplayed();
		
	}
	
	public ContactsPage clickOnContactsLink() {
		
		contactsLink.click();
		return new ContactsPage(); 	//Landing Page
	}
	
	
	
	public DealsPage clickOnDealsLink() {
		
		dealsLink.click();
		return new DealsPage();		//Landing Page
	}
	
	public TasksPage clickOnTasksLink() {
		
		tasksLink.click();
		return new TasksPage();		//Landing Page
	}
	
	public NewContactsPage clickOnNewContactLink() throws InterruptedException {
		Actions action = new Actions(driver);
		
		action
		.moveToElement(contactsLink)
		.moveToElement(newContactLink)
		.click().build().perform();
		
		return new NewContactsPage();
	}
	
}
