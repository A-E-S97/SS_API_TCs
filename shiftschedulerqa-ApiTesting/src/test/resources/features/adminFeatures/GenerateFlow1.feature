Feature: Generate shift workflow

  Scenario Outline: Admin wants to initiate survey
    Given Admin has a scheduleStartDate "<startDate>" scheduleEndDate "<endDate>" and deadlineDate "<deadline>".
    When Admin logs into the "loginAPI" with username and password
    And The payload is posted to API "initiateSurvey"
    Then The survey should be initiated at "shiftGenStatus".

    Examples:
    |      startDate     |       endDate      |      deadline      |
    |2023-09-01T00:00:00Z|2023-08-31T00:00:00Z|2023-08-25T00:00:00Z|
    |2023-08-01T00:00:00Z|2023-08-31T00:00:00Z|2023-08-25T00:00:00Z|
#    |2023-09-01T00:00:00Z|2023-09-30T00:00:00Z|2023-08-25T00:00:00Z|
    |2023-09-01T00:00:00Z|2023-09-31T00:00:00Z|2023-10-25T00:00:00Z|

