@regression
Feature: SC7- Logged user could filter with constructor

  Scenario: User filter selected item with constructor

    Given User should to be logged in successfully
    And User should to select an item to filter

    When User filter items by constructor option

    Then User appear for him the filter items of constructor that he chose