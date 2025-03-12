package stepDefs.admin;

import Utils.AdminEndpoints;
import Utils.CommonEndpoints;
import Utils.LoginCookies;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import pureRest.SimpleLogin;
import stepDefs.BaseTest;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import io.cucumber.datatable.DataTable;
//import cucumber.api.DataTable;
import static io.restassured.RestAssured.given;

public class LeaveManagement extends BaseTest {
    List<Object> leaveIdLst;
    List<Object> uavWknd;

    @Given("The survey is initiated and the {string} {string} is over")
    public void theSurveyIsInitiatedAndTheIsOver(String qParam, String endpoint) throws IOException {
        CommonEndpoints api = CommonEndpoints.valueOf(endpoint);
        LocalDateTime currentDate = LocalDateTime.now();

        String deadline = given().spec(requestSpecification())
                .queryParam("type", qParam)
                .cookie("accessTokenCookie", LoginCookies.getAccessToken())
                .get(api.getEndpoint())
                .then().extract().jsonPath()
                .getString("result.deadline");

        LocalDateTime deadlineDateTime = LocalDateTime.parse(deadline, DateTimeFormatter.ISO_DATE_TIME);

        Assert.assertTrue(currentDate.isAfter(deadlineDateTime));
    }

    @When("The members have submitted the {string} and {string} preferences on API {string}")
    public void theMembersHaveSubmittedTheAndPreferencesOnAPI(String qPmLev, String qPmUvWknd, String endpoint) throws IOException {
        AdminEndpoints api = AdminEndpoints.valueOf(endpoint);

        leaveIdLst = given().spec(requestSpecification())
                .cookie("accessTokenCookie", SimpleLogin.login("dipu@qburst.com"))
                .queryParam("type", qPmLev).get(api.getEndpoint())
                .then().extract().jsonPath()
                .getList("result.preferences.id");

        Assert.assertFalse("This array is not null", leaveIdLst.isEmpty());

        uavWknd = given().spec(requestSpecification())
                .cookie("accessTokenCookie", SimpleLogin.login("dipu@qburst.com"))
                .queryParam("type", qPmUvWknd).get(api.getEndpoint())
                .then().extract().jsonPath()
                .getList("result.preferences.id");

        Assert.assertFalse("This array is not null", uavWknd.isEmpty());
    }

    @Then("The admin approves all {string} and {string} preferences on API {string}")
    public void theAdminApprovesFeasibleAndPreferencesOnAPI(String qPmLev, String qPmUvWknd, String endpoint) throws IOException {
        AdminEndpoints api = AdminEndpoints.valueOf(endpoint);

        MonthlyPref.setStatus("approved");
        MonthlyPref.setMonthly_preference_ids(leaveIdLst);
        LMPyd.setMonthlyPreferences(Collections.singletonList(MonthlyPref));

        given().spec(requestSpecification())
                .cookie("accessTokenCookie", LoginCookies.getAccessToken())
                .body(LMPyd)
                .queryParam("type", qPmLev).put(api.getEndpoint());

        MonthlyPref.setMonthly_preference_ids(uavWknd);
        LMPyd.setMonthlyPreferences(Collections.singletonList(MonthlyPref));

        given().spec(requestSpecification())
                .cookie("accessTokenCookie", LoginCookies.getAccessToken())
                .body(LMPyd)
                .queryParam("type", qPmUvWknd).put(api.getEndpoint());
    }

    @Then("The admin reviews and update preferences on API {string}")
    public void theAdminApprovesSelectedAndPreferencesOnAPI(String endpoint, @NotNull DataTable table) throws IOException {

        AdminEndpoints api = AdminEndpoints.valueOf(endpoint);

        List<Map<String, String>> rows = table.asMaps(String.class, String.class);

        for (Map<String, String> columns : rows) {

            MonthlyPref.addMonthlyPreferenceId(Integer.valueOf(columns.get("id")));
            MonthlyPref.setStatus(columns.get("Status"));
            LMPyd.setMonthlyPreferences(Collections.singletonList(MonthlyPref));

            given().spec(requestSpecification())
                    .cookie("accessTokenCookie", //SimpleLogin.login())
                            LoginCookies.getAccessToken())
                    .body(LMPyd)
                    .queryParam("type", columns.get("type")).put(api.getEndpoint());

            String newStatus = given().spec(requestSpecification())
                    .cookie("accessTokenCookie", //SimpleLogin.login())
                            LoginCookies.getAccessToken())
                    .queryParam("type", columns.get("type")).get(api.getEndpoint())
                    .then().extract().body().jsonPath().get("result.preferences.find { it.id ==" + columns.get("id") + "}.status");

            Assert.assertEquals(newStatus, columns.get("Status"));
        }
    }
}
