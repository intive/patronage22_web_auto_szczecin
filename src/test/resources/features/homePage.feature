Feature: Home page feature

  Scenario: Open home page
    Given Open home page
    Then Home page is loaded and opened

  @P2022-569
  Scenario: Set link to home on logo
    Given Open home page
    When Click on logo
    Then Home page is loaded and opened

  @P2022-1203
  Scenario: Check cards counter
    Given Open home page
    Then Check if 'card' in cards count renders properly
