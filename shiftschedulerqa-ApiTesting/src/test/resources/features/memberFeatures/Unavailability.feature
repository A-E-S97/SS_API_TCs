Feature: Unavailability

  @Regression @Unavailability
  Scenario Outline: Post unavailability on valid dates
    Given The user calls "loginAPI" with "<username>" and password
    And User "<username>" have a "shift" allotted on the "<date>"
    When User hasn't already posted an "unavailability" for the same "<date>"
    Then User posts "unavailability" with date and "<reason>"
    And The API's return status is 200
    And "<date>" should be posted in the API "unavailability"
    #And Replacement procedure is initiated.

      Examples:
        |date        |reason          |       username           |
#        |2023-08-16  |Emergency       |dipu@qburst.com           |
#        |2023-08-17  |Medical         |dipu@qburst.com           |
        |2023-10-31  |Personal        |dipu@qburst.com           |
        |2023-10-30  |Personal        |dipu@qburst.com           |
#        |2023-08-16  |Emergency       |josna@qburst.com          |
        |2023-10-31  |Medical         |josna@qburst.com          |
        |2023-10-30  |Personal        |josna@qburst.com          |
        |2023-10-31  |Emergency       |akhil.suresh@qburst.com   |
        |2023-10-30  |Medical         |akhil.suresh@qburst.com   |
#        |2023-08-04  |Personal        |akhil.suresh@qburst.com   |
        |2023-10-30  |Emergency       |anuroop.s@qburst.com      |
        |2023-10-31  |Medical         |anuroop.s@qburst.com      |
#        |2023-08-07  |Personal        |anuroop.s@qburst.com      |

  Scenario Outline: Verify that the Unavailability API is working for all users
    Given The user calls "loginAPI" with "<username>" and password
    Then User posts "unavailability" with date and reason if user has a shift "shift" allotted
      |   date     |reason          |
      |2023-08-28  |Emergency       |
      |2023-08-29  |Medical         |
      |2023-08-30  |Personal        |
      |2023-08-31  |Personal        |
      #|2023-08-25  |Emergency       |

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