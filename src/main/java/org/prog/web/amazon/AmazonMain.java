package org.prog.web.amazon;

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
        WebElement AmazonSearch = driver.findElement(By.name("field-keywords"));
        AmazonSearch.sendKeys(searchValue);
        AmazonSearch.sendKeys(Keys.ENTER);
    }
}


