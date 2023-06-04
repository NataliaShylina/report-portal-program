Feature: Report Portal Launches

  Scenario: Check Artifacts On Demo Dashboard
    Given I open Login page and fill-in credentials
    And I Open DashBoard Page
    When I Choose Demo DashBoard
    Then I Verify Launch Statistics Area Text Presence

  Scenario: Verify That Launches Contains Expected Data
    Given I open Login page and fill-in credentials
    When I Open Launches Page
    Then I Verify Launch Statistics
    |id    |total   |passed   | failed   |skipped  |
    |10    |30      |30       | null     |null     |
    |9     |25      |20       | 5        |null     |
    |8     |20      |10       | 8        |2        |
    |7     |15      |5        | 9        |1        |