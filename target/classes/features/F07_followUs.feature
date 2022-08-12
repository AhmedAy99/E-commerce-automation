@smoke
  Feature: P03_homePage | user can use all followUs links

    Background:
      Given user navigated to homePage

    Scenario: user click on facebook icon
      When user choose "facebook" icon
      Then user is navigated to "https://www.facebook.com/nopCommerce" new tab

    Scenario: user click on twitter icon
      When user choose "twitter" icon
      Then user is navigated to "https://twitter.com/nopCommerce" new tab

    Scenario: user click on rss icon
      When user choose "rss" icon
      Then user is navigated to "https://demo.nopcommerce.com/new-online-store-is-open" new tab

    Scenario: user click on youtube icon
      When user choose "youtube" icon
      Then user is navigated to "https://www.youtube.com/user/nopCommerce" new tab