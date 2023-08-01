@regression
Feature: SC01_User could register in with valid data successfully

  Scenario: User register with valid data

    #PRERQUISITE
    Given User should have an Email to register
    And User navigate to register page


    # STEPS
    When User enter valid data to inputs


    # EXPECTED RESULTS
    Then User could be register successfully