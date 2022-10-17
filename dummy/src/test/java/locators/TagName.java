package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TagName {
	public static WebDriver driver;
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver=new ChromeDriver();
		//used to launch the browser
		driver.get("www.google.com");
		
		driver.findElement(By.tagName("")).sendKeys("");
		driver.findElement(By.id(""));
		driver.findElement(By.name(""));
		driver.findElement(By.className(""));
		driver.findElement(By.linkText(""));
		By all = By.cssSelector("");
		System.out.println("prakash");
		}

}
