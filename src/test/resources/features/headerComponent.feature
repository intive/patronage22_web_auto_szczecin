Feature: Header component feature

  Scenario: Header exist
    Given Open home page
    Then Header component is visible

  @P2022-355
  Scenario: App logo and title are displayed on header
    Given Open home page
    Then Header component is visible
    And Logo is visible
    And "My Retro Board" title of header is visible and readable

  @P2022-355
  Scenario: Header sticky
    Given Open home page
    Then Header is "sticky"

  @P2022-355
  Scenario: Header background
    Given Open home page
    Then "#ffffff" color of background should be visible