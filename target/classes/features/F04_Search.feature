@smoke
Feature: P03_homePage | user can use search successfully

  Background:
    Given user navigated to homePage

  Scenario Outline: user could search using product name
    When user search for "<item>"
    Then user is navigated to search page
    And search show relevant "<item>"
    Examples:
    |item|
    |book|
    |laptop|
    |nike|


  Scenario Outline: user could search for product using sku
    When user search for "<item>"
    And user clicked on the product
    Then user find product with exact "<item>"
    Examples:
      |item|
      |SCI_FAITH|
      |APPLE_CAM|
      |SF_PRO_11|


