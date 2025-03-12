package stepDefs.member;

import Utils.CommonEndpoints;
import Utils.LoginCookies;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import stepDefs.BaseTest;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class WeeklyPreferences extends BaseTest
{

    @When("User add the following days {string} to {string} with {int}")
    public void user_add_the_following_days_to_with(String daysString, String endpoint, Integer id) throws IOException {
        CommonEndpoints api = CommonEndpoints.valueOf(endpoint);
        String[] days = daysString.split("; ");
        weekOff.setDays(Arrays.asList(days));
        //System.out.println(days.toString());
        weekOff.setId(id);

        given().spec(requestSpecification())
                .cookie("accessTokenCookie", LoginCookies.getAccessToken())
                .body(weekOff).put(api.getEndpoint())
                .then().assertThat().statusCode(200);
    }

    @Then("The preferences are posted to {string}")
    public void the_preferences_are_posted_to(String endpoint) throws IOException {

        CommonEndpoints api = CommonEndpoints.valueOf(endpoint);

        given().spec(requestSpecification())
                .cookie("accessTokenCookie", LoginCookies.getAccessToken())
                .get(api.getEndpoint())
                .then().assertThat().body("result.days", equalTo(weekOff.getDays()));
                //.extract().body().jsonPath().getList("result.days")
    }

    @And("The the {string} {string} is active")
    public void theTheIsActive(String qryParam, String endpoint) throws IOException
    {
        CommonEndpoints api = CommonEndpoints.valueOf(endpoint);

        LocalDate deadline = given().spec(requestSpecification())
                .cookie("accessTokenCookie", LoginCookies.getAccessToken())
                .queryParam("type", qryParam).get(api.getEndpoint())
                .body().jsonPath().get("jsonPathToDeadline");
        //Need deadline response structure and parameter names
        Assert.assertTrue(deadline.isAfter(LocalDate.now()));
    }

    @When("The user posts the shift preferences at {string} API")
    public void theUserPostsTheShiftPreferencesAtAPI(String endpoint) throws IOException {
        //Need Excel file integration
        CommonEndpoints api = CommonEndpoints.valueOf(endpoint);

        given().spec(requestSpecification())
                .cookie("accessTokenCookie", LoginCookies.getAccessToken())
                .body("ExcelFile").put(endpoint);
    }

    @Then("The preferences are posted to {string} API")
    public void thePreferencesArePostedToAPI(String endpoint) throws IOException {
        CommonEndpoints api = CommonEndpoints.valueOf(endpoint);

        given().spec(requestSpecification())
                .cookie("accessTokenCookie", LoginCookies.getAccessToken())
                .get(endpoint)//Assertion to verify that the data is posted
        ;
    }

    @When("User add the following days to {string} with id")
    public void userAddTheFollowingDaysToWithId(String endpoint) throws IOException {

        CommonEndpoints api = CommonEndpoints.valueOf(endpoint);
        String days[] = {"Any day", "Wednesday"};
        weekOff.setDays(Arrays.asList(days));

        weekOff.setId(given().spec(requestSpecification())
                .cookie("accessTokenCookie", LoginCookies.getAccessToken())
                .get(api.getEndpoint()).then().statusCode(200)
                .extract().body().jsonPath().getInt("result.id"));

        given().spec(requestSpecification())
                .cookie("accessTokenCookie", LoginCookies.getAccessToken())
                .body(weekOff)
                .put(api.getEndpoint()).then().statusCode(200);
    }
}
