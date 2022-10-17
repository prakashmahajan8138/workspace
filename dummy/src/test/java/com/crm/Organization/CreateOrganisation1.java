package com.crm.Organization;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.ObjectRepository.CreateOrganisationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.PlusOrganisationPage;
import com.crm.generic_utility.Excel_Utility;
import com.crm.generic_utility.File_Utility;
import com.crm.generic_utility.Java_Utility;
import com.crm.generic_utility.WebDriver_Utility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganisation1 {
	public static void main(String[] args) throws Throwable {
		File_Utility flib = new File_Utility();
		String BROWSER =flib.getPropertyKeyValue("browser");
		WebDriver driver;
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
		
		
		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.waitForPageToLoad(driver);
		
		String url = flib.getPropertyKeyValue("url1");
		driver.get(url);
		
		String userName = flib.getPropertyKeyValue("usn");
		String password = flib.getPropertyKeyValue("pwd");
		
		LoginPage lp = new LoginPage(driver);
		lp.login(userName, password);
		
		Java_Utility jlib = new Java_Utility();
		int ran = jlib.getRanDomNum();
		
		HomePage hp = new HomePage(driver);
		hp.clickOrganisation();
		PlusOrganisationPage po = new PlusOrganisationPage(driver);
		po.createorganisationLink();
		
		Excel_Utility elib = new Excel_Utility();
		String orgName = elib.getDataFromExcel("Organizations", 0, 0)+ran;
		
		CreateOrganisationPage cp = new CreateOrganisationPage(driver);
		cp.createorganisation(orgName);
		
		Thread.sleep(3000);
		
		hp.signoutLink(driver);
		
		
		
		
		
	}

}
