Feature: Recommended Places Listing Page Tests

  Background:
    * I go to the Style Council Recommended Places Listing Page

  @desktop
  Scenario: Recommended Places Listing Page check on desktop

    Then The Recommended Places Listing page contains header "STYLE COUNCIL PLACES"
    And the Recommended Places Listing page contains breadcrumbs Home, The Style Council, Recommended Places

  @mobile
  Scenario: Member Listing Page check on mobile

    Then The Recommended Places Listing page contains header "STYLE COUNCIL PLACES"
    And the Recommended Places Listing page does not contain breadcrumbs Home, The Style Council, Recommended Places

  @desktop @mobile
  Scenario: Load more places

    Given Recommended Places Listing page displays 12 places
    And the 'Load More' element contains text 'Load 3 more places'
    When I click on Load 3 More Places and see spinner appearing  and disappearing
    And Recommended Places Listing page displays 15 places

  @desktop
  Scenario: Places block
    Then the places block contains place image, category, name, location and shows who has recommended it

  @mobile
  Scenario: Places block
    Then the places block contains place image, category, name, location and does not show who has recommended it
