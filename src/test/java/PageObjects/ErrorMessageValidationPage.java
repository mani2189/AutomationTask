package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import Stepdefs.BaseClass;

public class ErrorMessageValidationPage 
{

	WebDriver driver = BaseClass.driver;

	private static  ErrorMessageValidationPage  errorpagevalidationpageinstance;


	public static ErrorMessageValidationPage getInstance() {
		if (errorpagevalidationpageinstance == null) {
			errorpagevalidationpageinstance = new ErrorMessageValidationPage();
		}
		return errorpagevalidationpageinstance;

	}

	@FindBy(xpath ="//a[text()='weiter']")
	@CacheLookup
	private WebElement errorpagesubmitbutton;

	@FindBy(xpath = "//label[text()='Bitte wählen Sie Ihre Anrede aus.']")
	@CacheLookup
	private WebElement errorfield1;

	@FindBy(xpath = "//label[text()='Bitte wählen Sie Ihre Anrede aus.']")
	@CacheLookup
	private WebElement errorfield2;
    @FindBy(xpath ="//label[text()='Bitte geben Sie Ihren Nachnamen an.']")
	@CacheLookup
	private WebElement errorfield3;

	 @FindBy(xpath ="//label[text()='Bitte geben Sie Ihr Geburtsdatum an.']")
	@CacheLookup
	private WebElement errorfield4;

	@FindBy(xpath ="//label[text()='Für eventuelle Rückfragen benötigen wir Ihre deutsche Mobilnummer.']")
	@CacheLookup
	private WebElement errorfield5;

	@FindBy(xpath ="//label[@for='GENDER_FEMALE']")
	@CacheLookup
	private WebElement frauxpath;
	@FindBy(xpath ="//input[@id='GIVEN_NAME']")
	@CacheLookup
	private WebElement vornnamexpath;
	@FindBy(xpath ="//input[@id='LAST_NAME']")
	@CacheLookup
	private WebElement Nachnamexpath;
	@FindBy(xpath ="//input[@id='DATE_OF_BIRTH']")
	@CacheLookup
	private WebElement geburxpath;
	@FindBy(xpath ="//input[@id='PHONENUMBER_MOBILE']")
	@CacheLookup
	private WebElement nummberxpath;
	@FindBy(xpath ="//input[@id='CONTACT_EMAIL']")
	@CacheLookup
	private WebElement emaillxpath;
	
	// Action Methods

	public void submitbuttonErrorvalidation() throws Exception {

		BaseClass.clickElement(errorpagesubmitbutton);
		//errorpagesubmitbutton.click();
	}

	public void Submitformwithvaliddata() throws Exception
	{
		frauxpath.click();
		vornnamexpath.sendKeys("Mani");
		Nachnamexpath.sendKeys("kandan");
		geburxpath.sendKeys("21.11.1989");
		nummberxpath.sendKeys("15145115747");
		submitbuttonErrorvalidation();
	}
	
	public void errormessagevalidation()
	{
		WebElement[] errorFields = { errorfield1, errorfield2, errorfield3, errorfield4, errorfield5};

		int failedcount = 0;
		for (WebElement field : errorFields) {
			if (field.isDisplayed() == false) {
				failedcount++;

			}

		}

		if (failedcount == 0) {
			System.out.println("TestCase4- Error messages are displayed");
		}

		else {
			System.out.println("Testcase4 -failed");
		}
		
	}
	
	
	
	
}
