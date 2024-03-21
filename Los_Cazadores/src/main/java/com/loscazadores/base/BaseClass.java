package com.loscazadores.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.loscazadores.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static Properties prop;
//	public static WebDriver driver;
	
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
	
	@BeforeSuite
	public void beforeSuite() {
		ExtentManager.setExtent();
		DOMConfigurator.configure("log4j.xml");
	}
	
	public static WebDriver getDriver() {
		// Get Driver from threadLocalmap
		return driver.get();
	}
	
	@BeforeTest
	public void loadConfig() {
		System.out.println("loadConfig");
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\Configuration\\config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void launchApp() {
		String browserName = prop.getProperty("browser");
		System.out.println("browserName > "+ browserName);
		if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
		} else if (browserName.equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
		} else if (browserName.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver.set(new EdgeDriver());
		}
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().get(prop.getProperty("url"));
	}
	
	@AfterSuite
	public void afterSuite() {
		ExtentManager.endReport();
	}
	
	
}
