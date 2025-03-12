package stepDefs.admin;

import Utils.AdminEndpoints;
import Utils.CommonEndpoints;
import Utils.LoginCookies;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import stepDefs.BaseTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class EditMemberDetails extends BaseTest {

    List<String> leave = new ArrayList<>();
    List<String> preff = new ArrayList<>();
    XSSFSheet MembersDetailsSheet;
    @Given("The admin calls {string} with username and password")
    public void theAdminCallsWithUsernameAndPassword(String endpoint, @NotNull DataTable table) throws IOException {
        List<Map<String, String>> tableData = table.asMaps(String.class, String.class);
        for (Map<String, String> row : tableData)
        {
        user.setEmail(row.get("username"));
        user.setPassword(row.get("password"));
        }

        CommonEndpoints api = CommonEndpoints.valueOf(endpoint);
        LoginCookies.setAccessToken(given().spec(requestSpecification())
                .body(user).post(api.getEndpoint()).getCookie("accessTokenCookie"));
    }

    @When("The admin sends a put request to {string} API with id and new role")
    public void theAdminSendsAPutRequestToAPIWithAndNew(String endpoint , @NotNull DataTable table) throws IOException {
        AdminEndpoints api = AdminEndpoints.valueOf(endpoint);
        //int Uid =  Integer.valueOf(id);

        apiResponse = given().spec(requestSpecification())
                .cookie("accessTokenCookie", LoginCookies.getAccessToken())
                .get(api.getEndpoint());

        JsonPath jp = apiResponse.then().extract().body().jsonPath();


        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        for (Map<String, String> columns : rows) {

            String idValue = columns.get("id");

            memberDetails.setDesignation(columns.get("role"));

            memberDetails.setId(Integer.parseInt(idValue));

            memberDetails.setName(jp.getString("result.find { it.id == "+idValue+" }.name"));

            memberDetails.setCode(jp.getString("result.find { it.id == "+idValue+" }.code"));

            memberDetails.setTier_code(jp.getString("result.find { it.id == "+idValue+" }.tier_code"));

            memberDetails.setLocation(jp.getString("result.find { it.id == "+idValue+" }.location"));

            memberDetails.setRole_id(jp.getInt("result.find { it.id == "+idValue+" }.role_id"));

            memberDetails.setGeneral_leave_preferences(leave);

            memberDetails.setGeneral_shift_preferences(preff);
            System.out.println("Test :"+memberDetails.toString());

            given().spec(requestSpecification()).body(memberDetails)
                    .cookie("accessTokenCookie", LoginCookies.getAccessToken())
                    .put(api.getEndpoint());
        }
    }

//    @Then("The role should be updated in the profile {string}.")
//    public void theRoleShouldBeUpdatedInTheProfile(String id)
//    {
//
//        String newDesignation = apiResponse.then().extract().body().jsonPath().get("result.find { it.id =="+id+"}.role_id");
//        Assert.assertTrue(newDesignation, equals(memberDetails.getDesignation()));
//    }
}
