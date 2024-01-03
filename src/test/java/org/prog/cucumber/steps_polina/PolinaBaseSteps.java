package org.prog.cucumber.steps_polina;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.prog.elements.AmazonElements;
import org.prog.web.amazon.AmazonMain;

public class PolinaBaseSteps {
    public static WebDriver driver;
    public static AmazonMain amazonPage = new AmazonMain(driver);

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



//          Code without page object      //

//
//    @Given("I load Amazon website")
//    public void loadGAmazonPage() {
//        webDriver.get("https://www.amazon.com/");
//    }
//
//    @When("I set search value to {string}")
//    public void setSearchValue(String searchValue) {
//        WebElement AmazonSearch = webDriver.findElement(By.name("field-keywords"));
//        AmazonSearch.sendKeys(searchValue);
//        AmazonSearch.sendKeys(Keys.ENTER);
//
//    }
//
//    @Then("I see {} for first object")
//    public void shipsToText(AmazonElements shipsText){
//       webDriver.findElement(shipsText.getLocator());
//
//    }


