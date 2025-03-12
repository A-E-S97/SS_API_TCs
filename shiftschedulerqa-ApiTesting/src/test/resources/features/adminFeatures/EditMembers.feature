Feature: Assign roles to all employees

  Scenario: Admin edits member details to assign roles to all employees
    Given The admin calls "loginAPI" with username and password
      |   username    |       password      |
      |dipu@qburst.com|ShiftScheduler@qburst|
    When The admin sends a put request to "members" API with id and new role
      |id |  role    |
      |3  |  L3 |
      |4  |  L3 |
      |5|  L3 |
      |6|  L3 |
      |7|  L3 |
      |8|  L3 |
      |9|  L3 |
      |10|  L3 |
      |24|  L3 |
      |31|  L3 |
      |42|  L3 |

#    Then  The role should be updated in the members' "members" profile "<id>".

#    |2 |L2  |