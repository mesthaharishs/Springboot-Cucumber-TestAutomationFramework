Feature: Google search with Scenario

  @google
  Scenario: I want to search on google site with scenario
    Given I am on the google site
    When I enter "spring boot" as a keyword
    Then I should see search results page
    Then I should see at least 5 results
