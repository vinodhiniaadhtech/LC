package com.loscazadores.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.loscazadores.base.BaseClass;
import com.loscazadores.pageobjects.IndexPage;

public class IndexPageTest extends BaseClass {
	
	IndexPage indexPage;
	
	@BeforeMethod
	public void setup() {
		launchApp();
	}
	
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test
	public void verifyLogo() throws Throwable {
		indexPage = new IndexPage();
		boolean result = indexPage.validateLogo();
		Assert.assertTrue(result);
	}
	
	@Test
	public void verifyTitle() throws Throwable {
		String title = indexPage.getAppTitle();
		Assert.assertEquals(title,"Home - Los Cazadores");
	}

}
