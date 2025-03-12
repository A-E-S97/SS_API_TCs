Feature: Validate the response calender/day API

  Scenario Outline: Verify that a shift is appearing only once in the today view.
    Given The user calls "loginAPI" with "akhil.su@qburst.com" and password
    And The user calls the project login endpoint "projectLogin"
    When The user calls the "shiftTodayView" for "<date>"
    Then The shifts are not repeated
    And Employees are not duplicated

    Examples:
      |    date     |
      |	2023-11-01	|
      |	2023-11-02	|
      |	2023-11-03	|
      |	2023-11-04	|
      |	2023-11-05	|
      |	2023-11-06	|
      |	2023-11-07	|
      |	2023-11-08	|
      |	2023-11-09	|
      |	2023-11-10	|
      |	2023-11-11	|
      |	2023-11-12	|
      |	2023-11-13	|
      |	2023-11-14	|
      |	2023-11-15	|
      |	2023-11-16	|
      |	2023-11-17	|
      |	2023-11-18	|
      |	2023-11-19	|
      |	2023-11-20	|
      |	2023-11-21	|
      |	2023-11-22	|
      |	2023-11-23	|
      |	2023-11-24	|
      |	2023-11-25	|
      |	2023-11-26	|
      |	2023-11-27	|
      |	2023-11-28	|
      |	2023-11-29	|
      |	2023-11-30	|