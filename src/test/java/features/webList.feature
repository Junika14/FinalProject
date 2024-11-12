Feature: SignUp Login feature

  @web
  Scenario: Signup with valid input data
    Given the user in on the main page
    And the user click "Sign Up" menu
    And the user input username dynamic
    And the user input password "password"
    When the user click the "Sign Up" button
    Then Successful sign up message appear "Sign up successful."

  @web
  Scenario: Signup with empty data
    Given the user in on the main page
    And the user click "Sign Up" menu
    When  the user click the "Sign Up" button
    Then the message error appear "Please fill out Username and Password."

  @web
  Scenario: Signup with already registered user
    Given  the user in on the main page
    And the user click "Sign Up" menu
    And the user input username already registered "smoo"
    And the user input password "password"
    When the user click the "Sign Up" button
    Then the message error appear "This user already exist."

  @web
  Scenario: successfully login with the already registered user
    Given the user in on the main page
    And the user click "Login" menu
    And the user input the registered username "smoo" and password "password"
    When the user click the "Login" button
    Then user navigate to home page

  @web
  Scenario: unsuccessfully login with the wrong password
    Given the user in on the main page
    And the user click "Login" menu
    And the user input the registered username "smoo" and password "pass"
    When the user click the "Login" button
    Then the message error appear "Wrong password."











