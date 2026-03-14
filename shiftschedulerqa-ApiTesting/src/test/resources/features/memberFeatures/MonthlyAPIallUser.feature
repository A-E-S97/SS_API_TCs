Feature: Verify that the monthly schedule is available in all logins

  @MonthlySchedule
  Scenario Outline: Check whether the monthly data is loaded for "<username>"
      Given The user calls "loginAPI" with "<username>" and password
      When The "shiftMonthlyView" API is is called
      Then Log "<username>" if the API response code is not 200

    Examples:
      |        username           |
      |dhgni@qburst.com           |
      |aesffh@qburst.com          |
      |akhilvvghcxxt@qburst.com   |
      |bbbbnnbhhs@qburst.com      |
      |afranhvbvcco@qburst.com    |
      |anjytcffvvvil@qburst.com   |
      |jishnbbby@qburst.com       |
      |hffyhgvhb@qburst.com       |
      |uugggug@qburst.com         |
      |use10jbb@qburst.com        |
      |u11fff@qburst.com          |
      |u12jjj@qburst.com          |
      |u13uhhhhh@qburst.com       |
      |ihhhh@qburst.com           |
      |kjnnnnnn@qburst.com        |
      |kjijihih@qburst.com        |
      |hjhhjjhhjhhjh@qburst.com   |
      |jhhhjh@qburst.com          |
      |ijjjijijij@qburst.com      |
      |oiuuihhh@qburst.com        |
      |okjkjjh@qburst.com         |
      |ljojii@qburst.com          |
      |ijhihihh@qburst.com        |
      |yytrerfc@qburst.com        |
      |ydffttgfghfff@qburst.com   |
      |jjhiuh@qburst.com          |
      |ujgugug@qburst.com         |
      |ugygyg@qburst.com          |
      |kjhhuhhu@qburst.com        |
      |oiiivvyys@qburst.com       |
      |jhhjhuuuuuu@qburst.com     |
      |jhhjjjhhjhjhj@qburst.com   |
      |ijjijhij@qburst.com        |
      |oinoh@qburst.com           |
      |vysaykhk@qburst.com        |
      |jugjgj@qburst.com          |
      |ugguggugugugg@qburst.com   |
      |guggguuug@qburst.com       |
      |uguguggg@qburst.com        |
      |jugguyg@qburst.com         |
      |hiijhih@qburst.com         |
      |uyhuhuhhh@qburst.com       |
      |uhyyyyyy@qburst.com        |
      |hggygygyy@qburst.com       |
      |vijj8888mar@qburst.com     |
      |uguhuuhuhh@qburst.com      |
      |uuuuuuuuuu@qburst.com      |
      |hggguguughhhily@qburst.com |
      |dn@qburst.com              |
      |r@qburst.com               |
      |bbbty97ir@qburst.com       |
      |jhgg5544@qburst.com        |
      |gtt6677@qburst.com         |
