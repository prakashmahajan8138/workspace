package dummy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.ObjectRepository.CreateCampaignPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.PlusCampaignPage;
import com.crm.generic_utility.Excel_Utility;
import com.crm.generic_utility.Java_Utility;
import com.crm.generic_utility.WebDriver_Utility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaignTest {

	@Test
	public void parameterTest() throws Throwable {
		
		String BROWSER = System.getProperty("browser");
		
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
		
		
		String url = System.getProperty("url1");
		
		driver.get(url);
		
		String userName = System.getProperty("usn");
		String password = System.getProperty("pwd");
		

		
		LoginPage lp = new LoginPage(driver);
		lp.login(userName, password);
		
		Java_Utility jlib = new Java_Utility();
		int ran = jlib.getRanDomNum();
		
		
		HomePage hp = new HomePage(driver);
		hp.clickOnmoreLink(driver);
		
		hp.clickCampaign();
		
		PlusCampaignPage cp = new PlusCampaignPage(driver);
		cp.createCampaignLink();
		
		Excel_Utility elib = new Excel_Utility();
		String campaignName = elib.getDataFromExcel("campaign", 0, 0)+ran;
		
		CreateCampaignPage ccp = new CreateCampaignPage(driver);
		ccp.campaignNameTextField(campaignName);
		ccp.saveButton();
		
		hp.signoutLink(driver);
		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.quitWindow(driver);
		
	}
}
