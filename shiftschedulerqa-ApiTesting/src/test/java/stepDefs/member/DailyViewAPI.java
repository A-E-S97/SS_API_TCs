package stepDefs.member;

import Utils.CommonEndpoints;
import Utils.LoginCookies;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;
import stepDefs.BaseTest;
import java.io.IOException;
import static io.restassured.RestAssured.given;

public class DailyViewAPI extends BaseTest
{
    @When("The user calls the {string} for {string}")
    public void theUserCallsDailyViewAPI(String endpoint, String date) throws IOException {
        CommonEndpoints api = CommonEndpoints.valueOf(endpoint);

        apiResponse = (Response) given().spec(requestSpecification())
                .cookies("accessTokenCookie", LoginCookies.getAccessToken())
                .queryParam("date", date)
                .get(api.getEndpoint()).getBody();

//        System.out.println(apiResponse.asString());
    }

    @Then("The shifts are not repeated")
    public void theShiftsAreNotRepeated()
    {
//        List<Integer> shiftIds = new ArrayList<>();
        List<Integer> shiftsOfTheDay = apiResponse.then().extract().jsonPath().getList("result.shifts.shift_id");

        HashSet<Object> uqShiftsOfToday = new HashSet<>();
        uqShiftsOfToday = new HashSet<>(shiftsOfTheDay);
//        System.out.println("norm =" + shiftsOfTheDay);
//        System.out.println("hash =" + uqShiftsOfToday);

        Assert.assertEquals("HashSet sizes are not equal", shiftsOfTheDay.size(), uqShiftsOfToday.size());

    }

    @And("Employees are not duplicated")
    public void allEmployeesAreAllocated()
    {
        List<List<Integer>> allEmployees = apiResponse.then().extract().jsonPath().getList("result.shifts.employees");

        List<Integer> flatList = new ArrayList<>();

        for (List<Integer> innerList : allEmployees) {
            flatList.addAll(innerList);
        }

        HashSet<Object> uqEmpsOfToday = new HashSet<>();
        uqEmpsOfToday = new HashSet<>(allEmployees);

        Assert.assertEquals("HashSet sizes are not equal", allEmployees.size(), uqEmpsOfToday.size());

    }
}
