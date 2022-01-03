Feature: Feature to Verify that all the sort options work correctly

  @SortOption @test
  Scenario: To verify all sort options work correctly
    Given user is on flipkart login page
    When user clicks on SignIn
    And user enters username "8377899666" and password "Monika123"
    And user click on Men's Tshirt and select brands
    Then Selected brands product must be displayed