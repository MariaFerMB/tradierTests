Feature: Market data

  Background:
    Given The user have a access token


  Scenario: Get quotes
    And I have a quote of AAPL,DIS symbols
    When  the user request for AAPL,DIS symbols
    Then  the page show the symbols that he ask



