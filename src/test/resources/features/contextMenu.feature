Feature: Context menu feature

  @P2022-427
  Scenario: closing context menu by double clicking a trigger button
    Given Open home page
    When Click on trigger button
    And Context menu is open
    And Click on trigger button
    Then Context menu is close

  @P2022-427
  Scenario: closing context menu by clicking an item
    Given Open home page
    When Click on trigger button
    And Context menu is open
    And The list of items contains two items
    And Click on item
    Then Context menu is close

  @P2022-427
  Scenario: closing context menu by clicking outside the context menu
    Given Open home page
    When Click on trigger button
    And Context menu is open
    And Click outside the context menu
    Then Context menu is close
