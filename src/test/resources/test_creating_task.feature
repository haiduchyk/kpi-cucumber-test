Feature: Add task to Todoist
  If you want to create task in Inbox

  Scenario: Add task
    Given With name "Create words"
    When I want to create task
    Then I should get new task