# To open Amazon and search iphone x, click to first element and enter name and price of element to DB,
#     compare price on page with price n DB.
# Tags: Amazon, DB, Cucumber, iPhone, Price, Page Object

Feature: Enter name and price of requirement element from Amazon to DB and compare page price with DB price

    Background:
        Given I load Amazon website

    Scenario Outline: Enter name and price to DB and compare page price with DB price
        When I set search value to "<searchValue>" and do search
        And I click to first element of search results
        When I get name of element
        When I get price of element
        Then I store name and price to DB
        Then I get price of element from DB and compare with price from Amazon page

        Examples:
            | searchValue  |
            | iPhone 11    |
            | iPhone 12    |
            | iPhone 13    |

