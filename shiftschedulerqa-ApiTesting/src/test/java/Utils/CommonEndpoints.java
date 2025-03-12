package Utils;

public enum CommonEndpoints {

    //Base API and base path
    //Base URL moved to the properties file
    //  baseAPI("http://13.232.205.16/api/v1"),

    callbackAPI("/user/callback"),

    deadline("/project/deadline"),
    googleConnectAPI("/user/connect"),
    helpLinks("/help-links") //Help Links
    ,
    leavePreferences("/project/leave-preferences") //leave preferences
    ,
    loginAPI("/user/login") //Login API
    ,

    projectLogin("/user/project-login")
    ,
    logoutAPI("/user/logout"),
    memberList("/project/members") //Team details
    ,

    monthly_Preferences("/project/monthly-preferences"),

    notifications("/project/notifications") //Notifications
    ,

    phUpdateAPI("/user/phone-number") //Profile APIs
    ,

    profileAPI("/user/profile"),

    projectDetails("/project") //Project Details
    ,

    refreshAPI("/user/refresh"),

    roleList("/project/roles") //Role details
    ,
    shift("/user/shifts") //User's shift of the selected day
    ,
    shiftList("/project/shifts") //List of all shifts
    ,

    shiftMonthlyView("/project/calendar/month") //Shift Monthly view
    ,

    shiftPreferences("/project/shift-preferences") //shift preferences
    ,

    shiftTodayView("/project/calendar/day") //Today's shift of all members
    ,

    unavailability("/project/unavailability"),

    verifyAPI("/user/verify");

    private String endpoint;

    CommonEndpoints(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getEndpoint() {
        return endpoint;
    }
}

