Feature: Find different products
  Scenario: Find phones and get price and product
    Given Login form in login page
    When Insert user "asd" and password "asd" and "CORRECTO"
    Then Find product "Samsung galaxy s6" and category "phones"
    And Get price and product
    And Go to cart
    And validate order with product "Samsung galaxy s6" and price "360"
    And delete all products

