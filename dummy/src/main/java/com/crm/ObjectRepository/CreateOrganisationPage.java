package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganisationPage {
	
	//Initialization
	
	public CreateOrganisationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	//Declaration
	
	@FindBy(xpath="//input[@name='accountname']")
	private WebElement AccountNameTextField;
	
	@FindBy(xpath="//input[@accesskey='S']")
	private WebElement saveButton;
	
	
	//getter Method
	
	public WebElement getAccountNameTextField() {
		return AccountNameTextField;
	}


	public WebElement getSaveButton() {
		return saveButton;
	}
	
	//business logic
	//for details and save button
	public void createorganisation(String orgName) {
		AccountNameTextField.sendKeys(orgName);
		saveButton.click();
	}
	
	
	
	
	
	
	

}
