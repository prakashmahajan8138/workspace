package com.crm.Product;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.generic_utility.Excel_Utility;
import com.crm.generic_utility.File_Utility;
import com.crm.generic_utility.Java_Utility;
import com.crm.generic_utility.WebDriver_Utility;

public class CreateProduct {
	static String key="webdriver.chrome.driver";
	static String value="./drivers/chromedriver.exe";

	public static void main(String[] args) throws Throwable {
		System.setProperty(key, value);
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		File_Utility flib = new File_Utility();
		String url = flib.getPropertyKeyValue("url1");
		driver.get(url);
		String username = flib.getPropertyKeyValue("usn");
		String password = flib.getPropertyKeyValue("pwd");
		
		
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
		 
		
		 driver.findElement(By.xpath("(//input[@accesskey='D'])[1]")).click();
		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.switchToAlertAndAccpect(driver);
		
		
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		
		
		driver.quit();

	}

}
