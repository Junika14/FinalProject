@web
Feature: Order Item

  Background:
    Given the user already logged with username "smoo" and password "password"

  Scenario: Successfully added item to cart
    And the user clicks the item
    When the user clicks "Add to cart" button
    Then the message appear "Product added."

  Scenario: Successfully checkout the item
    And the user clicks "Cart" menu
    And the user clicks "Place Order" button
    And the user inputs place order form with details:
      | name        | Jin        |
      | country     | Indonesia  |
      | city        | Jakarta    |
      | credit card | 12112111   |
      | month       | November   |
      | year        | 2024       |
    When the user clicks "Purchase" button
    Then the Id order appear

