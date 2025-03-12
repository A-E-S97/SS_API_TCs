Feature: ShiftScheduler Login and Profile

  @Login
 Scenario Outline: Team member logs into the application
    Given I send a request to endpoint "loginAPI" with username "<email>" and password
    Then The API's return status is 200
    And Response should contains result "Success"
    And Access token cookie is not null

    Examples:
      | email               | password              |
      | dan@qburst.com      | ShiftScheduler@qburst |
      | dipu@qburst.com     | ShiftScheduler@qburst |
      | dilna@qburst.com    | ShiftScheduler@qburst |
      | anuroop.s@qburst.com| ShiftScheduler@qburst |


  @Phone
  Scenario Outline: User wants to update phone number
    Given User "<username>" post new phone number to "phUpdateAPI"
    When The API's return status is 200
    And Response should contains result "Success"
    Then Phone number is updated in the "profileAPI" for "<username>"

    Examples:
      | username                   |
      | dipu@qburst.com            |
      | josna@qburst.com           |
      | akhil.suresh@qburst.com    |
      | anuroop.s@qburst.com       |
      | anna.franco@qburst.com     |
      | anjitha.anil@qburst.com    |
      | jishnu.v@qburst.com        |
      | thushara@qburst.com        |
      | saheer@qburst.com          |
      | rathika@qburst.com         |
      | milet@qburst.com           |
      | vipul@qburst.com           |
      | supriyar@qburst.com        |
      | simi@qburst.com            |
      | nidhinn@qburst.com         |
      | nithing@qburst.com         |
      | seena.vilson@qburst.com    |
      | dilna@qburst.com           |
      | maheswari@qburst.com       |
      | anildas@qburst.com         |
      | saffan@qburst.com          |
      | abini@qburst.com           |
      | shylesh@qburst.com         |
      | monisha@qburst.com         |
      | christopherd@qburst.com    |
      | ranju@qburst.com           |
      | indira@qburst.com          |
      | sadik@qburst.com           |
      | jijojoy@qburst.com         |
      | sreeja.s@qburst.com        |
      | ajay.mohan@qburst.com      |
      | sandeepkumar@qburst.com    |
      | neethuv@qburst.com         |
      | lino@qburst.com            |
      | vysakhk@qburst.com         |
      | vijin@qburst.com           |
      | vishnuprasad@qburst.com    |
      | abhinand@qburst.com        |
      | soumyac@qburst.com         |
      | nishab@qburst.com          |
      | anujan@qburst.com          |
      | joedavis@qburst.com        |
      | vinutha@qburst.com         |
      | annmaria@qburst.com        |
      | vineeth.kumar@qburst.com   |
      | animesh.gaurav@qburst.com  |
#      | remyasasikumar@qburst.com  |
#      | vighnesh.muraly@qburst.com |
#      | dan@qburst.com             |
#      | vidya.r@qburst.com         |
#      | gayathri.nair@qburst.com   |
#      | akhil.su@qburst.com        |
#      | anjisha@qburst.com         |