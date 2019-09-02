Feature: Market data

  Background:
    Given The user have a access token

  Scenario: Get quotes
    And I have a quote of AAPL,DIS
    When  I request for AAPL,DIS symbols
    Then  the page show the symbols that I ask

  Scenario: Get an option chain
    And   I have a option chain of DIS with expiration date: 2019-09-20
    When  I request for DIS and the 2019-09-20 expiration chain
    Then  the page show the different options chain for the






