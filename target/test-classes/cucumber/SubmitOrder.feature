@tag
Feature: Purchase the order from ecommerce website
  I want to use this template for my feature file

 Background:
Given I landed on Ecommerce Page

  @tag2
  Scenario Outline: Positive Test of submitting the Order
    Given Logged in with username <name> and password <password>
    When I add product <productName> to cart
    And Checkout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on ConfirmationPage

    Examples: 
      | name  														| password 	| productName 		| 
      | vidhyaprakash.document@gmail.com 	| 121122@Vn | ADIDAS ORIGINAL	|
