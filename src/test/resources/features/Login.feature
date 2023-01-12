Feature: Verifying the login functions with valid details
  Scenario: Login functions with valid details
    Given Open Firefox and launch the application "http://www.demo.guru99.com/V4/"
    When userid "mngr471324" is entered
    And password "abEzesU" is entered
    And click on "Login" button

