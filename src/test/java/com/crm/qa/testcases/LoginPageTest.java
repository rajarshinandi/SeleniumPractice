package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage loginpage; 	// Test page reference
	HomePage homepage; 		//Landing page reference

	// First call superclass constructor
	public LoginPageTest() {

		super(); // Call the constructor TestBase() --> Read prop files 

	}

	// Second call the setup
	@BeforeMethod
	public void setUp() {

		initialization(); 				// Perform all browser setup activities
		loginpage = new LoginPage(); 	// New LoginPage object to access all the webElemenrs and methods of LoginPage

	}

	// TestCase -1
	@Test(priority = 1)
	public void loginPageTitleTest() {

		String title = loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");

	}

	// TestCase -2
	@Test(priority = 2)
	public void loginPageCRMImageTest() {

		boolean flag = loginpage.validateCRMImage();
		Assert.assertTrue(flag);

	}

	// TestCase -3
	@Test(priority = 3)
	public void loginTest() {
		
		// login() returns HomePage object
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}

	@AfterMethod
	public void tearDown() {
		
		driver.quit(); // Close all open browsers

	}

}
