package org.prog.web.amazon;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonMain {
    private final WebDriver driver;

    public AmazonMain(WebDriver driver) {
        this.driver = driver;
    }

    public void loadPage() {
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
    }

    public void setSearchValue(String searchValue) {
        WebElement AmazonSearch = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        AmazonSearch.sendKeys(searchValue);
        AmazonSearch.sendKeys(Keys.ENTER);
    }

}


    /*
    public void firstElementText() {
        WebElement firstPrice = driver.findElement(By.xpath("(//span[@class='a-price'])[1]"));
        new WebDriverWait(driver, Duration.ofSeconds(30L))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='a-price'])[1]")));
        if (firstPrice.isDisplayed()) {
            System.out.println("Successfully!");
        }
    }

     */


