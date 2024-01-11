package org.prog.cucumber.steps_polina;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.prog.web.amazon.AmazonPage;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static org.prog.cucumber.steps_polina.AmazonPhonePriceSteps.driver;

@CucumberOptions(
        features = "src/test/resources/features_polina/PhonePriceDB",
        glue = "org.prog.cucumber.steps_polina",
        plugin = {
                "pretty",
                "json:target/cucumber-reports/Cucumber.json",
                "html:target/cucumber-report.html"
}
)
public class AmazonCucumberRunner extends AbstractTestNGCucumberTests {

    @BeforeSuite
    public void setUp() {
        driver = new EdgeDriver();
        AmazonSearchParametrizedSteps.amazonPage = new AmazonPage(driver);
        AmazonPhonePriceSteps.amazonPage = new AmazonPage(driver);
    }

    @AfterSuite
    public void tearDown() {
            if (driver != null) {
                driver.quit();
            }
        }
    }



