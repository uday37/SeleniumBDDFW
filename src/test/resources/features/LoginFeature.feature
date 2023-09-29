Feature: Verify the Amazon Login screen

  Background:
    Given open the amazon site

  Scenario: Successfully login with valid credentials
    Given I have enter valid "Testing@gmail.com" and "abcd123"
    When I have click on Login button
    Then I should be logged into Amazon site successfully

  Scenario Outline: : Unsuccessful login with invalid credentials
    Given I have enter invalid "<userName>" and "<passWord>"
    When  I have click on Login button
    Then I should see the error message indicating "<errorMessage>"

    Examples:
      | userName       | passWord | errorMessage                                     |
      | abcd           | abcd     | The username and password could not be verified. |
      | 1234@dsflk.com |          | Please enter a username and password.            |