package org.prog.cucumber.steps_polina;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.prog.elements.AmazonElements;
import org.prog.web.amazon.AmazonPage;

public class AmazonSearchParametrizedSteps {
    public static WebDriver driver;
    public static AmazonPage amazonPage = new AmazonPage(driver);

    @Given("I load Amazon website")
    public void loadAmazonPage() {
        amazonPage.loadPage();
    }

    @When("I set search value to {string}")
    public void setSearchValue(String searchValue) {
        amazonPage.setSearchValue(searchValue);
    }

    @Then("I see {} for first object")
    public void shipsToText(AmazonElements shipsText) {
        driver.findElement(shipsText.getLocator());
    }
}



