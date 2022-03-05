package runner;

import io.cucumber.testng.CucumberOptions;
import testdoc.TestBase;


@CucumberOptions(features="src\\test\\java\\Features",
glue={"steps"})

public class TestRunner extends TestBase {

}
