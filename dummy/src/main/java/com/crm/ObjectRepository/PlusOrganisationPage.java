package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlusOrganisationPage {

	//initialization
	public PlusOrganisationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	//decaration
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createOrganisationLink;

	//getter method
	public WebElement getCreateOrganisationLink() {
		return createOrganisationLink;
	}

	//business logic

	public void createorganisationLink() {

		createOrganisationLink.click();
	}



}
