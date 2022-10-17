package com.crm.generic_utility;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class File_Utility 
{
	WebDriver driver;
	/**
	 * This method is used to launch the application
	 * @param Key
	 * @return
	 * @throws Throwable
	 * @author Prakash
	 */
	public String getPropertyKeyValue(String Key) throws Throwable
	{
		FileInputStream fis = new FileInputStream("./data/config.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String value = prop.getProperty(Key);
		return value;
	}
	
	public void setUp() throws Throwable {
        
	    //new File_Utility();
		//read the browse value
		String browserValue1=getPropertyKeyValue("browser");
		if(browserValue1.equalsIgnoreCase("chrome"))
		{
			//avoid illegal exception
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();

		}
		else if(browserValue1.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();



		}
		else if(browserValue1.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver();
			driver=new EdgeDriver();



		}
		else
		{
			System.out.println("invalid choice");
		}

	}

}
