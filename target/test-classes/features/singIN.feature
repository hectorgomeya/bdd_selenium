Feature: sing in
    Scenario: Sing a new user
        Given Go to Sing In page
        Then Sing In "11212asasds" and password "1112"
        And Login form in login page
        And Insert user "11212asasds" and password "1112" and "CORRECTO"
