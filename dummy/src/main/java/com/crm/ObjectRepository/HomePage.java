package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.generic_utility.WebDriver_Utility;

public class HomePage {
	
	//Initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//declaration 
	@FindBy(xpath="//a[text()='Organizations']") 
	private WebElement organistionButton;
	
	@FindBy(xpath="//a[text()='Products']")
	private WebElement productButton;
	
	@FindBy(xpath="//a[text()='More']")
	private WebElement moreLink;
	
	@FindBy(name="Campaigns")
	private WebElement campaignButton; 
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement signoutLink;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signoutButton;
	
	//getter methods

	public WebElement getOrganistionButton() {
		return organistionButton;
	}

	public WebElement getProductButton() {
		return productButton;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getCampaignButton() {
		return campaignButton;
	}
	
	public WebElement getSignoutLink() {
		return signoutLink;
	}

	public WebElement getSignoutButton() {
		return signoutButton;
	}

		//Buisness Logic
		/**
		 * this method is used to homepage the app
		 * @author prakash
		 * */
	
	//click organisation
	public void clickOrganisation() {
		organistionButton.click();
		
	}
	
	//click product
	public void clickProduct() {
		productButton.click();
	}
	
	//business logic for more link
	public void clickOnmoreLink(WebDriver driver) {
		WebDriver_Utility wlib=new WebDriver_Utility();
		wlib.mouseOverOnElement(driver, moreLink);
		
	}
	
	//business logic for campaign button
	public void clickCampaign() {
	campaignButton.click();
	}
	
	//business logic for signoutlink
	
	public void signoutLink(WebDriver driver) {
//		WebDriver_Utility wlib = new WebDriver_Utility();
//		wlib.mouseOverOnElement(driver, signoutLink);
		signoutLink.click();
		signoutButton.click();
	}
	
	
	
	
	
	
	

}
