Feature: User Registration and Login

  @smoke @registerAndLogin
  Scenario: Register a new user and login to get token
    Given I register a user with name "John Doe", email "john1@example.com", password "pass123", phone "5551234567", and role "traveler"
    Given I login with email "john1@example.com" and password "pass123"
    Then the response status code should be 200
    And the response should contain a valid JWT token
