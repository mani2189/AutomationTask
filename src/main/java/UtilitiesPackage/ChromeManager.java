package UtilitiesPackage;


import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;



public class ChromeManager extends DriverManager {

	@Override
	public void initDriver() {
		WebDriverManager.chromedriver().browserVersion("96").setup();
		driver = new ChromeDriver();
	}

}
