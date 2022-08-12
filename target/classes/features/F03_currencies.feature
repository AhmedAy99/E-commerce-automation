@smoke
Feature: P03_homePage | user should be able to change currency

  Scenario: user change currency
  Given user navigated to homePage
  When user change currency
  Then currency is changed for all product