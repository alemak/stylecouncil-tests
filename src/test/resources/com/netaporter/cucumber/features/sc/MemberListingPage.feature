Feature: Member Listing Page Tests

  Background:
    * I go to the Style Council Member Listing Page

  @desktop
  Scenario: Member Listing Page check on desktop

    Then The Member Listing page contains header "STYLE COUNCIL MEMBERS"
    And the Member Listing page contains breadcrumbs Home, The Style Council, Style Council Members

  @mobile
  Scenario: Member Listing Page check on mobile

    Then The Member Listing page contains header "STYLE COUNCIL MEMBERS"
    And the Member Listing page does not contain breadcrumbs Home, The Style Council, Style Council Members

  @desktop @mobile
  Scenario: Load more members

    Given Member Listing page displays 12 members
    And the 'Load More' element contains text 'Load 3 more members'
    When I click on Load 3 More Members and see spinner appearing  and disappearing
    And Member Listing page displays 15 members

  @desktop
  Scenario: Member block
    Then the member block contains member image, profession, full name, city and shows number of recommendations

  @mobile
  Scenario: Member block
    Then the member block contains member image, profession, full name, city and does not show number of recommendations

  @desktop @mobile
  Scenario: Navigation to member details page
    When I click on the member item
    Then I am taken to this member's details page