@regression
Feature: SC6- Logged user could filter with color

  Scenario: User filter selected item with color

    Given User should to be logged in successfully
    And User should to select an item to filter

    When User filter items by color option

    Then User appear for him the filter items with color he choosed