package org.prog.cucumber.steps_polina;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.prog.web.amazon.AmazonPage;

import java.sql.*;

public class AmazonPhonePriceSteps {

    public static WebDriver driver;
    public static AmazonPage amazonPage = new AmazonPage(driver);
    private Connection connection;
    private Statement statement;

    public void setupDbConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver"); //WARN: SQL connections wont work without this!
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/db", "user", "password");
        statement = connection.createStatement();
    }

    public void tearDown() throws SQLException {
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }

    @Given("I load google page")
    public void loadGooglePage() {
        amazonPage.loadPage();
    }

    //    When I set search value to "<searchValue>" and do search
    @When("I set search value to {string} and do search")
    public void searchValue(String searchValue) {
        amazonPage.setSearchValue(searchValue);
    }

    //    And I click to first element of search results
    @And("I click to first element of search results")
    public void firstSearchElement() {
        amazonPage.firstSearchElement();
    }

    //    When I get name of element
    @When("I get name of element")
    public void elementName() {
        amazonPage.elementName();
    }

    //    When I get price of element
    @When("I get price of element")
    public void elementPrice() {
        amazonPage.elementPrice();
    }

    //   Then I store name and price to DB
    @Then("I store name and price to DB")
    public void storeInDB() throws SQLException, ClassNotFoundException {
        try {
            setupDbConnection();
            WebElement elementName = driver.findElement(By.id("productTitle"));
            WebElement elementPrice = driver.findElement(By.xpath("(//span[@class='a-price a-text-price a-size-medium apexPriceToPay'])[1]"));

            String sqlInsertPattern = "INSERT INTO Mobile_Phone_Price (Name, Price) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInsertPattern);

            preparedStatement.setString(1, elementName.getText());
            preparedStatement.setString(2, elementPrice.getText());
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Data has been successfully inserted into the table.");
            } else {
                System.out.println("Failed to insert data into table.");
            }
        } finally {
            tearDown();

        }
    }

    // Then I get price of element from DB
    @Then("I get price of element from DB and compare with price from Amazon page")
    public void getPriceFromDB() throws SQLException, ClassNotFoundException {
        try {
            setupDbConnection();
            String sqlSelectPattern = "SELECT Price FROM Mobile_Phone_Price WHERE Name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlSelectPattern);

            WebElement elementName = driver.findElement(By.id("productTitle"));
            preparedStatement.setString(1, elementName.getText());

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String dbPrice = resultSet.getString("Price");
                WebElement elementPrice = driver.findElement(By.xpath("(//span[@class='a-price a-text-price a-size-medium apexPriceToPay'])[1]"));
                String webPagePrice = elementPrice.getText();

                if (webPagePrice.equals(dbPrice)) {
                    System.out.println("Prices match: Web Page Price = DB Price");
                } else {
                    System.out.println("Prices do not match: Web Page Price = " + webPagePrice + ", DB Price = " + dbPrice);
                }
            } else {
                System.out.println("No price found in the database for the given element name.");
            }
        } finally {
            tearDown();
        }
    }
}



