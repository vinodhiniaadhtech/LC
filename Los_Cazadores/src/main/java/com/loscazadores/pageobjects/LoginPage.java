package com.loscazadores.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.loscazadores.actiondriver.Action;
import com.loscazadores.base.BaseClass;

public class LoginPage extends BaseClass{
	@FindBy(id ="username")
	WebElement userName;
	
	@FindBy(id ="password")
	WebElement password;
	
	@FindBy(name ="login")
	WebElement loginButton;
	
	@FindBy(id ="reg_username")
	WebElement regUserName;
	
	@FindBy(id ="reg_email")
	WebElement regEmail;
	
	@FindBy(id ="reg_password")
	WebElement regPassword;
	
	@FindBy(name ="register")
	WebElement registerButton;
	
	public LoginPage() {
		 PageFactory.initElements(getDriver(), this);
	 }
	
	public HomePage login (String uname, String pswrd) throws Throwable  {
		Action.type(userName, uname);
		Action.type(password, pswrd);
		Action.click(getDriver(), loginButton);
		return new HomePage();
	}
	
	public HomePage registerAccount(String regUname, String newEmail,String regPswrd) throws Throwable   {
		Action.type(regUserName, regUname);
		Action.type(regEmail, newEmail);
		Action.type(regPassword, regPswrd);
		Action.click(getDriver(), registerButton);
		return new HomePage();
	}
}
