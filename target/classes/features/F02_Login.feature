@smoke
Feature: F02_Login | users could use login functionality to use their accounts

  Background:
    Given user go to login page
  @firstScenario
  Scenario: user could login with valid email and password
  When user login with "test1234@example.com" and "P@ssw0rd"
  And user press on login button
  Then user login to the system successfully

  @secondScenario
  Scenario: user could login with invalid email and password
  When user login with "wrong@example.com" and "P@ssw0rd"
  And user press on login button
  Then user could not login to the system
