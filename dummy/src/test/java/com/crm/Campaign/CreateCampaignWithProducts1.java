package com.crm.Campaign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.ObjectRepository.CreateCampaignPage;
import com.crm.ObjectRepository.CreateProductPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.PlusCampaignPage;
import com.crm.ObjectRepository.PlusProductPage;
import com.crm.ObjectRepository.ProductPopUpPage;
import com.crm.generic_utility.Excel_Utility;
import com.crm.generic_utility.File_Utility;
import com.crm.generic_utility.Java_Utility;
import com.crm.generic_utility.WebDriver_Utility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaignWithProducts1 {
	public static WebDriver driver;

	public static void main(String[] args) throws Throwable {
		
		File_Utility flib = new File_Utility();
		WebDriver_Utility wlib=new WebDriver_Utility();
		
		
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
		
		
		String url = flib.getPropertyKeyValue("url1");
		driver.get(url);
		
		wlib.waitForPageToLoad(driver);
		
		String userName = flib.getPropertyKeyValue("usn");
		String password = flib.getPropertyKeyValue("pwd");
		
		LoginPage lp = new LoginPage(driver);
		lp.login(userName, password);
		
		HomePage hp = new HomePage(driver);
		hp.clickProduct();
		
	    PlusProductPage ppp = new PlusProductPage(driver);
	    ppp.createProductLink();
	    
	    Java_Utility jlib = new Java_Utility();
	    int ran = jlib.getRanDomNum();
	    
	    Excel_Utility elib = new Excel_Utility();
	    String productName = elib.getDataFromExcel("product", 0, 0)+ran;
	    CreateProductPage cpp = new CreateProductPage(driver);
	    cpp.createProduct(productName);
	    
	    hp.clickOnmoreLink(driver);
	    hp.clickCampaign();
	    
	    PlusCampaignPage pcp = new PlusCampaignPage(driver);
	    pcp.createCampaignLink();
	    
	    
	    String campaignName = elib.getDataFromExcel("campaign", 0, 0)+ran;
	    CreateCampaignPage ccp = new CreateCampaignPage(driver);
	    ccp.campaignNameTextField(campaignName);
	    ccp.clickOnplus();
	    
	    
	    wlib.switchToWindow(driver, "Products&action");
	    
	    
	    ProductPopUpPage pop = new ProductPopUpPage(driver);
	    pop.searchProductLink(productName);
	    
	    driver.findElement(By.xpath("//a[text()='"+productName+"']")).click();
	    
	    wlib.switchToWindow(driver, "Campaigns&action");
	    
	    ccp.saveButton();
	    
	    hp.signoutLink(driver);
	    wlib.quitWindow(driver);
	    
	    

	}

}
