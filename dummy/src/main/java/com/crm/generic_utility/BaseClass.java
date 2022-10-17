package com.crm.generic_utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {
	public WebDriver driver;
	public static WebDriver sDriver;
	File_Utility flib = new File_Utility();
	
	@BeforeSuite(groups = {"smokeTest","regressionTest"})
	public void beforeSuite()
	{
		System.out.println("DataBaseConnectionOpen");
	}
	@BeforeTest(groups = {"smokeTest","regressionTest"})
	public void beforeTest()
	{
		System.out.println("execute parrallel");
	}
	//@Parameters("BROWSER")
	@BeforeClass(groups = {"smokeTest","regressionTest"})
	public void beforeClass() throws Throwable
	//public void beforeClass(String BROWSER) throws Throwable
	{
		System.out.println("Launch browser");
		
		String BROWSER =flib.getPropertyKeyValue("browser");
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		}
		else
		{
		driver = new ChromeDriver();
		}
		
		sDriver=driver;
	}
	@BeforeMethod(groups = {"smokeTest","regressionTest"})
	public void beforeMethod() throws Throwable
	{
		String url = flib.getPropertyKeyValue("url1");
		driver.get(url);
		System.out.println("LoginApplication");
		String userName = flib.getPropertyKeyValue("usn");
		String password = flib.getPropertyKeyValue("pwd");
		
		LoginPage lp = new LoginPage(driver);
		lp.login(userName, password);
	}
	@AfterMethod(groups = {"smokeTest","regressionTest"})
	public void afterMethod()
	{
		System.out.println("LogoutApplication");
		HomePage hp = new HomePage(driver);
		hp.signoutLink(driver);
	}
	@AfterClass(groups = {"smokeTest","regressionTest"})
	public void afterClass()
	{
		System.out.println("closing browser");
		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.quitWindow(driver);
	}
	@AfterTest(groups = {"smokeTest","regressionTest"})
	public void afterTest()
	{
		System.out.println("executed successfully");
		
	}
	@AfterSuite(groups = {"smokeTest","regressionTest"})
	public void afterSuite()
	{
		System.out.println("DataBaseConnectionClosed");
	}
}
