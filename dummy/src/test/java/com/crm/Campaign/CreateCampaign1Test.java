package com.crm.Campaign;

import org.testng.annotations.Test;
import com.crm.ObjectRepository.CreateCampaignPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.PlusCampaignPage;
import com.crm.generic_utility.BaseClass;
import com.crm.generic_utility.Excel_Utility;
import com.crm.generic_utility.Java_Utility;

public class CreateCampaign1Test extends BaseClass {

	@Test(groups= {"regressionTest"})
	public  void createCampaign2Test() throws Throwable{




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
		



	}
}
