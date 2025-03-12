Feature: The project details and related information is loaded

  @DashboardGetAPIs @Regression
  Scenario Outline: Project details, roles, shifts and holidays are available for user "<username>"
    Given The user calls "loginAPI" with "<username>" and password
    When The "projectDetails" API should return status code 200
    And The "profileAPI" API should return status code 200
    And The "shiftList" API should return status code 200
    And The "memberList" API should return status code 200
    And The "roleList" API should return status code 200
    Then The "shiftTodayView" should return status code 200
    And The "helpLinks" API should return status code 200

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
#      |remyasasikumar@qburst.com |
#      |vighnesh.muraly@qburst.com|
#      |dan@qburst.com            |
#      |vidya.r@qburst.com        |
#      |gayathri.nair@qburst.com  |
#      |akhil.su@qburst.com       |
