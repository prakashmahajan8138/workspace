package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlusProductPage {

	//Initialization
	public PlusProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Declaration
	@FindBy(xpath="//img[@alt='Create Product...']")
	private WebElement createProductLink;




	//getter Method
	public WebElement getCreateProductLink() {
		return createProductLink;
	}

	//business logic
	public void createProductLink()
	{
		createProductLink.click();
	}
}
