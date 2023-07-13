Feature: Find different products
  Scenario: Find cellphone
    Given Login form in login page
    When Insert user "asd" and password "asd" and "CORRECTO"
    Then Find product "Samsung galaxy s6" and category "phones"
