Feature: User want to update leave and shift preferences

#  @Regression @WeeklyLeavePreferences
#  Scenario Outline: User wants to login and update the weekly leave preferences
#    Given The user calls "loginAPI" with "<username>" and password
#    #And The the "shift_preference" "deadline" is active
#    When User add the following days "<days>" to "leavePreferences" with <id>
#    Then The preferences are posted to "leavePreferences"
#
#    Examples:
#      |  id  | username             | days                |
#      |   3  | dan@qburst.com       | Tuesday; Thursday   |
#      |  140 | josna@qburst.com     | Tuesday; Saturday   |
#      |  139 | dipu@qburst.com      | Tuesday; Saturday   |
#      |  156 | dilna@qburst.com     | Saturday; Tuesday   |
#      |   6  | akhil.su@qburst.com  | Monday; Tuesday     |
#      |  147 | saheer@qburst.com    | Saturday; Friday    |
#
#  @Regression @WeeklyShiftPreferences
#  Scenario: User wants to login and update the weekly shift preferences
#    Given The user calls "loginAPI" with "<username>" and password
#    #And The the "shift_preference" "deadline" is active
#    When The user posts the shift preferences at "shiftPreferences" API
#    Then  The preferences are posted to "shiftPreferences" API

  Scenario Outline: User wants to login and update the weekly leave preferences
    Given The user calls "loginAPI" with "<username>" and password
    When User add the following days to "leavePreferences" with id
    Then The preferences are posted to "leavePreferences"


    Examples:
      |       username           |
      |dipu@qburst.com           |
      |josna@qburst.com          |
      |akhil.suresh@qburst.com   |
      |anuroop.s@qburst.com      |
      |anna.franco@qburst.com    |
      |anjitha.anil@qburst.com   |
      |jishnu.v@qburst.com       |
      |thushara@qburst.com       |
      |saheer@qburst.com         |
      |rathika@qburst.com        |
      |milet@qburst.com          |
      |vipul@qburst.com          |
      |supriyar@qburst.com       |
      |simi@qburst.com           |
      |nidhinn@qburst.com        |
      |nithing@qburst.com        |
      |seena.vilson@qburst.com   |
      |dilna@qburst.com          |
      |maheswari@qburst.com      |
      |anildas@qburst.com        |
      |saffan@qburst.com         |
      |abini@qburst.com          |
      |shylesh@qburst.com        |
      |monisha@qburst.com        |
      |christopherd@qburst.com   |
      |ranju@qburst.com          |
      |indira@qburst.com         |
      |sadik@qburst.com          |
      |jijojoy@qburst.com        |
      |sreeja.s@qburst.com       |
      |ajay.mohan@qburst.com     |
      |sandeepkumar@qburst.com   |
      |neethuv@qburst.com        |
      |lino@qburst.com           |
      |vysakhk@qburst.com        |
      |vijin@qburst.com          |
      |vishnuprasad@qburst.com   |
      |abhinand@qburst.com       |
      |soumyac@qburst.com        |
      |nishab@qburst.com         |
      |anujan@qburst.com         |
      |joedavis@qburst.com       |
      |vinutha@qburst.com        |
      |annmaria@qburst.com       |
      |vineeth.kumar@qburst.com  |
      |animesh.gaurav@qburst.com |
      |remyasasikumar@qburst.com |
      |vighnesh.muraly@qburst.com|
      |dan@qburst.com            |
      |vidya.r@qburst.com        |
      |gayathri.nair@qburst.com  |
      |akhil.su@qburst.com       |
      |anjisha@qburst.com        |