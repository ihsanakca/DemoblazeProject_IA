Feature: Negative Login test - The user should NOT able to login with invalid credentials

  Background: Go to home page login
    Given The user is on the login page

    @negativeLoginTest
  Scenario Outline: Negative Scenario - The user should NOT able to login with invalid credentials
    When The user enters username "<invalidUsername>" and password "<invalidPassword>" click login button
    Then Verify that invalid "<message>"

    Examples:
      | invalidUsername  | invalidPassword | message                                |
      | sgezer@gmail.com |                 | Please fill out Username and Password. |
      |                  | 12345678        | Please fill out Username and Password. |
      |                  | wrong           | Please fill out Username and Password. |
      | sgezer@gmail.com | wrong           | Wrong password.                        |
      | wrong            | 12345678        | User does not exist.                   |
      | wrong            | wrong           | User does not exist.                   |
      |                  |                 | Please fill out Username and Password. |
