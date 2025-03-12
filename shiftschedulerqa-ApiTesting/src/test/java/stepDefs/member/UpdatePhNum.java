package stepDefs.member;

import Utils.CommonEndpoints;
import Utils.LoginCookies;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import pureRest.SimpleLogin;
import stepDefs.BaseTest;

import java.io.IOException;

import static io.restassured.RestAssured.given;
//import static net.serenitybdd.rest.SerenityRest.given;

public class UpdatePhNum extends BaseTest
{
    @Given("User {string} post new phone number to {string}")
    public void userHitsAPIWithNewPhoneNumber(String username, String endpoint) throws IOException {
        //Generate a random 12 digit number for API input
        faker = new Faker();
        num.setPhone_number("+91"+faker.number().digits(10));
        //Send API request to
        CommonEndpoints api = CommonEndpoints.valueOf(endpoint);
        apiResponse = given().spec(requestSpecification())
                .cookie("accessTokenCookie", SimpleLogin.login(username))
                .body(num)
                .patch(api.getEndpoint());
    }

    @Then("Phone number is updated in the {string} for {string}")
    public void phoneNumberIsUpdatedInTheProfile(String endpoint, String username) throws IOException {

        CommonEndpoints api = CommonEndpoints.valueOf(endpoint);
        given().spec(requestSpecification())
                .cookie("accessTokenCookie", SimpleLogin.login(username))
                .get(api.getEndpoint()).then().assertThat()
                .body("result.phone_number", Matchers.equalTo(num.getPhone_number()));
    }
}
