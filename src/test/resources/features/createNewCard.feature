Feature: Create new card feature

  Scenario: Create New Card
    Given Open home page
    When Click "Add card" button
    And Type "Some random string" in the textarea
    And Click "Save" button
    Then New card with "Some random string" text, author and favorite icon is displayed
