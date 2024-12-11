package testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features= "src\\test\\java\\Feature\\LoginPage.feature",
                 glue= "stepdefination",
                 tags="@SmokeTest or @any-fileds",
                
                 plugin= {"pretty" ,
                		  "html:target/cucumber-reports.html",
                		  //"xml:target/cucumber-reports.xml",
                		  "json:target/cucumber-reports.json"
                		 
                          },
                 
                 dryRun = true)


public class TestRun {

}
