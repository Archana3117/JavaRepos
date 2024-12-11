Feature: User Registration.

  @SmokeTest @Regression @Registration @mandatory-fileds
  Scenario: Register with mandatory fileds
    Given User navigates to Register Account page
    When User enters first name "Archana" into the First Name field
    And Enters lastname "Mahjan" into the Last Name field
    And Enters email address "archana123@gmail.com" into the Email field
    And Enters telephone "1234567890" into the Telephone field
    And Enters password "12345" into the Password field
    And Enters password "12345" into the Password Confirm field
    And Selects Privacy Policy field
    And Click on Continue button
    Then Account should get successfully created

  @SmokeTest @Regression @Registration @all-fileds
  Scenario: Register with all fields
    Given User navigates to Register Account page
    When User enters first name "Archana" into the First Name field
    And Enters lastname "Mahjan" into the Last Name field
    And Enters email address "archana123@gmail.com" into the Email field
    And Enters telephone "1234567890" into the Telephone field
    And Enters password "12345" into the Password field
    And Enters password "12345" into the Password Confirm field
    And Selects Yes for Newsletter
    And Selects Privacy Policy field
    And Click on Continue button
    Then Account should get successfully created

  @SmokeTest @Regression @Registration @any-fileds
  Scenario: Register without providing any fields
    Given User navigates to Register Account page
    When User don't enter details into any fields
    And Click on Continue button
    Then User  Warning message should be displayed for all mandatory fields
