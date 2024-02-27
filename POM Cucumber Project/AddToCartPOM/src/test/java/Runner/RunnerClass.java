package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/Feature/Test.feature"},
        glue = {"Definition"}
)
public class RunnerClass extends AbstractTestNGCucumberTests

{
}
