package org.prog.web.amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonActions {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        try {
            AmazonMain amazonPage = new AmazonMain(driver);

            amazonPage.loadPage();
            amazonPage.setSearchValue("Iphone 15");
            amazonPage.performSearch();
            amazonPage.firstElementText();
        }
        finally {
            driver.quit();
        }


    }

}
