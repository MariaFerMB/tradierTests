Feature: Market data

  Background:
    Given I have a developer access token

  Scenario: Get quotes
    And I have a quote of AAPL,DIS securities
    When  I request for AAPL,DIS symbols
    Then  the page show the quotes for the securities that I asked

  Scenario: Get an option chain
    And   I have a option chain of DIS with expiration date: 2019-09-20
    When  I request for the option chain of DIS and the 2019-09-20 as expiration date
    Then  the page show the different options chain for the specific security symbol and expiration date

  Scenario: Get an options strike prices
    When  I request for the options strikes of DIS and the 2019-09-20 as expiration chain
    Then  the page show the options strikes prices for the specific security symbol and expiration date

  Scenario: Get expiration dates for a particular security
    When  I request for the expiration dates of DIS
    Then  the page show expiration dates for the specific security symbol

  Scenario:  Get historical pricing for a security
    When I request for the historical pricing of DIS security
    Then the page show prices from pass days

  Scenario:  Get time and sales for a security
    When I request for the time and sales of DIS security
    Then the page show time and sales from current day





