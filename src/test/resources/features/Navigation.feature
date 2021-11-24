Feature: Navigate on jetbrains website

  Scenario Outline: Navigate to all IDE's page
    Given the jetbrains website is loaded
    When the "<ide>" is selected from the "Developer Tools" menu
    Then the start page of the IDE should be loaded
    Examples:
      | ide           |
      |IntelliJ IDEA  |
      |AppCode        |
      |CLion          |
