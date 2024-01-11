package org.prog.web.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class AmazonPage {
    private final WebDriver driver;

    public AmazonPage(WebDriver driver) {
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

    public void firstSearchElement() {
        WebElement firstElement = driver.findElement(By.xpath("(//span[contains(text(),'Apple iPhone 1')])[1]"));
        firstElement.click();
    }

    public void elementName() {
        WebElement elementName = driver.findElement(By.id("productTitle"));
        elementName.getText();
    }

    public void elementPrice() {
        WebElement elementPrice = driver.findElement(By.xpath("(//span[@class='a-price a-text-price a-size-medium apexPriceToPay'])[1]"));
        elementPrice.getText();
    }
}


