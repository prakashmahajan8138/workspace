package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlusCampaignPage {
	
	//initialization
	public PlusCampaignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Declaration
	@FindBy(xpath="//img[@alt='Create Campaign...']")
	private WebElement createCampaignLink;
	
	
	//getter method
	public WebElement getCreateCampaignLink() {
		return createCampaignLink;
	}
	
	//business logic
	public void createCampaignLink()
	{
		createCampaignLink.click();
	}
	
	
	

}
