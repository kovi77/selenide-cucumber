Feature: Search on jetbrains website

  Scenario: Search for selenium text
    Given the jetbrains website is loaded
    When the "Selenium" text is searched
    Then the result should contain the searched text