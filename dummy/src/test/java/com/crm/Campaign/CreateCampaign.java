package com.crm.Campaign;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import com.crm.generic_utility.Excel_Utility;
import com.crm.generic_utility.File_Utility;

public class CreateCampaign {

	//static String key="webdriver.chrome.driver";
	static String key1="webdriver.edge.driver";
	//static String value="./drivers/chromedriver.exe";
	static String value1="./drivers/msedgedriver.exe";

	public static void main(String[] args) throws Throwable {
		System.setProperty(key1, value1);
		//WebDriver driver=new ChromeDriver();
		WebDriver driver=new EdgeDriver();

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
		
		WebElement target = driver.findElement(By.xpath("//a[text()='More']"));
		target.click();
		//WebDriver_Utility wlib = new WebDriver_Utility();
		//wlib.mouseHover(target);
		driver.findElement(By.name("Campaigns")).click();
		
		//Creating product
		
		driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		WebElement cname = driver.findElement(By.xpath("//input[@name='campaignname']"));
		
		//reading data from excel
		Excel_Utility Cname=new Excel_Utility();
		String campname = Cname.getDataFromExcel("campaign", 0, 0);
		cname.sendKeys(campname);
		
		//Save campaign
		driver.findElement(By.xpath("(//input[@accesskey='S'])[1]")).click();
		
		
		//Delete campaign
		driver.findElement(By.xpath("(//input[@accesskey='D'])[1]")).click();
		
		//handling alert popup
		Alert al = driver.switchTo().alert();
		al.accept();
		
		//wlib.acceptAlertPopup();
		
		//Logout
		
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	    
		//closing browser
		driver.quit();
	}

}
