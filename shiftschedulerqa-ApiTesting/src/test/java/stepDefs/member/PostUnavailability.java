package stepDefs.member;

import Utils.CommonEndpoints;
import Utils.LoginCookies;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import stepDefs.BaseTest;
import io.cucumber.datatable.DataTable;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;
import static org.hamcrest.CoreMatchers.*;


public class PostUnavailability extends BaseTest
{
    //int maxId = 0;

    @Given("User {string} have a {string} allotted on the {string}")
    public void userHasAShiftAllottedOnTheDay(String user, String endpoint,String date) throws IOException {
        CommonEndpoints api = CommonEndpoints.valueOf(endpoint);

        uva.setDate(date);

        apiResponse = given().spec(requestSpecification())
                .queryParam("date", uva.getDate())
                .cookie("accessTokenCookie", LoginCookies.getAccessToken()).get(api.getEndpoint());

//        System.out.println(Optional.ofNullable(apiResponse.body().jsonPath().get("result.shifts")));
        Object shiftArray = apiResponse.body().jsonPath().get("result.shifts");
        Assert.assertFalse(shiftArray == null);
        uva.setShift_id(apiResponse.body().jsonPath().get("result.shifts.shift_id[0]"));
        uva.setCurrent_shift_id(apiResponse.body().jsonPath().get("result.shifts.current_shift_id[0]"));
    }

    @When("User hasn't already posted an {string} for the same {string}")
    public void theUserHasntAlreadyPostedAnForTheSameDay(String endpoint, String date) throws IOException {
        CommonEndpoints api = CommonEndpoints.valueOf(endpoint);

        apiResponse = given().spec(requestSpecification())
                .cookie("accessTokenCookie", LoginCookies.getAccessToken())
                .get(api.getEndpoint());

        if (apiResponse.getStatusCode() == 200)
        {
            String resp = apiResponse.asString();
            JsonPath jP = new JsonPath(resp);
            String dateToCheck = date + "T00:00:00Z";
            boolean isDatePresent = jP.getList("result.history.date").contains(dateToCheck);
            org.junit.jupiter.api.Assertions.assertFalse(isDatePresent, "The date is not present in the JSON response.");
        }
    }

    @Then("User posts {string} with date and {string}")
    public void userSendsDateAndReason(String endpoint, String reason) throws IOException {
        CommonEndpoints api = CommonEndpoints.valueOf(endpoint);
        uva.setReason(reason);

        apiResponse = given().spec(requestSpecification()).body(uva)
                .cookie("accessTokenCookie", LoginCookies.getAccessToken())
                .post(api.getEndpoint());
    }

    @And("{string} should be posted in the API {string}")
    public void informationIsPosted(String date, String endpoint) throws IOException {
        CommonEndpoints api = CommonEndpoints.valueOf(endpoint);

        given().spec(requestSpecification())
                .cookie("accessTokenCookie", LoginCookies.getAccessToken())
                .get(api.getEndpoint())
                .then().assertThat().body("result.history.date", hasItem(date + "T00:00:00Z"));
    }

    @Then("User posts {string} with date and reason if user has a shift {string} allotted")
    public void userPostsWithDateAndIfUserHasAShiftAllotted(String endpoint1, String endpoint2, @NotNull DataTable table) throws IOException {
        CommonEndpoints api = CommonEndpoints.valueOf(endpoint2);
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);

        for (Map<String, String> columns : rows)
        {
            uva.setDate(columns.get("date"));
            uva.setReason(columns.get("reason"));

            apiResponse = given().spec(requestSpecification())
                    .queryParam("date", uva.getDate())
                    .cookie("accessTokenCookie", LoginCookies.getAccessToken()).get(api.getEndpoint());

            Object shiftArray = apiResponse.body().jsonPath().get("result.shifts");
            if(shiftArray == null)
            {
                uva.setShift_id(apiResponse.body().jsonPath().get("result.shifts.shift_id[0]"));
                uva.setCurrent_shift_id(apiResponse.body().jsonPath().get("result.shifts.current_shift_id[0]"));

                CommonEndpoints api1 = CommonEndpoints.valueOf(endpoint1);

                given().spec(requestSpecification()).body(uva)
                        .cookie("accessTokenCookie", LoginCookies.getAccessToken())
                        .post(api1.getEndpoint()).then().statusCode(200);
            }
            else
            {
                System.out.println(columns.get("date") + " is not allotted for ");
            }
        }
    }
}
