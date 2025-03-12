package stepDefs.admin;

import Utils.AdminEndpoints;
import Utils.CommonEndpoints;
import Utils.LoginCookies;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pojo.adminPayloads.InitiateSurveyPayload;
import stepDefs.BaseTest;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class InitiateSurvey extends BaseTest
{
    @Given("Admin has a scheduleStartDate {string} scheduleEndDate {string} and deadlineDate {string}.")
    public void setPayload(String startDate, String endDate, String deadline)
    {
        surveyDates.setStartDate(startDate);
        surveyDates.setEndDate(endDate);
        surveyDates.setMonthlyPreferenceDeadline(deadline);
    }

    @When("Admin logs into the {string} with username and password")
    public void adminLogin(String endpoint) throws IOException {
        user.setPassword("ShiftScheduler@qburst");
        user.setEmail("dipu@qburst.com");

        CommonEndpoints api = CommonEndpoints.valueOf(endpoint);

        LoginCookies.setAccessToken(given().spec(requestSpecification())
                .body(user).post(api.getEndpoint()).getCookie("accessTokenCookie"));
    }
    @And("The payload is posted to API {string}")
    public void surveyPostCall(String endpoint) throws IOException
    {

        AdminEndpoints api = AdminEndpoints.valueOf(endpoint);

        given().spec(requestSpecification())
                .cookie("accessTokenCookie", LoginCookies.getAccessToken())
                .body(surveyDates).post(api.getEndpoint());
    }
    @Then("The survey should be initiated at {string}.")
    public void verify(String endpoint) throws IOException {
        AdminEndpoints api = AdminEndpoints.valueOf(endpoint);
        given().spec(requestSpecification())
                .cookie("accessTokenCookie", LoginCookies.getAccessToken())
                .get(api.getEndpoint())
                .then().assertThat().body("EndDate", equalTo(surveyDates.getEndDate()))
                .body("StartDate", equalTo(surveyDates.getStartDate()));
                //.body("", equalTo(surveyDates.getMonthlyPreferenceDeadline()));
    }
}
