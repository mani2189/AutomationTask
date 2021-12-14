package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import Stepdefs.BaseClass;

public class ResistrationFlowPage 
{
	
	WebDriver driver = BaseClass.driver;

	private static  ResistrationFlowPage  registerradiobuttoninstance;

	
	public static ResistrationFlowPage getInstance() {
		if (registerradiobuttoninstance == null) {
			registerradiobuttoninstance = new ResistrationFlowPage();
		}
		return registerradiobuttoninstance;

	}

	@FindBy(xpath ="//div[contains(text(),'Ich möchte als Gast fortfahren')]")
	@CacheLookup
	private WebElement registerradiobutton;

	@FindBy(xpath ="//button[@id='c24-uli-register-btn']")
	@CacheLookup
	private WebElement registerradiobuttonsubmit ;
	
	// Action Methods

	public void ClickonRadiobutton() throws Exception {

		//registerradiobutton.click();
		BaseClass.clickElement(registerradiobutton);
	}

	public void SubmitRadioselection() throws Exception {
		//registerradiobuttonsubmit.click(); 
		BaseClass.clickElement(registerradiobuttonsubmit);
	}

	

}
