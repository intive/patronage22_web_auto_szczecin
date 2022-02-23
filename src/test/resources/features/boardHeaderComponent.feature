Feature: Board header component feature

  @P2022-439
  Scenario: Board header component exists
    Given Open home page
    Then Board header component contains Return to main board text, title and new column button

  @P2022-439
  Scenario: Return to main board
    Given Open home page
    When Click on Return to main board text
    Then Home page is loaded and opened
