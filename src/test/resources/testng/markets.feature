Feature: Market data

  Background:
    Given I have a developer access token

  Scenario Outline: Get quotes
    And I have a quote of <symbols> securities
    When  I request for <symbols> symbols
    Then  the page show the quotes for the securities that I asked
    Examples:
      | symbols|
      |AAPL,DIS|

  Scenario Outline: Get an option chain
    And   I have a option chain of <symbol> with expiration date: <date>
    When  I request for the option chain of <symbol> and the <date> as expiration date
    Then  the page show the different options chain for the specific security symbol and expiration date

    Examples:
      |symbol|date|
      |DIS|2019-09-20|


  Scenario Outline: Get an options strike prices
    When  I request for the options strikes of <symbol> and the <date> as expiration chain
    Then  the page show the options strikes prices for the specific security symbol and expiration date

    Examples:
      |symbol|date|
      |DIS|2019-09-20|


  Scenario Outline: Get expiration dates for a particular security.
    When  I request for the expiration dates of <symbol>
    Then  the page show expiration dates for the specific security symbol

    Examples:
      |symbol|
      |DIS|







