package org.prog.elements;

import org.openqa.selenium.By;

public enum AmazonElements {

    AMAZON_SEARCH_INPUT(By.name("field-keywords")),
    AMAZON_SHIPS_TO_TEXT(By.xpath("(//span[contains(text(), 'Ships to')])[1]"));

    private By locator;

    AmazonElements(By locator) {
        this.locator = locator;
    }

    public By getLocator(){
        return this.locator;
    }

    public void printStuff() {
        System.out.println("This is enum method!");
    }
}
