Feature: Average game rating.

  Scenario: Checking if the average rating on the game page matches one from API
    Given Homepage is opened

    When  click on side bar menu btn
    And we are opening top game with increasing rank
    And we are requesting information about the game from API
    And we open game statistics page

    Then Average rating matches the one found on the game page
    And Close browser


