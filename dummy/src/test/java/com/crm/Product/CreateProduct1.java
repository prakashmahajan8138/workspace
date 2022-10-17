package com.crm.Product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.ObjectRepository.CreateProductPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.PlusProductPage;
import com.crm.ObjectRepository.ProductInfoPage;
import com.crm.generic_utility.Excel_Utility;
import com.crm.generic_utility.File_Utility;
import com.crm.generic_utility.Java_Utility;
import com.crm.generic_utility.WebDriver_Utility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProduct1 {

	public static void main(String[] args) throws Throwable {
		
		//launching browser
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
		
		
		//fetching username,password and url from excelsheet
        String userName = flib.getPropertyKeyValue("usn");
        String password = flib.getPropertyKeyValue("pwd");
        String url = flib.getPropertyKeyValue("url1");
        
        driver.get(url);
        
        //Authentication
        LoginPage lp = new LoginPage(driver);
        lp.login(userName, password);
     
        //clicking on product link
        
        HomePage hp = new HomePage(driver);
        hp.clickProduct();
        
      //clicking on plus sign
        PlusProductPage ppp = new PlusProductPage(driver);
        ppp.createProductLink();
        
        Java_Utility jlib = new Java_Utility();
        int ran = jlib.getRanDomNum();
        
      //fetching product name from excel
        Excel_Utility elib = new Excel_Utility();
        String productName = elib.getDataFromExcel("product", 0, 0)+ran;
        
        //creating product
        CreateProductPage cpp = new CreateProductPage(driver);
        cpp.createProduct(productName);
        
        //validation
        ProductInfoPage pip = new ProductInfoPage(driver);
        String actData = pip.ValidationText();
		System.out.println(actData);
		if(actData.contains(productName))
		{
		System.out.println("pass");
		}
		else
		{
		System.out.println("fail");
		}
       
		hp.signoutLink(driver);
		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.quitWindow(driver);
	}

}
