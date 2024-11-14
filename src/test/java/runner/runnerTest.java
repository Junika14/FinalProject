package runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "json:build/reports/cucumber/cucumber-report.json",
                "html:build/reports/cucumber/cucumber-report.html"
        },
        glue = {"stepDef"},
        features = {"src/test/java/features"},
        tags = "@api or @web",
        monochrome = true

)

public class runnerTest {
}
