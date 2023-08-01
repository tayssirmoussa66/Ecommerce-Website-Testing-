Feature: SC10- Logged user could add different products to compare list

  Scenario: user try to compare multiple products

    Given User logged in successfully

    When User try to compare multiple products

    Then Successful message for add products to compare list
    And Products should to be find into compare list page