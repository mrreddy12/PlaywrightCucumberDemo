@All
Feature: Login Validation
  @Smoke @Login
  Scenario: Validate Login with valid credential
    Given  User is on the login page
    When User enters user id as "mrreddy.testing@gmail.com" and passowrd as "Automation@123"
    And User clicks on sign-in button
#    Then User is on home page.
   @Login1
  Scenario: Validate Login with valid credential
    Given  User is on the login page
    When User enters user id as "mrreddy.testing@gmail.com" and passowrd as "Automation@123"
    And User clicks on sign-in button
#    Then User is on home page.