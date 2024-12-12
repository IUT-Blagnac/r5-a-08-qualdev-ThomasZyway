Feature: Cocktail Ordering

  As a person, I want to offer a drink to someone so that we can enjoy time together.

  Scenario: Creating an empty order
    Given "{string}" who wants to buy a drink
    When an order is declared for "{string}"
    Then there are {int} cocktails in the order

  Scenario: Adding cocktails to an order
    Given "Romeo" who wants to buy a drink
    When an order is declared for "Juliette"
    Then there are 0 cocktails in the order
