package Runners;

import factory.driverFactory;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.io.File;


@RunWith(Cucumber.class)
@CucumberOptions(
        tags="@ViewProductPage",features = {"src/test/resources/features"},
        glue = {"stepDefs","AppHooks"}, monochrome = true,
        plugin = {"pretty","html:target/cucumber-html-report.html", "json:target/cucumber-report.json", "junit:target/cucumber-reports/cucumber.xml",
                }
)
public class MyTestRunner {


}
