Feature: User Registration

  Scenario: Successfully create an account

    Given I am on the "Create an Account" page
    When I enter the date of birth "<dateOfBirth>" with the correct format
    And I enter the first name"<fName>"
     And I enter the last name"<lName>"
    And I enter the email address"<TestName@gmail.com>"
    And I verify the email address"<TestName@gmail.com>"
    And I choose  and enter a password"<PassWord>"
    And I retype the password"<PassWord>"
    And I select an "<Fan>" that describes my role in basketball
    And I select "<Terms and Conditions>"
    And I select responsibility term
    And I select communicationPreferencesFromBasketballEngland
    And I select communicationPreferencesFromPartnersOfBasketballEngland
    And I agree to the codeOfEthicsAndConduct
    And I click the confirm and Join button
    Then an account should be created successfully
