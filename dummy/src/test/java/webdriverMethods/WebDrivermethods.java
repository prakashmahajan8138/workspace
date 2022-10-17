package webdriverMethods;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDrivermethods {
	public WebDriver driver;
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver=new ChromeDriver();
		//used to launch the browser
		driver.get("www.google.com");
		
		//to maximize the window
		driver.manage().window().maximize();
		
		//for setting the dimension of browser
		Dimension targetPosition = new Dimension(200,300);
		driver.manage().window().setSize(targetPosition);
		
		//to set the position of browser in window
		Point target = new Point(500,300);
		driver.manage().window().setPosition(target);
		
		//to get the current url
		String url = driver.getCurrentUrl();
		System.out.println(url);
		
		//to get the source code of current webpage
		String pageSource = driver.getPageSource();
		System.out.println(pageSource);
		
		//to get the title of webpage
		String title = driver.getTitle();
		System.out.println(title);
		
		//to get the address of the current webpage
	    String parentHandle = driver.getWindowHandle();
	    System.out.println(parentHandle);
	    
	    //to perform refresh the page
	    driver.navigate().refresh();
	    
	    //for navigate to other webpage
	    driver.navigate().to("selenium.dev");
	    
	    

		
	    //to get the address of the all webpages that are open
	    Set<String> handles = driver.getWindowHandles();
	    Iterator<String> iterator = handles.iterator();
	    while(iterator.hasNext())
	    {
	    	String handle = iterator.next();
	    	System.out.println(handle);
	    	if(!handle.equals(parentHandle))
	    	{
	    		driver.switchTo().window(handle);
	    	}
	    	
	    	//to close the parent windows
		    driver.close();
	    }
	    
	    // to close all parent and child windows
	    driver.quit();
	    
	   Dimension size = driver.manage().window().getSize();
		
		System.out.println("done successfully");
	    
	    
	    
		
	    		
	}

}
