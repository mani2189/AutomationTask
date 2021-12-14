package Stepdefs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;

import PageObjects.Emailaddresspage;
import PageObjects.ErrorMessageValidationPage;
import PageObjects.HomePage;
import PageObjects.ResistrationFlowPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Check24AutomationStepdefinition {
	
	
	@When("User opens the URL {string}")
	public void user_opens_the_url(String url) throws Exception 
	{
		
		BaseClass.Initializebrowser();
		BaseClass.navigateToDriver(url);
		BaseClass.maximizeBrowser();
		HomePage.getInstance().closemodalwindow();
		HomePage.getInstance().gridSelectionClick();
	   
	}

	@When("User performs the cookie validation")
	public void user_performs_the_cookie_validation() 
	{
		Cookie cookie = BaseClass.driver.manage().getCookieNamed("ppset");
		System.out.println(cookie.getValue());
		String ExpectedValue = "kreditkarte";
		if (ExpectedValue.contentEquals(cookie.getValue())) {
		System.out.println("Test case1 The Cookie has been Set");//TC-1
		}
	   
	}

	@When("User Enters the emailaddress")
	public void user_enters_the_emailaddress() throws Exception
	{
	    
		Emailaddresspage.getInstance().setemailaddress();
		Emailaddresspage.getInstance().Submitemailfield();
		
	}

	@Then("User get navigated to next Registerationpage successfully")
	public void user_get_navigated_to_next_registerationpage_successfully() throws InterruptedException
	{
		String ExpectedPagetitle = "Willkommen";
		WebElement postemailActualField =BaseClass.driver.findElement(By.xpath("//div[text() ='Willkommen']"));
		BaseClass.waitforElement(postemailActualField);
		String ActualPagetitle = postemailActualField.getText();
				

		if (ExpectedPagetitle.contentEquals(ActualPagetitle)) {
			System.out.println("The Testcase2 Form Page appeared Successfully");//TC-2
		}
	   
	}

	@When("User click on the Registration radio button")
	public void user_click_on_the_registration_radio_button() throws Exception
	{
		ResistrationFlowPage.getInstance().ClickonRadiobutton();
		ResistrationFlowPage.getInstance().SubmitRadioselection();//TC-3
	   
	}

	@Then("User get navigated to next personalinfopage successfully")
	public void user_get_navigated_to_next_personalinfopage_successfully() throws Exception
	{
		
		String ExpectedPagetitle = "Persönliche Angaben";
		Thread.sleep(3000);
		String ActualPagetitle = BaseClass.driver.findElement(By.xpath("//h2[@class='styles__SectionTitle-oz8j69-1 fkZzqI']"))
				.getText();

		if (ExpectedPagetitle.contentEquals(ActualPagetitle)) {
			System.out.println("The Testcase3 Form Page appeared Successfully");//TC-3
		}
		
		
	   
	}

	@When("User click on submit button without form data")
	public void user_click_on_submit_button_without_form_data() throws Exception {
		ErrorMessageValidationPage.getInstance().submitbuttonErrorvalidation();
	   
	}

	@Then("Validate the empty fields are shown with error message")
	public void validate_the_empty_fields_are_shown_with_error_message() 
	{
		ErrorMessageValidationPage.getInstance().errormessagevalidation(); //TC-4
	   
	}

	@When("User click on submit button with valid formdata")
	public void user_click_on_submit_button_with_valid_formdata() throws Exception 
	{
		ErrorMessageValidationPage.getInstance().Submitformwithvaliddata();
	   
	}

	@Then("User navigated to the next form page")
	public void user_navigated_to_the_next_form_page()
	{
	    
		BaseClass.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	      String nextformpage =BaseClass.driver.findElement(By.xpath("//h2[text()='Weitere persönliche Angaben']")).getText();
			
			if(nextformpage.contentEquals("Weitere persönliche Angaben"))
			{
				System.out.println("The next form page appeared-TC 5 passed");
			}
			
			else
			{
				System.out.println("TC-5 Failed");
			}
	   
	}


}
