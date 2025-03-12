package Utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class RequestBuilder {
    protected static RequestSpecification reqSpec;

    public RequestSpecification requestSpecification() throws IOException
    {

        if (reqSpec == null) {

            Path file = Paths.get("APITestLogs/DailyView" + GetSystemDate.dateTime() + ".txt");
            PrintStream log = new PrintStream(Files.newOutputStream(file));
            RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
            requestSpecBuilder.setBaseUri(getBaseUrl("Staging"));
            requestSpecBuilder.addFilter(RequestLoggingFilter.logRequestTo(log));
            requestSpecBuilder.addFilter(ResponseLoggingFilter.logResponseTo(log));
            requestSpecBuilder.setContentType(ContentType.JSON);
            requestSpecBuilder.setAccept(ContentType.JSON);
            reqSpec = requestSpecBuilder.build();
            return reqSpec;
        }
        return reqSpec;
    }

    public static String getBaseUrl(String key) throws IOException {
        Properties prop = new Properties();
        FileInputStream urlFile = new FileInputStream("src/test/resources/ShiftScheduler.properties");
        prop.load(urlFile);
        prop.getProperty(key);
        return prop.getProperty(key);
    }
}
