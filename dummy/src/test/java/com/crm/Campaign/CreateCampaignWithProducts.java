package com.crm.Campaign;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.generic_utility.WebDriver_Utility;

public class CreateCampaignWithProducts 
{
	public static void main(String[] args) throws Throwable 
	{

		
		
		WebDriver_Utility wlib=new WebDriver_Utility();
		

		String Key="webdriver.chrome.driver";
		String value="./drivers/chromedriver.exe";
		System.setProperty(Key, value);
		WebDriver driver=new ChromeDriver();

		wlib.waitForPageToLoad(driver);
		//driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        //launching application 
		FileInputStream fis=new FileInputStream("./data/config.properties");
		Properties pro=new Properties();
		pro.load(fis);
		String URL = pro.getProperty("url1");
	    
		//entering creds
		String UserName = pro.getProperty("usn");
		String PassWord = pro.getProperty("pwd");

		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(UserName);
		driver.findElement(By.name("user_password")).sendKeys(PassWord);
		driver.findElement(By.id("submitButton")).click();
        
		//creating product
		//product data
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();

		Random ran =new Random();
		int RanNum = ran.nextInt(1000);
		
		//reading product from excel
		FileInputStream fis2=new FileInputStream("./data/creds.xlsx");
		Workbook book1=WorkbookFactory.create(fis2);
		Sheet sh1 = book1.getSheet("Product");
		Row row1 = sh1.getRow(0);
		Cell cell = row1.getCell(0);
        
		
		//entering product name
		String productdata = cell.getStringCellValue()+RanNum;
		driver.findElement(By.name("productname")).sendKeys(productdata);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		//Navigate to Campaign
		driver.findElement(By.linkText("More")).click();
		driver.findElement(By.linkText("Campaigns")).click();
		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();

        //reading campaignname
		FileInputStream fis1=new FileInputStream("./data/creds.xlsx");
		Workbook book=WorkbookFactory.create(fis1);
		Sheet sh = book.getSheet("Campaign");
		Row row = sh.getRow(0);
		Cell cel = row.getCell(0);
		String data = cel.getStringCellValue()+RanNum;
		
		//entering campaign name
		driver.findElement(By.name("campaignname")).sendKeys(data);
		driver.findElement(By.xpath("//img[@title='Select']")).click();

        //switching control to products
		Set<String> allId = driver.getWindowHandles();
		Iterator<String> it=allId.iterator();
		while(it.hasNext())
		{
			String wid = it.next();
			driver.switchTo().window(wid);
			if(driver.getTitle().contains("Products&action"))
			{
				break;
			}
		}
		
		//sending product name to search text field
		driver.findElement(By.id("search_txt")).sendKeys(productdata) ;
		driver.findElement(By.name("search")).click();

		//Dynamic xpath
		driver.findElement(By.xpath("//a[text()='"+productdata+"']")).click();

		//switching back control to campaign
		Set<String> allId1 = driver.getWindowHandles();
		Iterator<String> it1=allId1.iterator();
		while(it1.hasNext())
		{
			String wid = it1.next();
			driver.switchTo().window(wid);
			if(driver.getTitle().contains("Campaigns&action"))
			{
				break;
			}
		}
		
		driver.findElement(By.xpath("(//input[@accesskey='S'])")).click();
		
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

		driver.quit();
	}

}