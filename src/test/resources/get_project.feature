Feature: Find project by id
  If you want to find project but you have only id

  Scenario: Find user by name
    Given Project "2207198286"
    When I want to find project
    Then I should get project "Inbox"