Feature: Modal component feature

  @P2022-1207
  Scenario: Modal component has Cancel and Continue button
    Given Open home page
    When User click on 'Click to Open Modal' button
    Then Cancel and Continue buttons are visible

  @P2022-1207
  Scenario: Click on modal Cancel button
    Given Open home page
    When User click on 'Click to Open Modal' button
    Then Click on Cancel button

  @P2022-1207
  Scenario: Click on modal Cancel button
    Given Open home page
    When User click on 'Click to Open Modal' button
    Then Click on Continue button

  @P2022-1207
  Scenario: Close modal component
    Given Open home page
    When User click on 'Click to Open Modal' button
    Then Click outside modal component to close it