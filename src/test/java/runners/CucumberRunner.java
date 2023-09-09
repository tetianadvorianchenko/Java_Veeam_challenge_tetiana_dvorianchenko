package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(tags = "",
        features = {"src/test/resources/features/Vacancies.feature"},
        glue = {"steps_definitions"},
        plugin = {"pretty",
                "html:target/cucumber",
                "json:target/cucumber-report/cucumber.json",
                "json:target/cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter: target/report.html"}
)

public class CucumberRunner {

}
