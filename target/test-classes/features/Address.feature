Feature: Add new address Validation
  Background:
    Given  User is on the login page
    When User enters user id as "mrreddy.testing@gmail.com" and passowrd as "Automation@123"
    And User clicks on sign-in button
    Then User is on home page.
  @Smoke1 @Address
  Scenario: Validate User is able to add new adress to address book
   Given  User is on the Address page
    When User provides the address details
    And User clicks on Save Adress button
    Then Address should be added to the adress book