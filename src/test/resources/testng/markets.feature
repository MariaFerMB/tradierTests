Feature: Market data

  Background:
    Given I have a developer access token

  Scenario: Get quotes with symbols parameter
    And I have a quote of AAPL,DIS securities
    When  I request for the quotes that have AAPL,DIS symbols
    Then  the page show the quotes for the securities that I asked

  Scenario: Try get quotes without symbols parameter
    When  I request for quotes without symbols parameter
    Then  the page show the message: Invalid Parameter: symbols

  Scenario: Get an option chain
    And   I have a option chain of DIS symbol security with expiration date: 2019-09-20
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
    Then the page show prices from past days

  Scenario:  Get historical price between two dates
    When I request for the historical pricing with 2019-08-28 as start date and 2019-09-03 as end date of DIS security
    Then the page show prices between 2019-08-28 and 2019-09-03 dates

  Scenario:  Get time and sales for a security
    When I request for the time and sales of DIS security
    Then the page show time and sales from current day

  Scenario:  Get the intraday status
    When I request for the clock
    Then the page show information about current date market status

  Scenario:  Get the market calendar
    When I request for the market calendar
    Then the page show market calendar about current month and year

  Scenario:  Get the market calendar using a specific date and year
    When I request for the market calendar with 3 as month and 2019 as year
    Then the page show market calendar about month 3 and year 2019

  Scenario:  Search securities using the description
    When I request for the securities using the key word: alphabet for the description
    Then the page show securities that have the key word: alphabet in the description

  Scenario:  Search securities using the symbol
    When I request for the securities using the key word: goog for the symbol
    Then the page show securities that have the key word: goog in the symbol






