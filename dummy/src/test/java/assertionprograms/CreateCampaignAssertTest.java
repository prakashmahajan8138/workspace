package assertionprograms;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.ObjectRepository.CreateCampaignPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.PlusCampaignPage;
import com.crm.generic_utility.BaseClass;
import com.crm.generic_utility.Excel_Utility;
import com.crm.generic_utility.Java_Utility;
@Listeners(com.crm.generic_utility.ListenerImplementation.class)
public class CreateCampaignAssertTest extends BaseClass {

	@Test(groups= {"regressionTest"})
	public  void createCampaign2Test() throws Throwable{




		Java_Utility jlib = new Java_Utility();
		int ran = jlib.getRanDomNum();

		HomePage hp = new HomePage(driver);
		hp.clickOnmoreLink(driver);
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(false, true);

		hp.clickCampaign();



		PlusCampaignPage cp = new PlusCampaignPage(driver);
		cp.createCampaignLink();

		Excel_Utility elib = new Excel_Utility();
		String campaignName = elib.getDataFromExcel("campaign", 0, 0)+ran;

		CreateCampaignPage ccp = new CreateCampaignPage(driver);
		ccp.campaignNameTextField(campaignName);
		ccp.saveButton();
		soft.assertAll();



	}
}
