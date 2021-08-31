#Author: luis102627@gmail.com
Feature: as a user, I want to create an account on the utest page

  Background:
    Given that the user is located on the main page
    When the user select the join today button

  @SuccessfulAccount
  Scenario Outline: successful account creation

    And the user enters their personal information in the registration form
      | firstName   | lastName   | email   | month   | day   | year   | languaje   | city   | postalCode   | password   | confirmPassword   |
      | <firstName> | <lastName> | <email> | <month> | <day> | <year> | <languaje> | <city> | <postalCode> | <password> | <confirmPassword> |

    Then the user will see the message Welcome to the world's largest community of freelance software testers!

    Examples:
      | firstName | lastName | email                | month   | day | year | languaje | city          | postalCode | password   | confirmPassword |
      | Luis      | Mora     | luise456@outlook.es | October | 26  | 1995 | Italian  | Popayan Cauca | 235648     | Luis102627 | Luis102627      |

  @InvalidEmail
  Scenario: Invalid Email
    And the user enter email with invalid format
      | firstName | lastName | email |
      | Luis      | Mora     | email |
    Then the user should see the message Enter valid email

  @ValidationIncompleteForm
  Scenario: Incomplete Form
    And the user enter incomplete information in the form
      | firstName | lastName |
      | Luis      | Mora     |
    Then the user will not be able to continue with the registration

  @ValidationSecondForm
  Scenario: second form name validation
    And the user enter information in the first form
      | firstName | lastName | email                | month   | day | year | languaje |
      | Luis      | Mora     | luise4544@outlook.es | October | 26  | 1995 | Italian  |
    Then the user should see the form Add your address

  @ValidationNextLocationButtonActive
  Scenario: validation next location button active
    And the user enter information in some fields
      | firstName | lastName |
      | Luis      | Mora     |
    Then the user should see the next location button inactive

  @ValidationButtonBack
  Scenario: Back button function validation
    And the user enter information in the first form of register
      | firstName | lastName | email                 | month   | day | year | languaje |
      | Luis      | Mora     | luise78471@outlook.es | October | 26  | 1995 | Italian  |
    And the user select the back button
    Then the user should see again the form Tell us about yourself

  @ValidateDescriptionFormThree
  Scenario: validate description form number three
    And the user enter information in the forms of register
      | firstName | lastName | email                | month   | day | year | languaje | city               | postalCode |
      | Luis      | Mora     | lui56320@outlook.es | October | 26  | 1995 | Italian  | Pererira Risaralda | 235648     |
    Then the user will be able to see the description of form three

  @validateEqualkeys
  Scenario: validate equals keys
    And the user enters information with different keys
      | firstName | lastName | email               | month   | day | year | languaje | city          | postalCode | password    | confirmPassword |
      | Luis      | Mora     | lmo423657@outlook.es | October | 26  | 1995 | Italian  | Popayan Cauca | 235648     | Luis102627* | Luis102627      |
    Then the user should see the alert with the message Password mismatch

  @UnselectedTerms
  Scenario: validate unselected terms and policies
    And the user enters the complete information
      | firstName | lastName | email                | month   | day | year | languaje | city          | postalCode | password   | confirmPassword |
      | Luis      | Mora     | 4585lui75@outlook.es | October | 26  | 1995 | Italian  | Popayan Cauca | 235648     | Luis102627 | Luis102627      |
    But the user not select terms and policies and select complete setup button
    Then the user will not be able to complete their registration