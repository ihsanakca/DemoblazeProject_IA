Feature: Login Test- The user should be able to login with valid credentials

  Background: Go to home page login
    Given The user is on the login page

  @loginwithoutparameters
  Scenario: Positive Scenario 1 - user should be able to login
    When The user enters valid credentials
    Then Verify welcome "Welcome sgezer@gmail.com"

  @loginwithparameters
  Scenario: Positive Scenario 2 - user should be able to login
    When The user enters username "sgezer@gmail.com" and password "12345678" click login button
    Then Verify welcome "Welcome sgezer@gmail.com"

  @loginwithScenarioOutline
  Scenario Outline: Positive Scenario 3 - user should be able to login
    When The user enters username "<username>" and password "<password>" click login button
    Then Verify welcome "<welcomeUser>"
    Examples:
      | username         | password | welcomeUser              |
      | sgezer@gmail.com | 12345678 | Welcome sgezer@gmail.com |

  @loginwithDataTableScenarioOutline
  Scenario Outline: Positive Scenario 4 - user should be able to login
    When The user enters valid username and password
      | username | <user>     |
      | password | <password> |
    Then Verify welcome "<welcomeUser>"

    Examples:
      | user             | password | welcomeUser              |
      | sgezer@gmail.com | 12345678 | Welcome sgezer@gmail.com |




  @loginwithDataTable
  Scenario: Positive Scenario 5 - user should be able to login
    When The user enters valid username and password
      | username | sgezer@gmail.com |
      | password | 12345678         |
    Then Verify welcome "Welcome sgezer@gmail.com"

