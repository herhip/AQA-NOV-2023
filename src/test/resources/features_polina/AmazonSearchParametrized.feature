Feature: Amazon Search for iPhone of the required version with Ships to your city

  Background:
  Given I load Amazon website

  Scenario Outline: Search iPhone of the required version with Ships to your city on Amazon
    When I set search value to "<searchValue>"
    Then I see AMAZON_SHIPS_TO_TEXT for first object

    Examples:
      | searchValue  |
      | iPhone 11    |
      | iPhone 12    |
      | iPhone 13    |


