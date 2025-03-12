package stepDefs;

import Utils.RequestBuilder;
import com.github.javafaker.Faker;
import io.cucumber.java.Before;
import io.restassured.response.Response;
import pojo.*;
import pojo.adminPayloads.*;

public class BaseTest extends RequestBuilder
{
    protected static Response apiResponse;
    protected Faker faker;
    protected User user = new User();
    protected UnavailabilityPayload uva = new UnavailabilityPayload();
    protected PhoneNum num = new PhoneNum();
    protected ShiftPreferenceData leaveData = new ShiftPreferenceData();
    protected WeekOffPayload weekOff = new WeekOffPayload();
    protected InitiateSurveyPayload surveyDates = new InitiateSurveyPayload();
    protected LeaveManagementPayload LMPyd = new LeaveManagementPayload();
    protected MonthlyPreference MonthlyPref = new MonthlyPreference();
    protected MemberDetails memberDetails = new MemberDetails();
    protected PutShift shiftPayload = new PutShift();
    protected Roles userRolePayload = new Roles();

    //    JsonPath = apiResponse.jsonPath();
}
