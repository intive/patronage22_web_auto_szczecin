Feature: Home page feature

  Scenario: Open home page
    Given Open home page
    When Home page is loaded and opened
    Then Header component is visible
