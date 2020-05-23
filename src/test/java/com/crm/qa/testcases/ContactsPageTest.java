package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.NewContactsPage;
import com.crm.qa.util.TestUtil;

//@Listeners(com.crm.qa.base.TestListener.class) // Add listener
public class ContactsPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	NewContactsPage newContactsPage;

	public ContactsPageTest() {

		super(); // Read prop file

	}

	@BeforeMethod
	public void setup() {

		initialization();

		testUtil = new TestUtil();
		loginPage = new LoginPage();

		// Navigate to ContactsPage
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame("mainpanel");

	}

	@Test(priority = 1)
	public void verifyContactsPageLabelTest() {
		contactsPage = homePage.clickOnContactsLink();
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "Contact label not found..");

	}

	@DataProvider
	public Object[][] getCRMData() {
		Object[][] testdata = TestUtil.getData("contact");
		return testdata;
	}

	@Test(priority = 2, dataProvider = "getCRMData")
	public void validateCreateNewContactTest(String fname, String lname, String company) throws InterruptedException {

		newContactsPage = homePage.clickOnNewContactLink();
		//Thread.sleep(10000);
		newContactsPage.createNewContact(fname, lname, company);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

}
