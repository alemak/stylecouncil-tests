Feature: Landing Page Tests

  Background:
    * I go to the Style Council Home page

  @desktop @mobile
  Scenario: Home page
    Then The Home page contains header "STYLECOUNCIL"

  @desktop @mobile
  Scenario Outline: Navigation from home page
    When I click on <link> link
    Then I am taken to the <page> page

    Examples:
      | link        | page                       |
      | All Members | Member Listing             |
      | All Places  | Recommended Places Listing |