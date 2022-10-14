Feature: Login and sort

  Scenario: Login. Sort by column
    When I am log in to the admin panel as user "admin1" with password "[9k<k8^z!+$$GkuP"
    Then I am successfully logged in "admin1"
    And admin panel is loaded

    When open a list of players
    Then table of the scrolls is loaded

    When sort by "Username"
    Then table is sorted by the selected "Username"
