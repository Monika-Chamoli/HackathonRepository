
Feature: Feature to View Product page

  @ViewProductPage @test
  Scenario: To verify product page on flipkart
    Given user is on flipkart login page
    When user clicks on SignIn
    And user enters username "8377899666" and password "Monika123"
    And user navigates to Remote-control toys
    Then user view Product Page


