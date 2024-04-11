Feature: Wishlist Validation
  Background:
    Given  User is on the login page
    When User enters user id as "mrreddy.testing@gmail.com" and passowrd as "Automation@123"
    And User clicks on sign-in button
    Then User is on home page.
  @Smoke1 @Wishlist
  Scenario: Validate User is able to add products to the Watchlist
    Given  User is on the Products page
    When User Selects the required product
    And User Selects the Size as medium
    And User Selects the Color as black
    And User Selects the quantity
    And User Selects Add to Wishlist
    Then Products should be added to My WishList
    Then User is on My Account page and verify SuccessMessage.