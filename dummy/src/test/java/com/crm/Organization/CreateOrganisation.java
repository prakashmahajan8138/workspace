package com.crm.Organization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.asserts.SoftAssert;

import com.crm.ObjectRepository.ValidationandVerificationPage;
import com.crm.generic_utility.Excel_Utility;
import com.crm.generic_utility.File_Utility;
import com.crm.generic_utility.Java_Utility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganisation {
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
		
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		Java_Utility jlib=new Java_Utility();
		int ranNum = jlib.getRanDomNum();
		
		Excel_Utility elib = new Excel_Utility();
		String Name = elib.getDataFromExcel("Organizations", 0, 0)+ranNum;
		
		WebElement OrgName = driver.findElement(By.xpath("//input[@name='accountname']"));
		OrgName.sendKeys(Name);
		
		driver.findElement(By.xpath("(//input[@accesskey='S'])[1]")).click();
		
		
		
		
		Thread.sleep(2000);
		String actData = driver.findElement(By.cssSelector("span.dvHeaderText")).getText();
		System.out.println(actData);
		if(actData.contains(Name))
		{
		System.out.println("pass");
		}
		else
		{
		System.out.println("fail");
		}
		 
		
		
		
	}
	

}
