Feature: Login Test Cases

  Scenario: login failed
    Given Login form in login page
    When Insert user "LUCIANO" and password "CABRERA" and "INCORRECTO"

  Scenario: login Ok
    Given Login form in login page
    When Insert user "asd" and password "asd" and "CORRECTO"