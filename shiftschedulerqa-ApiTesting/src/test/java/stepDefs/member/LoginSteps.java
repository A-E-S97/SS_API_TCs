package stepDefs.member;

import Utils.CommonEndpoints;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import net.serenitybdd.rest.SerenityRest;
import Utils.LoginCookies;

import static io.restassured.RestAssured.given;
//import static net.serenitybdd.rest.SerenityRest.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import io.cucumber.datatable.DataTable;
//import net.thucydides.core.model.DataTable;
import org.jetbrains.annotations.NotNull;
import stepDefs.BaseTest;

import java.io.IOException;
import java.util.List;
import java.util.Map;


public class LoginSteps extends BaseTest {

    @Given("I send a request to endpoint {string} with username {string} and password")
    public void sendRequest(String endpoint, String email) throws IOException {
        //List<Map<String, String>> tableData = table.asMaps(String.class, String.class);
        //for (Map<String, String> row : tableData) {
            user.setEmail(email);
            user.setPassword("ShiftScheduler@qburst");
        //}
        CommonEndpoints api = CommonEndpoints.valueOf(endpoint);
        apiResponse = given().spec(requestSpecification()).body(user).when().post(api.getEndpoint());
    }

    @Then("The API's return status is {int}")
    public void verifyResponseStatus(int status) {
        apiResponse.then().statusCode(status);
        //SerenityRest.restAssuredThat(apiResponse -> apiResponse.statusCode(status));
        //System.out.println(apiResponse.asString());
    }

    @And("Access token cookie is not null")
    public void verifyResponseCookie() {

        String accessCookie = apiResponse.getCookie("accessTokenCookie");
        assertNotNull(accessCookie);
        LoginCookies.setAccessToken(accessCookie);
        String refreshCookie = apiResponse.getCookie("refreshTokenCookie");
        LoginCookies.setRefreshToken(refreshCookie);
        //SerenityRest.restAssuredThat(response -> response.body("result", equalTo(responseResult)));
        }

    @And("Response should contains result {string}")
    public void responseShouldContainsResult(String ExpectedResult)
    {
//        SerenityRest.restAssuredThat(response -> response.body("result", equalTo(ExpectedResult)));
        apiResponse.then().assertThat().body("result", equalTo(ExpectedResult));
    }

}
