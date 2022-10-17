package com.crm.Organization;

import org.testng.annotations.Test;

import com.crm.ObjectRepository.CreateOrganisationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.PlusOrganisationPage;
import com.crm.generic_utility.BaseClass;
import com.crm.generic_utility.Excel_Utility;
import com.crm.generic_utility.Java_Utility;
import com.crm.generic_utility.WebDriver_Utility;

public class CreateOrganisationTest extends BaseClass {
	@Test
	public void createOrganisationTest()throws Throwable {
		
		
		
		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.waitForPageToLoad(driver);
		
		Java_Utility jlib = new Java_Utility();
		int ran = jlib.getRanDomNum();
		
		HomePage hp = new HomePage(driver);
		hp.clickOrganisation();
		PlusOrganisationPage po = new PlusOrganisationPage(driver);
		po.createorganisationLink();
		
		Excel_Utility elib = new Excel_Utility();
		String orgName = elib.getDataFromExcel("Organizations", 0, 0)+ran;
		
		CreateOrganisationPage cp = new CreateOrganisationPage(driver);
		cp.createorganisation(orgName);
		Thread.sleep(2000);		
		
		
		
		
		
		
		
	}

}
