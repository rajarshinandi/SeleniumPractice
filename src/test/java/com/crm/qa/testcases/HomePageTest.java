package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	public HomePageTest() {
		super(); // Read properties
		
	}
	
	@BeforeMethod
	public void setUp() {

		initialization(); 				// Perform all browser setup activities
		loginPage = new LoginPage(); 	// New LoginPage object to access all the webElemenrs and methods of LoginPage
		testUtil = new TestUtil();
		
		homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password")); //HomePage object
		contactsPage = new ContactsPage();	//Landing Page reference
	
	}
	
	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO", "HomePage title not matched..");
	
	}
	
	@Test (priority = 2)
	public void verifyUsernameTest() {
		testUtil.switchToFrame("mainpanel");
		Assert.assertTrue(homePage.verifyUserName());

	}
	
	@Test (priority = 3)
	public void verifyContactsLinkTest() {
		testUtil.switchToFrame("mainpanel");
		contactsPage = homePage.clickOnContactsLink();
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}	
	
}
