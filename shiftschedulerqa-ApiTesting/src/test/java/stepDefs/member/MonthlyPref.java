package stepDefs.member;

import Utils.CommonEndpoints;
import Utils.LoginCookies;
import com.fasterxml.jackson.databind.JsonNode;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import stepDefs.BaseTest;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static io.restassured.RestAssured.given;
//import static net.serenitybdd.rest.SerenityRest.given;
import static org.hamcrest.CoreMatchers.hasItem;

public class MonthlyPref extends BaseTest {

        int preferenceId;

        @Given("User's leave {string} is according to {string}")
        public void userSLeaveDatesAccordingToDeadline(String dateStr, String endpoint) throws IOException
        {
                CommonEndpoints api = CommonEndpoints.valueOf(endpoint);
                LocalDateTime leaveDateTime = LocalDateTime.parse(dateStr, DateTimeFormatter.ISO_DATE_TIME);;
                LocalDate leaveDate = leaveDateTime.toLocalDate();
                leaveData.setDates(dateStr);
                LocalDate currentDate = LocalDate.now();

                apiResponse = given().spec(requestSpecification())
                        .cookie("accessTokenCookie", LoginCookies.getAccessToken())
                        .queryParam("type", "monthly_preference").get(api.getEndpoint());

                LocalDateTime deadlineDateTime = LocalDateTime.parse(apiResponse.then().extract().jsonPath().getString("result.deadline"), DateTimeFormatter.ISO_DATE_TIME);
                LocalDate deadline = deadlineDateTime.toLocalDate();
                LocalDateTime schedule_ending_dateTime = LocalDateTime.parse(apiResponse.then().extract().jsonPath().getString("result.schedule_ending_date"), DateTimeFormatter.ISO_DATE_TIME);
                LocalDate schedule_ending_date = schedule_ending_dateTime.toLocalDate();

                Assert.assertTrue(deadline.isAfter(currentDate));
                Assert.assertTrue(leaveDate.isBefore(schedule_ending_date));
        }


        @Then("The {string} are submitted")
        public void theLeavePreferencesAreSubmitted(String endpoint) throws IOException {
                CommonEndpoints api = CommonEndpoints.valueOf(endpoint);
                given().spec(requestSpecification()).queryParam("type", leaveData.getType())
                        .cookie("accessTokenCookie", LoginCookies.getAccessToken())
                        .get(api.getEndpoint()).then().assertThat().body("result.preferences.reason", hasItem(leaveData.getReason()));
        }


        @When("The {string} dates are send with {string} to {string}")
        public void thePreferencesAreSendWith(String type, String reason, String endpoint) throws IOException
        {
                leaveData.setType(type);
                leaveData.setReason(reason);
                CommonEndpoints api = CommonEndpoints.valueOf(endpoint);

                given().spec(requestSpecification())
                        .cookie("accessTokenCookie", LoginCookies.getAccessToken()).body(leaveData)
                        .post(api.getEndpoint());
        }

        @Given("User has posted a {string} on given {string} at {string}")
        public void userHasPostedOn(String qryParam, String date, String endpoint) throws IOException
        {
                CommonEndpoints api = CommonEndpoints.valueOf(endpoint);

                JsonNode preferences = given().spec(requestSpecification())
                        .cookie("accessTokenCookie", LoginCookies.getAccessToken())
                        .queryParam("type", qryParam).get(api.getEndpoint())
                        .then().extract().body().jsonPath().get("result.preferences");

                for (JsonNode preference : preferences)
                {
                        String dateFromJson = preference.path("dates").get(0).asText();
                        if (dateFromJson.equals(date))
                        {
                                int preferenceId = preference.path("id").asInt();
                                break;
                        }
                }
                Assert.assertNotNull(preferenceId);
        }

        @When("User send a delete request to {string}")
        public void userDeletesThePreferenceOn(String endpoint) throws IOException {
                CommonEndpoints api = CommonEndpoints.valueOf(endpoint);

                given().spec(requestSpecification())
                        .cookie("accessTokenCookie", LoginCookies.getAccessToken())
                        .queryParam("id", preferenceId).delete(api.getEndpoint());
        }

        @Then("The {string} is deleted from {string}")
        public void theIsDeletedFrom(String qryParam, String endpoint) throws IOException
        {
                CommonEndpoints api = CommonEndpoints.valueOf(endpoint);

                int[] ids = given().spec(requestSpecification())
                        .cookie("accessTokenCookie", LoginCookies.getAccessToken())
                        .queryParam("type", qryParam).get(api.getEndpoint())
                        .then().extract().body().jsonPath().get("result.preferences.id");

                Assertions.assertThat(ids).doesNotContain(preferenceId);
        }
}
