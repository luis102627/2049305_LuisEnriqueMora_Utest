#Author: luis102627@gmail.com
Feature: as a user, I want to log in to the utest page

  Background:
    Given that the user is located on the utest main page
    When the user select the Log In button

  @LogInSuccessful
  Scenario: log in successful with account confirmed
    And the user enters his email and password
      | email               | password   |
      | luisem26@outlook.es | Illwait26* |
    Then the user should see an information card with the username Luis Enrique Mora

  @LogInFailedForInvalidUserOrPassword
  Scenario: log in failed for invalid user or password
    And the user enters his email and invalid password
      | email               | password    |
      | luisem26@outlook.es | Illwait266* |
    Then the user should see an alert with the following message Invalid username or password.

  @ValidateSignInButtonInactive
  Scenario: validate sign in button inactive
    And the user only enters his email
      | email               |
      | luisem26@outlook.es |
    Then the user should see the sign in button inactive


  @ValidateForgotPasswordButtonActive
  Scenario: validate forgot password button active
    Then the user should see the forgot password button