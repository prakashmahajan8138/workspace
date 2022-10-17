package assertionprograms;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.ObjectRepository.CreateCampaignPage;
import com.crm.ObjectRepository.CreateProductPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.PlusCampaignPage;
import com.crm.ObjectRepository.PlusProductPage;
import com.crm.ObjectRepository.ProductPopUpPage;
import com.crm.generic_utility.BaseClass;
import com.crm.generic_utility.Excel_Utility;
import com.crm.generic_utility.Java_Utility;
import com.crm.generic_utility.WebDriver_Utility;
@Listeners(com.crm.generic_utility.ListenerImplementation.class)

public class CreateCampWithProdAssertTest extends BaseClass{
    
	@Test
	public  void createCampaignWithProductTest() throws Throwable {
		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.waitForPageToLoad(driver);
		HomePage hp = new HomePage(driver);
		hp.clickProduct();
		
	    PlusProductPage ppp = new PlusProductPage(driver);
	    ppp.createProductLink();
	    
	    Java_Utility jlib = new Java_Utility();
	    int ran = jlib.getRanDomNum();
	    
	    Excel_Utility elib = new Excel_Utility();
	    String productName = elib.getDataFromExcel("product", 0, 0)+ran;
	    CreateProductPage cpp = new CreateProductPage(driver);
	    cpp.createProduct(productName);
	    
	    hp.clickOnmoreLink(driver);
	    hp.clickCampaign();
	    
	    
	    SoftAssert soft = new SoftAssert();
		soft.assertEquals(false, true);
	    
	    PlusCampaignPage pcp = new PlusCampaignPage(driver);
	    pcp.createCampaignLink();
	    
	    
	    String campaignName = elib.getDataFromExcel("campaign", 0, 0)+ran;
	    CreateCampaignPage ccp = new CreateCampaignPage(driver);
	    ccp.campaignNameTextField(campaignName);
	    ccp.clickOnplus();
	    
	    
	    wlib.switchToWindow(driver, "Products&action");
	    
	    
	    ProductPopUpPage pop = new ProductPopUpPage(driver);
	    pop.searchProductLink(productName);
	    
	    driver.findElement(By.xpath("//a[text()='"+productName+"']")).click();
	    
	    wlib.switchToWindow(driver, "Campaigns&action");
	    
	    ccp.saveButton();
	    soft.assertAll();
	    
	    
	    
	    
	    

	}

}
