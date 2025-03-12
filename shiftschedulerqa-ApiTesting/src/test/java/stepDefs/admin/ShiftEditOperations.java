package stepDefs.admin;

import Utils.AdminEndpoints;
import Utils.CommonEndpoints;
import Utils.LoginCookies;
import io.cucumber.java.en.Then;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import pojo.adminPayloads.RoleConstrains;
import stepDefs.BaseTest;
import java.io.FileInputStream;
import java.io.IOException;

import static io.restassured.RestAssured.given;

public class ShiftEditOperations extends BaseTest {
    XSSFSheet shiftsDetailsSheet, roleConstrainsSheet;

    @Then("The admin posts the parameters and constrains for the new shift to API {string}")
    public void theAdminPostsTheParametersAndConstrainsForTheNewShift(String endpoint) throws IOException {

        FileInputStream fis = new FileInputStream("src/test/resources/API Data.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        System.out.println("Step 2 started");

        int sheets = workbook.getNumberOfSheets();
        for (int i = 0; i < sheets; i++) {
            if (workbook.getSheetName(i).equalsIgnoreCase("shiftsDetails"))
            {shiftsDetailsSheet = workbook.getSheetAt(i);}
            if (workbook.getSheetName(i).equalsIgnoreCase("Shift Role Constraints"))
            {roleConstrainsSheet = workbook.getSheetAt(i);}
            System.out.println("getting sheets");
        }
        assert shiftsDetailsSheet != null;
        int iRowCount = shiftsDetailsSheet.getLastRowNum();
        int jRowCount = roleConstrainsSheet.getLastRowNum();
//        System.out.println("preparing payload");
//        System.out.println(iRowCount);
        for (int i =1; i <= iRowCount; i++)
        {
            System.out.println("iRowCount = " + i);
            Row shiftDetailsRow = shiftsDetailsSheet.getRow(i);
            //System.out.println(shiftDetailsRow.getCell(0));
            shiftPayload.setName(String.valueOf(shiftDetailsRow.getCell(1)));
            shiftPayload.setCode(String.valueOf(shiftDetailsRow.getCell(2)));
            shiftPayload.setColour(String.valueOf(shiftDetailsRow.getCell(3)));
            shiftPayload.setStart_time(String.valueOf(shiftDetailsRow.getCell(4)));
            shiftPayload.setEnd_time(String.valueOf(shiftDetailsRow.getCell(5)));
            shiftPayload.setShift_days(String.valueOf(shiftDetailsRow.getCell(6)));
            //shiftPayload.setDescription(String.valueOf(shiftDetailsRow.getCell(7)));
            shiftPayload.newShift_role_constraints();
            System.out.println("adding constrains");
            for (int j =1; j < jRowCount; j++)
            {
                Row roleConstrainsRow = roleConstrainsSheet.getRow(j);
                if(String.valueOf(roleConstrainsRow.getCell(0)) == shiftPayload.getCode()){
                    RoleConstrains roleConstrains = new RoleConstrains();
                    int id = Integer.parseInt(String.valueOf(roleConstrainsRow.getCell(1)));
                    int mx = (int) roleConstrainsRow.getCell(2).getNumericCellValue();
                    int mn = (int) roleConstrainsRow.getCell(3).getNumericCellValue();
                    roleConstrains.setRoleConstrains(id, mx, mn);
                    shiftPayload.addShift_role_constraints(roleConstrains);
                }
            }
            System.out.println(shiftPayload.toString());

            AdminEndpoints api = AdminEndpoints.valueOf(endpoint);
//            //String code1 = shiftPayload.getCode();
//            //if(code1 == "LS"){
//                System.out.println("posting shift");
                given().spec(requestSpecification())
                    .cookie("accessTokenCookie", LoginCookies.getAccessToken())
                    .body(shiftPayload.toString()).post(api.getEndpoint());//}
        }
        System.out.println("Step 2 ended");
    }
}