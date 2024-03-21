package com.loscazadores.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.loscazadores.base.BaseClass;
import com.loscazadores.pageobjects.HomePage;
import com.loscazadores.pageobjects.IndexPage;
import com.loscazadores.pageobjects.LoginPage;

public class LoginPageTest extends BaseClass{
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	
	@BeforeMethod
	public void setup() {
		launchApp();
	}
	
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test
	public void loginTest() throws Throwable {
		indexPage= new IndexPage();
		loginPage=indexPage.clickOnAccount();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		boolean isHome=homePage.validatedashboard();
	    Assert.assertTrue(isHome);
	}
}
