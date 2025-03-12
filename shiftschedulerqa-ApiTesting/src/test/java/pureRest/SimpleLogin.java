package pureRest;

import Utils.AdminEndpoints;
import Utils.CommonEndpoints;
import Utils.LoginCookies;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;
import pojo.UnavailabilityPayload;
import Utils.RequestBuilder;
import stepDefs.BaseTest;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;

public class SimpleLogin extends BaseTest
{
    public static String baseURL = "http://13.232.205.16/api/v1";

    public static String loginURL = baseURL + "/user/login";
    public static String uva = baseURL + "/user/shifts";

    String user = "dipu@qburst.com";
    String pwd = "ShiftScheduler@qburst";

    static String cook;

    List<Object> leaveIdLst;


    public static String login(String username)
    {
        Response loginResp = given()
                .contentType(ContentType.JSON).accept(ContentType.JSON)
                .body("{\"email\": \""+ username + "\", \"password\": \"ShiftScheduler@qburst\"}").when().post(loginURL);

        cook = loginResp.getCookie("accessTokenCookie");
//
//        String result = loginResp.body().jsonPath().get("result");
//        System.out.println(result);
        return cook;
    }

    @Test
            public void uva() {
        Response uvRes = (Response) given().
                contentType(ContentType.JSON).accept(ContentType.JSON)
                .cookie("accessTokenCookie", login("dan@qburst.com"))
                .queryParam("date", "2023-07-28").log().all().get(uva).then().log().all();
    }

    @Test

    public void survey() throws IOException
    {
        String endpoint = "deadline";
        CommonEndpoints api = CommonEndpoints.valueOf(endpoint);
        LocalDateTime currentDate = LocalDateTime.now();
        System.out.println(currentDate);

        LocalDateTime deadlineDateTime = LocalDateTime.parse(
                given().spec(requestSpecification())
                        .queryParam("type", "monthly_preference")
                        .cookie("accessTokenCookie", login(""))
                        .get(api.getEndpoint())
                        .then().extract().jsonPath()
                        .getString("result.deadline"), DateTimeFormatter.ISO_DATE_TIME);
        System.out.println(deadlineDateTime);
        Assert.assertTrue(currentDate.isAfter(deadlineDateTime));
    }

    @Test
    public void leaveList() throws IOException
    {
        String endpoint = "leaveReq";
        AdminEndpoints api = AdminEndpoints.valueOf(endpoint);
        String qPmLev = "leave";

        leaveIdLst = given().spec(requestSpecification())
                .cookie("accessTokenCookie", login("dan@qburst.com"))
                .queryParam("type", qPmLev).get(api.getEndpoint())
                .then().extract().jsonPath()
                .getList("result.preferences.id");

        System.out.println(leaveIdLst.toString());

    }
}
