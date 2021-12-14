package Runner;

import org.junit.runner.RunWith;

//import cucumber.api.CucumberOptions;
//import cucumber.api.junit.Cucumber;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(

		features = "src/test/resources/Features/Check24AutomationTask.feature", 
		glue = {"Stepdefs"}, dryRun =false, monochrome =true,

				plugin = { "pretty", "html:test-output", "json:target/cucumber.json",
						"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
						})
 

public class RunnerTest {
	
	
	/*
	 * @Afterclass()
	 * 
	 * public void closebrowser() { BaseClass.closeDriver(); }
	 * 
	 */
	
	

	// it should combine the feature file and step definition //Runner define

}
