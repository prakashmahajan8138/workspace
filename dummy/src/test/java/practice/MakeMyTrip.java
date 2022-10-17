package practice;


import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MakeMyTrip {

	public static void main(String[] args) throws InterruptedException, IOException, AWTException {
		
		String key="webdriver.chrome.driver";
		String value="./drivers/chromedriver.exe";
		System.setProperty(key, value);
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		Thread.sleep(3000);
		
		
		
		
		FileInputStream fis = new FileInputStream("./data/config.properties");
		Properties prop = new Properties();
		prop.load(fis);
		
		String s1 = prop.getProperty("url");
		
		driver.get(s1);
		
		//choose src and dest
		
		
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		
		Thread.sleep(2000);
		
		String from="Pune, India";
		String to="Mumbai, India";
		
		driver.findElement(By.xpath("//input[@id='fromCity']")).click();
		//(//input[@type='text'])[2]
		driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys(from);
		driver.findElement(By.xpath("(//p[@class='font14 appendBottom5 blackText' and .='"+from+"'])[1]")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='toCity']")).click();
		//driver.findElement(By.id("toCity")).click();
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys(to);
		driver.findElement(By.xpath("//p[text()='"+to+"']")).click();
		
		Thread.sleep(3000);
		
		//choose dates
		//label[@for='departure']
		driver.findElement(By.xpath("//label[@for='departure']")).click();
		
		//p[.='30']/ancestor::div[@class='DayPicker-Months']/descendant::p[.='30']
		
		String date="30";
		String month="September 2022";
		driver.findElement(By.xpath("(//div[text()='"+month+"']/ancestor::div[@class='DayPicker-Months']/descendant::p[.='"+date+"'])[1]")).click();
		Thread.sleep(3000);
		
		
		String month1="October";
		String date1="2";
		String number="2";
		
		//div[@data-cy='returnArea']
		driver.findElement(By.xpath("//div[@data-cy='returnArea']")).click();
		driver.findElement(By.xpath("(//div[text()='"+month1+"']/ancestor::div[@class='DayPicker-Months']/descendant::p[.='"+date1+"'])[2]")).click();
		
		driver.findElement(By.xpath("//label[@for='travellers']")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//li[@data-cy='adults-"+number+"']")).click();
		Thread.sleep(1500);
		
		driver.findElement(By.xpath("//button[text()='APPLY']")).click();
		
		driver.findElement(By.xpath("//a[text()='Search']")).click();
		
		

		
		driver.close();

	}

}
