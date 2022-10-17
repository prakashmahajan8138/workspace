package dataProvider;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.ObjectRepository.LoginPage;
import com.crm.generic_utility.File_Utility;

public class DataProvider_Test {

	WebDriver driver;
	@Test(dataProvider = "dataprovider1")
	public  void demoDataProviderTest(String prodName,String prodCode,String qty) throws Throwable {

		String key1="webdriver.edge.driver";
		String value1="./drivers/msedgedriver.exe";

		System.setProperty(key1, value1);
		WebDriver driver=new EdgeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		File_Utility flib = new File_Utility();
		String url = flib.getPropertyKeyValue("url1");
		String username = flib.getPropertyKeyValue("usn");
		String password = flib.getPropertyKeyValue("pwd");
		driver.get(url);
		LoginPage lp = new LoginPage(driver);
		lp.login(username, password);
	
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();

		

		
		driver.findElement(By.name("productname")).sendKeys(prodName);
		driver.findElement(By.xpath("//input[@id='productcode']")).sendKeys(prodCode);
		driver.findElement(By.id("qtyinstock")).sendKeys(qty);

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		Thread.sleep(1000);

		driver.quit();
		
	}
		@DataProvider
		public Object[][] dataprovider1() 
		{
			Object[][]data=new Object[5][3];
			
			data[0][0]="bike";
			data[0][1]="B012";
			data[0][2]="1500";
			
			data[1][0]="bike1";
			data[1][1]="B0121";
			data[1][2]="150";
			
			data[2][0]="bike2";
			data[2][1]="B0122";
			data[2][2]="1501";


			data[3][0]="bike3";
			data[3][1]="B0123";
			data[3][2]="1502";
			
			
			data[4][0]="bike4";
			data[4][1]="B0124";
			data[4][2]="1502";
			
			
			return data;
			
			}
		

	}




