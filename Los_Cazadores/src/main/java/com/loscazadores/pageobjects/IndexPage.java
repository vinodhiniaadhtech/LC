package com.loscazadores.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.loscazadores.actiondriver.Action;
import com.loscazadores.base.BaseClass;

public class IndexPage extends BaseClass {
	
	 @FindBy(xpath ="//*[@id=\"masthead\"]/div/div/div/section[3]/div/div[2]/div/section/div/div[2]/div/div/div/div[2]/div/a")
	 WebElement accountButton;
	 
	 @FindBy(xpath ="//*[@id=\"masthead\"]/div/div/div/section[3]/div/div[1]/div/div/div/div/a/img")
	 WebElement appLogo;
	 
	 @FindBy(id="dgwt-wcas-search-input-2")
	 WebElement searchBox;
 
	 public IndexPage() {
		 PageFactory.initElements(getDriver(), this);
	 }
	 
	 public LoginPage clickOnAccount() throws Throwable{
		Action.click(getDriver(), accountButton);
		return new LoginPage();
	 }
	 
	 public boolean validateLogo() throws Throwable {
		 return Action.isDisplayed(getDriver(), appLogo);
	 }
	 
	 public String getAppTitle() {
		 String appTitle = getDriver().getTitle();
		 return appTitle;
	 }
	 
	 public void searchBOx(String productName)throws Throwable {
		 Action.type(searchBox, productName);
		 Action.selectBySendkeys(productName, searchBox);
	 }	
 
 
}
