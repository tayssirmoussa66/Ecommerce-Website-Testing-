@regression
Feature: SC9- Logged user could add any product to Shopping cart

  Scenario: User try to add product to shopping cart

    Given User logged in successfully

    And User go to any product page

    When User add product to cart

    Then User should to find the product in shopping cart