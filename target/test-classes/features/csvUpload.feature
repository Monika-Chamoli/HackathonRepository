
Feature: Feature to Upload CSV file

  @UploadCSV @test
  Scenario: To verify CSV file is uploaded successfully
    Given user is on flipkart login page
    When user clicks on SignIn
    And user read credentials from CSV file and signIn
    Then user must be logged in to Flipkart application


