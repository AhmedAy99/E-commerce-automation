@smoke
Feature: P03_homePage | user can hover and select subcategory easily successfully

  Background:
    Given user navigated to homePage

    Scenario:
      When user hover on main category and select sub category
      Then user is navigated to subcategory page