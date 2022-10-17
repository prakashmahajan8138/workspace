package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//Initialization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//"this"--> keyword has hold the address of the loginpage
	//it gives the control to the -->"driver"
	//now it will perform all the activities using "driver reference"
	
	

	//Declaration
	@FindBy(name="user_name")
	private WebElement userNameTextField;
    
	@FindBy(name="user_password")
	private WebElement passwordTextField;
	
	@FindBy(id="submitButton")
	private WebElement submitButton;
	
	
	
	//getters Methods
	
	public WebElement getUserNameTextField() {
		return userNameTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}
	
	//Buisness Logic
	/**
	 * this method is used to login the app
	 * @author prakash
	 * */
	
	public void login(String userName,String password)
	{
		userNameTextField.sendKeys(userName);
		passwordTextField.sendKeys(password);
		submitButton.click();
	}

}
