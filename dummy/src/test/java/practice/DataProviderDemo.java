package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.ObjectRepository.LoginPage;
import com.crm.generic_utility.File_Utility;

public class DataProviderDemo {
	
	WebDriver driver;
	@Test(dataProvider = "dataprovider1")
	public void testVtigerInLogin(String username,String password ) throws Throwable
	{
		String key1="webdriver.edge.driver";
		String value1="./drivers/msedgedriver.exe";

		System.setProperty(key1, value1);
		WebDriver driver=new EdgeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		File_Utility flib = new File_Utility();
		String url = flib.getPropertyKeyValue("url1");
		driver.get(url);
		LoginPage lp = new LoginPage(driver);
		lp.login(username, password);
	}
	
	
	
	@DataProvider
	public Object[][] dataprovider1() 
	{
		Object[][]data=new Object[5][2];
		
		data[0][0]="admin";
		data[0][1]="manager123";
		
		data[1][0]="manager";
		data[1][1]="manager123";
		
		data[2][0]="ad13";
		data[2][1]="manager123";
		
		data[3][0]="admin#123";
		data[3][1]="manager123";
		
		data[4][0]="manager1@133";
		data[4][1]="manager123";
		
		
		return data;
		
		}
	}


