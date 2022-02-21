Feature: Board header component feature

  Scenario: Board header component exists
    Given Open home page
    Then Board header component contains Return to main board text, title and new column button

  Scenario: Return to main board
    Given Open home page
    When Click on Return to main board text
    Then Home page is loaded and opened
