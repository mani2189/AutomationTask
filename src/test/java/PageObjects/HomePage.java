package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import Stepdefs.BaseClass;

public class HomePage {
	
	WebDriver driver = BaseClass.driver;

	private static  HomePage  homepageinstance;

	private HomePage() {

	}

	public static HomePage getInstance() {
		if (homepageinstance == null) {
			homepageinstance = new HomePage();
		}
		return homepageinstance;

	}

	@FindBy(xpath ="//a[@class='c24-cookie-consent-button']")
	@CacheLookup
	private WebElement modalwindowclose;

	@FindBy(xpath ="//div[@id='500940']//a[@class='button'][normalize-space()='weiter']")
	@CacheLookup
	private WebElement gridselection ;
	
	// Action Methods

	public void closemodalwindow() throws Exception {

	 //modalwindowclose.click();
		BaseClass.clickElement(modalwindowclose);
	}

	public void gridSelectionClick() throws Exception {
		//gridselection.click();
		BaseClass.clickElement(gridselection);
	}

	

}
