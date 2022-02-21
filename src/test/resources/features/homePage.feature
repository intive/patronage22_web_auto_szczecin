Feature: Home page feature

  Scenario: Open home page
    Given Open home page
    Then Home page is loaded and opened

  Scenario: Set link to home on logo
    Given Open home page
    Then Click on logo
    Then Home page is loaded and opened
