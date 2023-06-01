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