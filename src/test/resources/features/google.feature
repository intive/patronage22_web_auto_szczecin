Feature: Google search feature

  Background:
    Given Google page is opened

  Scenario Outline: Search in Google
    When I close popup message
    And I search for phrase "<searchPhrase>"
    Then I can see search result page

    Examples:
      | searchPhrase       |
      | Intive             |
      | Cucumber           |
      | Selenium Webdriver |

    @Smoke
    Examples:
      | searchPhrase       |
      | Intive             |


