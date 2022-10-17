package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ValidationandVerificationPage {
	
	
	//Initialization
 public ValidationandVerificationPage(WebDriver driver) {
	 PageFactory.initElements(driver, this);
		
	}
	
 
    //Declaration
 
	@FindBy(css="span.dvHeaderText")
	private WebElement actualOragnisationData;
	
	@FindBy(css="span.lvtHeaderText")
	private WebElement headerText;
	
	@FindBy(xpath="//span[@class=\"dvHeaderText\"]")
	private WebElement verfTitle;
	
	//getter method
	public WebElement getActualOrganisationData()
	{
		return actualOragnisationData;
	}
	
	public WebElement getHeaderText() {
		return headerText;
	}
	
	public WebElement getVerfTitle() {
		return verfTitle;
	}
	//business logic
	public void organisationValidation(WebDriver driver,String Name)
	{
		String actData=actualOragnisationData.getText();
		if(actData.contains(Name))
		{
		System.out.println("pass");
		}
		else
		{
		System.out.println("fail");
		}
	}
	
	public void productValidation(WebDriver driver,String Name)
	{
		String actData=headerText.getText();
		if(actData.contains(Name))
		{
		System.out.println("pass");
		}
		else
		{
		System.out.println("fail");
		}
	}
	
	public void titleVerification(String data) {
		String title = verfTitle.getText();
		if(title.contains(data)) {
			System.out.println("Campaign Created");
		}
		else {
			System.out.println("Campaign Not Created");
		}
	}
	
	
	public String organisationValidation1(WebDriver driver,String Name)
	{
		String actData=actualOragnisationData.getText();
		if(actData.contains(Name))
		{
		return "pass";
		}
		else
		{
		return "fail";
		}
	}

}
