package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//pagefactory  - Object repository
	
	@FindBy(name = "username")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(linkText = "Sign Up")
	WebElement signupLink;
	
	@FindBy(xpath = "//img[@class = 'img-responsive']")
	WebElement crmLogo;
	
	//Define constructor and Initialize WebElements in current page
	public LoginPage() {
		
		//Initialize WebElements 
		PageFactory.initElements(driver, this);
				
	}
	
	//Actions on Login Page
	public String validateLoginPageTitle() {	

		return driver.getTitle();
		
	}
	
	//Validate logo
	public boolean validateCRMImage() {
		
		return crmLogo.isDisplayed();
		
	}
	
	//Login Action	--> Landing Page HomePage
	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		//Return the object of homepage
		return new HomePage();
	}
		
}
