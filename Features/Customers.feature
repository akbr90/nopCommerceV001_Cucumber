Feature: Customers

  @sanity
  Scenario: Add a new Customer
    Given User Launch Chrome Browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enter email as "admin@yourstore.com" and password as "admin"
    And Click on Login
    Then User can view Dashboard
    When User Click on customers menu
    And click on customers Menu Item
    And click on Add new button
    Then User can view Add new customer page
    When User enter customer info
    And click on Save button
    Then User can view confirmation message "The new user has been added successfully."
    And Close Browser
