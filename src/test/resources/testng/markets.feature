Feature: Market data

  Background:
    Given The user have a access token

  Scenario Outline: Get quotes
    And I have a quote of <symbols>
    When  I request for <symbols> symbols
    Then  the page show the symbols that I ask
    Examples:
      | symbols|
      |AAPL,DIS|

  Scenario: Get an option chain
    And   I have a option chain of DIS with expiration date: 2019-09-20
    When  I request for DIS and the 2019-09-20 expiration chain
    Then  the page show the different options chain for the







