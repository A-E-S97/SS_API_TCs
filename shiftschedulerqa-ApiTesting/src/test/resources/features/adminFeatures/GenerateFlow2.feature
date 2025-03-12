Feature: Review leave preferences

  Scenario: Admin approves all posted leaves.
    Given The survey is initiated and the "monthly_preference" "deadline" is over
    When The members have submitted the "leave" and "unavailable_weekend" preferences on API "leaveReq"
    Then The admin approves all "leave" and "unavailable_weekend" preferences on API "leaveReq"

  Scenario: Admin  approves some leaves and rejects the rest.
#    Given The survey is initiated and the "monthly_preference" "deadline" is over
    When The members have submitted the "leave" and "unavailable_weekend" preferences on API "leaveReq"
#    Then The admin reviews and update preferences on API "leaveReq"
#      |id |       type        | Status |
#      |641|unavailable_weekend|approved|
#      |551|       leave       |approved|
#      |642|unavailable_weekend|rejected|
#      |717|unavailable_weekend|approved|
#      |718|unavailable_weekend|approved|
#      |719|unavailable_weekend|rejected|
#      |720|unavailable_weekend|approved|
#      |721|unavailable_weekend|approved|
#      |620|       leave       |approved|

