Feature: Feature to Add product in cart

  @AddToCartFeature @test
  Scenario: To verify product is added successfully in shopping cart
    Given user is on flipkart login page
    When user clicks on SignIn
    And user enters username "8377899666" and password "Monika123"
    And user navigates to Remote-control toys
    And select toy and add to cart
    Then Toy must be added in the cart