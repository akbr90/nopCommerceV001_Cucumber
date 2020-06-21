Feature: Login

  @sanity
  Scenario: Successful login with valid credentials
    Given User Launch Chrome Browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enter email as "admin@yourstore.com" and password as "admin"
    And Click on Login
    Then Page title should be "Dashboard / nopCommerce administration"
    When User Click on Log out Link
    Then Page title should be "Your store. Login"
    And Close Browser

  @regression
  Scenario Outline: Login Data Driven
    Given User Launch Chrome Browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enter email as "<email>" and password as "<password>"
    And Click on Login
    Then Page title should be "Dashboard / nopCommerce administration"
    When User Click on Log out Link
    Then Page title should be "Your store. Login"
    And Close Browser

    Examples: 
      | email                 | password   |
      | automation@tester.com | Tester#123 |
      | admin@yourstore.com   | admin      |
