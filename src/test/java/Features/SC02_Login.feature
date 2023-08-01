@regression
Feature: SC02_User could log in with valid email and password

  Scenario: User log in with valid email and password

    #PRERQUISITE
    Given User navigate to login page


    # STEPS
    When User enter valid email and valid password

    And User Click to login button

    # EXPECTED RESULTS
    Then User could be logged in successfully