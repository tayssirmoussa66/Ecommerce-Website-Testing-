package Runners;
//import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;



@CucumberOptions(
        features = {"src/test/java/Features/SC12_FollowUs.feature"},
       plugin = {"json:target/cucumber.json",
               "html:target/cucumber.html"},
        glue = {"Steps"}
        )
public class TestRunner extends AbstractTestNGCucumberTests {
}
