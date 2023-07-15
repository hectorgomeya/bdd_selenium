Feature: Login Test Cases
@regression
  Scenario: login failed
    Given Login form in login page
    When Insert user "LUCIANO" and password "CABRERA" and "INCORRECTO"
