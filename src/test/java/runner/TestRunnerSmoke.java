package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions
				(
					features="src/test/resources/BusinessLogic",
					glue="cucumbermap",
					tags="@SmokeTest",
					monochrome=true
							
																
				)



public class TestRunnerSmoke
{

}
