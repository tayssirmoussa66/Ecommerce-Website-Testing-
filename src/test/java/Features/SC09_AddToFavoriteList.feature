Feature: SC09- Logged user could add different products to Favorite list

  Scenario: User could be able to add products to Favorite list

    Given User logged in successfully

    When User select different products to Favorite list

    Then User show green message for successful add products to Favorite list
    And User open Favorite list page and find the items has been selected