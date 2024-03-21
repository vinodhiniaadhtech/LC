package com.loscazadores.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.loscazadores.actiondriver.Action;
import com.loscazadores.base.BaseClass;

public class HomePage extends BaseClass{
	Action action= new Action();
	
	@FindBy(xpath="//*[@id=\"post-19\"]/div/div/nav/ul/li[1]/a")
	private WebElement dashboard;
	
	public boolean validateHomePage() throws Throwable {
		Action.scrollByVisibilityOfElement(getDriver(), dashboard);
		boolean moved = Action.moveToElement(getDriver(), dashboard);
//		 return Action.isDisplayed(getDriver(), dashboard);
		return moved;
	 }
	
	public boolean validatedashboard() throws Throwable {
		 return Action.isDisplayed(getDriver(), dashboard);
	 }

}
