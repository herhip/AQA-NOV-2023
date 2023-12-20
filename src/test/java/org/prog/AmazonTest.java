package org.prog;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.prog.web.amazon.AmazonMain;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

public class AmazonTest {

    private WebDriver driver;
    private AmazonMain amazonPage;

    @BeforeSuite
    public void setUp() {
        driver = new ChromeDriver();
        amazonPage = new AmazonMain(driver);
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void shipsTo() {
        amazonPage.loadPage();
        amazonPage.setSearchValue("Iphone 12 pro max, 256 GB");

        WebElement shipsToCanada = new WebDriverWait(driver, Duration.ofSeconds(10L))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[contains(text(), 'Ships to')])[1]")));
        Assert.assertTrue(shipsToCanada.isDisplayed(), "'Ships to Canada' text is absent :(");

    }
}