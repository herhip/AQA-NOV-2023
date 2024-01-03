Feature: Amazon test: 'Ships to [your city]' text for the object on page

  Background:
  Given I load Amazon website

  Scenario: Find 'Ships to [your city]' text on page
  When I set search value to "Iphone 12 pro max, 256 GB"
  Then I see AMAZON_SHIPS_TO_TEXT for first object

