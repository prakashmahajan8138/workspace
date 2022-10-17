package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPage {
	
	//Initialization
	public CreateCampaignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//declaration
	@FindBy(name="campaignname")
	private WebElement campaignNameTextField;
	
	@FindBy(xpath="//input[@accesskey='S']")
	private WebElement saveButton;
	
	@FindBy(xpath="//img[@title='Select']")
	private WebElement plusProductlink;
	
	
	
    //getter methods
	public WebElement getCampaignNameTextField() {
		return campaignNameTextField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getPlusProductlink() {
		return plusProductlink;
	}
	
	//business logic for entering campaign name
	public void campaignNameTextField(String campaignName)
	{
		campaignNameTextField.sendKeys(campaignName);
	}
	
	//for saving
	public void saveButton()
	{
		saveButton.click();
	}
	
	//for clicking on plus sign
	public void clickOnplus()
	{
		plusProductlink.click();
	}
	
	
}
