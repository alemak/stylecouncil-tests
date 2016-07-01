Feature: Member Details Page Tests

  Background:
    * I go to Cary Fukunaga Member Details Page

  @desktop @mobile
  Scenario: Member details page checks

    Then I can see the image of the SC member
    And I can see the member biography
    And I can see interview component
    And I can see headline with member name in uppercase
    And I can see the recommended products component
    And I can see the recommended places component

  @desktop
  Scenario: Member Details Page breadcrumbs check on desktop

    Then the Member Details page contains breadcrumbs Home, The Style Council, Style Council Members, Mr. Cary Fukunaga

  @mobile
  Scenario: Member Listing Page breadcrumbs check on mobile

    And the Member Details page does not contain breadcrumbs Home, The Style Council, Style Council Members, Mr. Cary Fukunaga

  @desktop
  Scenario: Recommended Places block
    Then the Recommended Places block contains place image, category, name, location and shows the quote and who the place is recommended by

  @mobile
  Scenario: Recommended Places block
    Then the Recommended Places block contains place image, category, name, location and does not show the quote and who the place is recommended by