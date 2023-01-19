Feature: Verifying the login functions with valid details
  Scenario: Login functions with valid details and checking the output
    Given Open Firefox and launch the application "/V4/"
    When userid "mngr471324" is entered
    And password "abEzesU" is entered
    And click on "Login" button
    Then the page must be redirected to "/V4/manager/Managerhomepage.php"
    And title is "Guru99 Bank Manager HomePage"


  Scenario: Verifying Login Section with invalid inputs

    Given Open Firefox and launch the application "/V4/"
    When userid "mngr4713245" is entered
    And password "abEzesU3" is entered
    And click on "Login" button
    Then the page must display error popup with message "User or Password is not valid"

