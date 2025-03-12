Feature: Add, edit and delete roles

  Scenario: Admin wants to add new roles
    Given The admin calls "loginAPI" with username and password
      |   username    |       password      |
      |dipu@qburst.com|ShiftScheduler@qburst|
    Then The admin posts new roles to the "role" API