package com.framework.base;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.framework.utilities.ReadProp;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class BasePage {

	// this class will have all the common methods related to browser and browser configurations

	private static WebDriver driver = null;
	public Properties prop = ReadProp.readData("Config.properties");

	// method to launch browser
	@Before
	public void setupBrowser() {
		String browser = prop.getProperty("browser");
		if (browser.equalsIgnoreCase("chrome"))
			driver = new ChromeDriver();
		else if (browser.equalsIgnoreCase("edge"))
			driver = new EdgeDriver();
		else if (browser.equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}
	
	//method to close browser
	@After(order=0)
	public void teardownBrowser() {
		driver.quit();
	}
	
	@After(order=1)
	public void addScreenshotIntoReportForFailutreScenario(Scenario scenario) {
		if(scenario.isFailed()) {
			File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				byte [] fileContent = FileUtils.readFileToByteArray(file);
				scenario.attach(fileContent, "image/png", "Step is failed, Refer screenshot");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	//method to share browser details with other classes
	public WebDriver getDriver() {
		return driver;
	}
	

}
