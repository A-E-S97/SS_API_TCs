Feature: Admin wants to add new shifts for the

  Scenario: Admin adds new shifts and corresponding role constrains
    Given The admin calls "loginAPI" with username and password
      |   username    |       password      |
      |dipu@qburst.com|ShiftScheduler@qburst|
    #The following step creates the request payload for the the post shift API
    #All the parameters are retrieved from src/test/resources/API Data.xlsx
    Then The admin posts the parameters and constrains for the new shift to API "shiftEdit"
