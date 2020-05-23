package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.*;

public class TestBase {

	// Global Variable
	public static WebDriver driver;
	public static Properties prop; 

	public TestBase() {

		// Read Properties file
		try {
			prop = new Properties();

			FileInputStream ip = new FileInputStream(
					"C:\\Users\\rajar\\Eclipse Workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\util\\config.properties");

			prop.load(ip);
		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void initialization() {

		String browsername = prop.getProperty("browser");

		// Launch ChromeDriver
		if (browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\rajar\\Eclipse Workspace\\FreeCRMTest\\Resources\\chromedriver.exe");
			driver = new ChromeDriver();

		}

		// Launch FireFox
		else if (browsername.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\rajar\\Eclipse Workspace\\FreeCRMTest\\Resources\\geckodriver.exe");
			driver = new FirefoxDriver();

		}
		
		else {
			
			System.out.println("Invalid Browser!!");
			
		}

		// Browser Specific Activities
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		// Parameterize the timeouts
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

		//Open URL
		driver.get(prop.getProperty("url"));

	}
	
}