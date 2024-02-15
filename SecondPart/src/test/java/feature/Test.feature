@tag
Feature: Test Add To Cart


  Scenario: Add three items to cart
    Given user in login
    When user add two items to cart
    And user add item from search to cart
    Then Go to cart and find three items
