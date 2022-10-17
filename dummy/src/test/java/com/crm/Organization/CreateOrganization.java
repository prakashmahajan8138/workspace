package com.crm.Organization;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.generic_utility.Excel_Utility;
import com.crm.generic_utility.File_Utility;
import com.crm.generic_utility.Java_Utility;

public class CreateOrganization {
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
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		WebElement OrgName = driver.findElement(By.xpath("//input[@name='accountname']"));
		
		Java_Utility jlib=new Java_Utility();
		int ranNum = jlib.getRanDomNum();
		
		
		
		Excel_Utility elib = new Excel_Utility();
		String Name = elib.getDataFromExcel("Organizations", 0, 0)+ranNum;
		OrgName.sendKeys(Name);
		
		driver.findElement(By.xpath("(//input[@accesskey='S'])[1]")).click();
		
		driver.close();
		
		
		
		
		
        
	}

}
