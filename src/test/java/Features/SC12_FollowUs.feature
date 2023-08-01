Feature: SC-12 User could have to follow the pages of website

  # Scenario #1
  Scenario: User opens facebook link

    Given User go to home page

    When User opens facebook link

    Then "https://www.facebook.com/Tunisianet.com.tn/" facebook page is opened

  # Scenario #2
  Scenario: User opens twitter link

    Given User go to home page

    When User opens twitter link

    Then "https://twitter.com/Tunisianet_TN" twitter page is opened

  # Scenario #3
  Scenario: User opens pinterest link

    Given User go to home page

    When User opens pinterest link

    Then "https://www.pinterest.com/tunisianet/" pinterest page is opened
  # Scenario #4
  Scenario: User opens youtube link

    Given User go to home page

    When User opens youtube link

    Then "https://www.youtube.com/@tunisianet" youtube page is opend
    # Scenario #5
  Scenario: User opens instagram link

    Given User go to home page

    When User opens instagram link

    Then "https://www.instagram.com/Tunisianet/" instagram page is opend

