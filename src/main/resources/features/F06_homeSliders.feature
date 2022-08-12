@smoke
Feature: P03_homePage | user can click any slider and navigate to product page

  Background:
    Given user navigated to homePage

  Scenario: user click on first slider
      When user choose slider "1"
      Then user is navigated to "https://demo.nopcommerce.com/nokia-lumia-1020"

  Scenario: user click on second slider
    When user choose slider "2"
    Then user is navigated to "https://demo.nopcommerce.com/iphone-6"
