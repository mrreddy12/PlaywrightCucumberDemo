@All
Feature: Customeri Account Creation
  @Smoke @Account
  Scenario:Validate user is able to create account
    Given  User is on the Customer Account creation page
    When User enters Personal Information as "FName","LName" and Sign-in information as "Email","Password" and "ConfirmPassword"
    And User clicks on Create an account button
    Then User is on My Account page and verify SuccessMessage.