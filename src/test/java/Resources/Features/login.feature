
Feature: User should be able to login successfully

  Background:
    Given is on homepage
  @login
  Scenario:User should be able to login successfully with valid credentials
    When User enters valid username and  valid password
    And Clicks on login button
    Then User is navigated to dashboard page

  Scenario Outline: User should not be able to login successfully with invalid credentials
    When User enters inavlid "<username>" and invalid "<password>"
    And Clicks on login button
    Then Sees and "<error_message>" display
    Examples:
      | username | password | error_message            |
      | John     | john123  | Invalid credentials      |
      |          | john123  | Username cannot be empty |
      | John     |          | Password cannot be empty |
      |          |          | Username cannot be empty |
      | Admin    | john123  | Invalid credentials      |
      | John     | admin123 | Invalid credentials      |



