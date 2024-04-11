package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(
            features = {"src/test/resources/features"},
            tags="@All",
            glue = {"stepDefinitions","hooks"},

            plugin={"pretty","html:target/CucumberHTMLReport/cucumber.html"
                    ,"json:target/CucumberJSONReport/cucumber.json"

            })

    public final class TestRunnerDevelopment extends AbstractTestNGCucumberTests {


            @Override
            @DataProvider(parallel = true)
            public Object[][] scenarios() {
                return super.scenarios();
            }
}
