package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/feature/Test.feature"},
        glue = {"Defination"}
)

public class CucumberRunner extends AbstractTestNGCucumberTests
{

}
