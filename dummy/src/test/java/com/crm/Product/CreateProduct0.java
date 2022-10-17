package com.crm.Product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.generic_utility.Excel_Utility;
import com.crm.generic_utility.File_Utility;
import com.crm.generic_utility.Java_Utility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProduct0 {

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

		String URL = flib.getPropertyKeyValue("url1");
		String username = flib.getPropertyKeyValue("usn");
		String password = flib.getPropertyKeyValue("pwd");
		driver.get(URL);

		WebElement usn = driver.findElement(By.xpath("//input[@name='user_name']"));
		usn.sendKeys(username);

		WebElement pwd = driver.findElement(By.xpath("//input[@name='user_password']"));
		pwd.sendKeys(password);

		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("//a[text()='Products']")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		
		Java_Utility jlib=new Java_Utility();
		int ranNum = jlib.getRanDomNum();
		
		
		
		Excel_Utility elib = new Excel_Utility();
		String productName = elib.getDataFromExcel("product", 0, 0)+ranNum;
		
		WebElement prodName = driver.findElement(By.xpath("//input[@name='productname']"));
		prodName.sendKeys(productName);
		
		driver.findElement(By.xpath("(//input[@accesskey='S'])[1]")).click();
		
		
		String actData = driver.findElement(By.cssSelector("span.lvtHeaderText")).getText();
		System.out.println(actData);
		if(actData.contains(productName))
		{
		System.out.println("pass");
		}
		else
		{
		System.out.println("fail");
		}
		
		
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	    
		//closing browser
		driver.quit();



	}

}
