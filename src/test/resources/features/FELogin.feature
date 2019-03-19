@FrontEnd
Feature: FrontEnd - Login

As a user, I want to login sucessfully on FrontEnd site

#-------------------------------------------------------------------------------
  @FELogin
  Scenario: FE001-Login - Login sucessful
    Given User on the Front-End Login Page
    When  User log in
              |user@phptravels.com|demouser|
    Then  User should see main page display

