Feature: Retail Page Feature

  Background: 
    Given user is on Retail home Page
    When user click on MyAccount
    And user click on Login option
    And user enter userName "test.test@yahoo.com"  and password "123456"
    And user click on login button
    Then user should be logged into myAccount Page

  Scenario: Register as an Affiliate user with Cheque Payment Method
    When User click on Register for an Affiliate Account link
    And User fill affiliate form with below information
      | company   | website      | taxID  | paymentMethod | payeeName |
      | tekschool | tekschool.us | 123456 | Cheque        | test      |
    And User check on About us check box
    And User click on Continue button
    Then User should see a success message

  Scenario: Edit your affiliate information from Cheque payment method to Bank Transfer
    When User click on Edit your affiliate informationlink
    And user click on Bank Transfer radio button
    And User fill Bank information with below information
      | bankName | abaNumber | swiftCode | accountName | accountNumber |
      | BOA      | 123456789 |    258963 | TEK         |     147852369 |
    And User click on Continue button
    Then User should see a success message

  @Test
  Scenario: Edit your account Information
    When User click on Edit your account information link
    And User modify below information
      | firstname | lastName | email               | telephone  |
      | John      | Sean     | test.test@yahoo.com | 1012025588 |
    And User click on Continue button
    Then User should see a message 'Success: Your account has been successfully updated.'
