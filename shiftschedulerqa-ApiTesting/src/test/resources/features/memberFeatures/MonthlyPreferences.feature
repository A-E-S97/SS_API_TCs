Feature: User wants to post and delete monthly preferences

  @Regression @monthly_Preferences @ignore
  Scenario Outline: User wants to submit leave preferences
    Given User's leave "<leaveDate>" is according to "deadline"
    When The "leave" dates are send with "<reason>" to "monthly_Preferences"
    Then The "monthly_Preferences" are submitted
    Examples:
    |      leaveDate     |   reason    |
    |2023-09-14T00:00:00Z|Test Reason 1|
    |2023-09-15T00:00:00Z|Test Reason 2|
    |2023-09-16T00:00:00Z|Test Reason 3|
    |2023-09-17T00:00:00Z|Test Reason 4|
    |2023-09-18T00:00:00Z|Test Reason 5|
    |2023-10-18T00:00:00Z|Test Reason y|

  @ignore
  Scenario Outline: User wants to submit unavailable weekend preferences
    Given User's leave "<unavailable_weekend>" is according to "deadline"
    When The "unavailable_weekend" dates are send with "<w_reason>" to "monthly_Preferences"
    Then The "monthly_Preferences" are submitted
    Examples:
      |unavailable_weekend |  w_reason   |
      |2023-09-02T00:00:00Z|Test Reason 6|
      |2023-09-03T00:00:00Z|Test Reason 7|
      |2023-09-09T00:00:00Z|Test Reason 8|
      |2023-09-10T00:00:00Z|Test Reason 9|
      |2023-09-11T00:00:00Z|Test Reason x|
      |2023-10-14T00:00:00Z|Test Reason z|

  @ignore
  Scenario Outline: User wants to delete leave preferences
    Given User has posted a "<preference>" on given "<leaveDate>" at "monthly_Preferences"
    When User send a delete request to "monthly_Preferences"
    Then  The "<preference>" is deleted from "monthly_Preferences"
    Examples:
      |     leaveDate      |     preference    |
      |2023-09-14T00:00:00Z|       leave       |
      |2023-09-15T00:00:00Z|       leave       |
      |2023-09-16T00:00:00Z|       leave       |
      |2023-09-18T00:00:00Z|       leave       |
      |2023-10-18T00:00:00Z|       leave       |
      |2023-09-02T00:00:00Z|unavailable_weekend|
      |2023-09-03T00:00:00Z|unavailable_weekend|
      |2023-08-09T00:00:00Z|unavailable_weekend|
      |2023-08-10T00:00:00Z|unavailable_weekend|
      |2023-08-11T00:00:00Z|unavailable_weekend|
      |2023-10-14T00:00:00Z|unavailable_weekend|

