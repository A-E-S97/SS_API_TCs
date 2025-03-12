package stepDefs.member;

import Utils.CommonEndpoints;
import Utils.LoginCookies;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import stepDefs.BaseTest;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Objects;
import static Utils.WriteToFile.writeFile;
import static io.restassured.RestAssured.given;
import static java.time.ZoneOffset.UTC;

public class LoadMonthly extends BaseTest {
    @Given("The user calls {string} with {string} and password")
    public void theUserIsLoggedInWithAndPassword(String endpoint, String username) throws IOException
    {
        CommonEndpoints api = CommonEndpoints.valueOf(endpoint);

        if(!Objects.equals(user.getEmail(), username)) {
            user.setPassword("ShiftScheduler@qburst");
            user.setEmail(username);

            //Retrieving the access token cookie of the user and saving it to a variable
            LoginCookies.setAccessToken(
                    given().spec(requestSpecification()).body(user)
                            .when().post(api.getEndpoint())
                            .getCookie("accessTokenCookie"));
        }
    }

    @And("The user calls the project login endpoint {string}")
    public void projectLoginAPICall(String endpoint) throws IOException {
        CommonEndpoints api = CommonEndpoints.valueOf(endpoint);

        apiResponse = given().spec(requestSpecification())
                .body("{\n" + "  \"project_id\": 1\n" + "}")
                .cookie("accessTokenCookie", LoginCookies.getAccessToken())
                .post(api.getEndpoint());

        LoginCookies.setAccessToken(apiResponse.getCookie("accessTokenCookie"));
    }

    @When("The {string} API is is called")
    public void theAPIIsIsCalled(String endpoint) throws IOException {
        //Getting the response of the monthly API
        CommonEndpoints api = CommonEndpoints.valueOf(endpoint);

        apiResponse = given().spec(requestSpecification())
                .cookie("accessTokenCookie", LoginCookies.getAccessToken())
                .get(api.getEndpoint());
    }

    @Then("Log {string} if the API response code is not {int}")
    public void logTheUsernameIfTheAPIResponseCodeIsNot(String username, int statusCode) throws IOException {

        if (apiResponse.getStatusCode() != statusCode) {
            String userProfile = given().spec(requestSpecification())
                    .cookie("accessTokenCookie", LoginCookies.getAccessToken())
                    .get("user/profile").getBody().asString();
            System.out.println(userProfile);
            String filePath = "ErrorUsers.txt";
            boolean appendToFile = true; // Set to true for appending mode
            writeFile(filePath, userProfile + " - " + "\n", appendToFile);
        }
        apiResponse.then().assertThat().statusCode(200);
    }

    @Then("The {string} API should return status code {int}")
    public void theAPIShouldReturnStatusCode(String endpoint, int statusCode) throws IOException {
        CommonEndpoints api = CommonEndpoints.valueOf(endpoint);
        given().spec(requestSpecification())
                .cookie("accessTokenCookie", LoginCookies.getAccessToken())
                .get(api.getEndpoint())
                .then().statusCode(statusCode);
    }
    @Then("The {string} should return status code {int}")
    public void theShiftTodayViewShouldReturnStatusCode(String endpoint, int statusCode) throws IOException {
        CommonEndpoints api = CommonEndpoints.valueOf(endpoint);
        given().spec(requestSpecification())
                .cookie("accessTokenCookie", LoginCookies.getAccessToken())
                .queryParam("date", String.valueOf(LocalDate.now(UTC)))
                .get(api.getEndpoint())
                .then().statusCode(statusCode);
    }
}
