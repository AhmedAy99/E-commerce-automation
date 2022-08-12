@smoke
  Feature: P03_homePage | user is able to add items to wishlist

    Background:
      Given user navigated to homePage

    Scenario: user add item to wishlist
      When user add item to wishlist
      Then wishlist success message is displayed

    Scenario: item is added to wishlist page
      When user add item to wishlist
      Then wishlist success message is displayed
      And user click on wishlist page
      Then item is found on wishlist page