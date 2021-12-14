package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import Stepdefs.BaseClass;

public class Emailaddresspage {
	

	WebDriver driver = BaseClass.driver;

	private static  Emailaddresspage  emailadresspageinstance;


	public static Emailaddresspage getInstance() {
		if (emailadresspageinstance == null) {
			emailadresspageinstance = new Emailaddresspage();
		}
		return emailadresspageinstance;

	}

	@FindBy(xpath ="//input[@id='cl_login']")
	@CacheLookup
	private WebElement emailaddressfield;

	@FindBy(xpath ="//button[@type='submit'and @value='weiter']")
	@CacheLookup
	private WebElement emailaddresssendbutton ;
	
	// Action Methods

	public void setemailaddress() throws Exception {

		
		String email = BaseClass.randomestring() + "@gmail.com";
		BaseClass.elementTobeClickable(emailaddressfield, 30);
		emailaddressfield.sendKeys(email);
	}

	public void Submitemailfield() throws Exception {
		BaseClass.clickElement(emailaddresssendbutton);
	}

	

}



