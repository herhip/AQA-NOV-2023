package org.prog.web;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Rozetka {

    public static void main(String[] args) {

            WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://www.amazon.com/");

            WebElement AmazonSearch = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
            AmazonSearch.sendKeys("Iphone 15");
            AmazonSearch.sendKeys(Keys.ENTER);

            WebElement firstElement = driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal'][1]"));
            firstElement.isDisplayed();

        }
        finally {
            driver.quit();
        }
    }
}

