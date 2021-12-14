package UtilitiesPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class DriverManager {
	protected WebDriver driver;

	protected abstract void initDriver();

	public WebDriver getDriver() {
		if (driver == null) {
			initDriver();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
		return driver;
	}
		
	



}
