Feature: User Registration


  Scenario: Successfully create an account

    Given I am using "chrome" as browser
    Given I am on the Create an Account page
    When I enter the date of birth dateOfBirth with the correct format
    And I enter the first name first Name
    And I enter the last name last Name
    And I enter the email address
    And I verify the email address
    And I choose  and enter a password
    And I retype the password
    And I select an Fan that describes my role in basketball
    And I select Terms and Conditions
    And I select responsibility term
    And I select communicationPreferencesFromBasketballEngland
    And I select communicationPreferencesFromPartnersOfBasketballEngland
    And I agree to the codeOfEthicsAndConduct
    And I click the confirm and Join button
    Then an account should be created successfully



  Scenario: Scenario: Create an account but last name missing

    Given I am using "edge" as browser
    Given I am on the Create an Account page
    When I enter the date of birth dateOfBirth with the correct format
    And I enter the first name first Name
    And I will leave the last name field blank
    And I enter the email address
    And I verify the email address
    And I choose  and enter a password
    And I retype the password
    And I select an Fan that describes my role in basketball
    And I select Terms and Conditions
    And I select responsibility term
    And I select communicationPreferencesFromBasketballEngland
    And I select communicationPreferencesFromPartnersOfBasketballEngland
    And I agree to the codeOfEthicsAndConduct
    And I click the confirm and Join button
    Then A warning message should be displayed on the last name field

  Scenario: The password does not match

    Given I am using "edge" as browser
    Given I am on the Create an Account page
    When I enter the date of birth dateOfBirth with the correct format
    And I enter the first name first Name
    And I enter the last name last Name
    And I enter the email address
    And I verify the email address
    And I choose  and enter a password
    And I enter a password that does not match
    And I select an Fan that describes my role in basketball
    And I select Terms and Conditions
    And I select responsibility term
    And I select communicationPreferencesFromBasketballEngland
    And I select communicationPreferencesFromPartnersOfBasketballEngland
    And I agree to the codeOfEthicsAndConduct
    And I click the confirm and Join button
    Then A warning message should be displayed on the password field


  Scenario: Terms and conditions are not accepted

    Given I am using "chrome" as browser
    Given I am on the Create an Account page
    When I enter the date of birth dateOfBirth with the correct format
    And I enter the first name first Name
    And I enter the last name last Name
    And I enter the email address
    And I verify the email address
    And I choose  and enter a password
    And I retype the password
    And I select an Fan that describes my role in basketball
    And I do not accept the terms and conditions
    And I select responsibility term
    And I select communicationPreferencesFromBasketballEngland
    And I select communicationPreferencesFromPartnersOfBasketballEngland
    And I agree to the codeOfEthicsAndConduct
    And I click the confirm and Join button
    Then A warning message should be displayed on the conditions are not accepted field


  Scenario Outline: Successfully create an account with Scenario Outline

    Given I am using "chrome" as browser
    Given I am on the Create an Account page
    When I enter the date of birth "<dateOfBirth>" with the correct format
    And I enter the first name"<fName>"
    And I enter the last name"<lName>"
    And I enter the email address
    And I verify the email address
    And I choose and enter a "<password>"
    And I retype the "<RetypePssword>"
    And I select an "<roles>" that describes my role in basketball
    And I select Terms and Conditions
    And I select responsibility term
    And I select communicationPreferencesFromBasketballEngland
    And I select communicationPreferencesFromPartnersOfBasketballEngland
    And I agree to the codeOfEthicsAndConduct
    And I click the confirm and Join button
    Then an account should be created successfully

    Examples:

      | dateOfBirth | fName   | lName   | password       | RetypePssword  | roles           |
      | 09/01/1991  | John    | Olson   | OfficerPass123 | OfficerPass123 | Welfare officer |
      | 10/05/2000  | Alice   | Johnson | PlayerPass456  | PlayerPass456  | Player          |
      | 03/11/1976  | Michael | Palm    | CoachPass789   | CoachPass789   | Coach           |
      




