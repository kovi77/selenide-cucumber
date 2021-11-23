Feature: Search on jetbrains website

  Scenario: Search for selenium text
    Given the jetbrains website is loaded
    When the "Selenium" text is searched
    Then the result should contain the searched text

  Scenario: Check first result of selenium search
    Given the jetbrains website is loaded
    When the "Selenium" text is searched
    And the first result is selected
    Then a navigation happens