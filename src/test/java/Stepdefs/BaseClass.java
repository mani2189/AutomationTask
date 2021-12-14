package Stepdefs;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjects.Emailaddresspage;
import PageObjects.ErrorMessageValidationPage;
import PageObjects.HomePage;
import PageObjects.ResistrationFlowPage;
import UtilitiesPackage.DriverFactory;
import UtilitiesPackage.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class BaseClass {

	public static WebDriver driver;
	public static JavascriptExecutor js;

	public static void Launchbrowser() throws Exception {

		DriverManager driverManager = DriverFactory.getDriverManager("chrome");// Factory design to get driver
		driver = driverManager.getDriver();
		js= (JavascriptExecutor) driver;
	}

	
	public static void Initializebrowser() throws Exception {
		
			Launchbrowser();
			initeWebElements();
			
			
		}
	
	@After(order =1)
	public void afterScenario(Scenario scenario){
	        if(scenario.isFailed()){
	            byte[] screenshot = ((TakesScreenshot)BaseClass.driver).getScreenshotAs(OutputType.BYTES);
	            scenario.attach(screenshot, "image/png", "ScreenShot");
	        }
	      }
	
	

	public static void initeWebElements() {
		PageFactory.initElements(driver, HomePage.getInstance());
		PageFactory.initElements(driver, Emailaddresspage.getInstance());
		PageFactory.initElements(driver, ErrorMessageValidationPage.getInstance());
		PageFactory.initElements(driver, ResistrationFlowPage.getInstance());
		
	}

	public static String randomestring() {
		String generatedString1 = RandomStringUtils.randomAlphabetic(5);
		return generatedString1;

	}

	public static void quitDriver() {
		driver.quit();
	}

	public static void closeDriver() {
		driver.close();
	}

	public static  void navigateToDriver(String url) {
		driver.get(url);
	}

	public static  void maximizeBrowser() {
		driver.manage().window().maximize();
	}

	public static void setImplicitWaitTimeOut(int timeInMiliSeconds) {
		driver.manage().timeouts().implicitlyWait(timeInMiliSeconds, TimeUnit.MILLISECONDS);
	}
	
	public static void waitforElement(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
	    wait.until(ExpectedConditions.visibilityOf(element));
	    
	    
	}
	
	
	
	public static void elementTobeClickable(WebElement element, int WaitSeconds) throws Exception {
		try {
			WebDriverWait waits = new WebDriverWait(driver, WaitSeconds);
			waits.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {

		}
	}

	
	public static void clickElement(WebElement element) throws Exception {

		elementTobeClickable(element, 30);
		try {
			js.executeScript("arguments[0].scrollIntoView(true);", element);
			js.executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			element.click();
		}
	}
	

}
