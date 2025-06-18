package com.environment.environmentDataAnalysis.AutomatedTests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class AirQualityAPITest {

    ExtentReports extent;
    ExtentTest test;
    private static Long insertedRecordId;
    @BeforeSuite
    public void setupReport(){
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("ExtentReport.html");
        extent  = new ExtentReports();
        extent.attachReporter(extentSparkReporter);

        RestAssured.baseURI = "http://localhost:8080/api/air-quality";
    }

    @BeforeMethod
    public void init(Method method) {
        test = extent.createTest(method.getName());
    }

    @Test(priority = 1)
    public void testGenerateDummyData(){
        Response res = RestAssured
                .given()
                .pathParam("numberOfRecords", 100)
                .when()
                .post("/GenerateDummyDataAQ/{numberOfRecords}");
        test.info("Generating 100 dummy records for Air Quality data");
        test.info("Response Code: "+res.getStatusCode());
        test.info(res.prettyPrint());

        if (res.getStatusCode() == 200) test.pass("Dummy Data is generated successfully");
        else test.fail("Failed to generate dummy data for Air Quality");
    }

    @Test(priority = 2)
    public void testAddAirQualityData(){
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("location", "Chicago");
        requestBody.put("dateTime", "2025-06-17T10:00:00");
        requestBody.put("pm2_5", 35.4);
        requestBody.put("pm10", 40.1);
        requestBody.put("no2", 18.7);
        requestBody.put("o3", 25.6);

        Response res = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post("/addRecord");

        test.info("Adding a new air quality record");
        test.info("Response Code: "+res.getStatusCode());
        test.info(res.prettyPrint());

        if(res.getStatusCode() == 200) {
            insertedRecordId = res.jsonPath().getLong("id");
            test.pass("Air Quality record added successfully with ID: " + insertedRecordId);
        }
        else test.fail("Failed to add air quality record");
    }

    @Test(priority = 3, dependsOnMethods = "testAddAirQualityData")
    public void testGetAirQualityRecordById(){
        Response res = RestAssured
                .given()
                .get("/id/{id}" + insertedRecordId);
        test.info("Fetching air quality record by ID: " + insertedRecordId);
        test.info("Response Code: "+ res.getStatusCode());
        test.info(res.prettyPrint());
    }

    @Test(priority = 4)
    public void testGetByLocation(){
        Response res = RestAssured
                .given()
                .get("/location/Chicago");

        test.info("Fetching air quality record by location: Chicago");
        test.info("Response Code: "+res.getStatusCode());
        test.info(res.prettyPrint());

        if(res.getStatusCode() == 200) test.pass("Data fetched successfully for location");
        else test.fail("Failed to fetch the requested data for the location: Chicago");
    }

    @Test(priority = 5, dependsOnMethods = "testAddAirQualityData")
    public void testGetAllRecords(){
        Response res = RestAssured.given()
                .when()
                .get("/allRecords");

        test.info("All records fetched successfully");
        test.info("Response Code: " + res.getStatusCode());
        test.info(res.prettyPrint());
    }

    @Test(priority = 6, dependsOnMethods = "testAddAirQualityData")
    public void testUpdateRecords(){
        Map<String, Object> requestBody = Map.of(
                "location", "New York",
                "pm2_5", 30.0,
                "pm10", 35.0,
                "no2", 15.0,
                "o3", 20.0
        );

        Response res = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .put("/"+insertedRecordId);
        test.info("Updating air quality record with ID: "+insertedRecordId);
        test.info("Response Code: "+res.getStatusCode());
        test.info(res.prettyPrint());
    }

    @AfterSuite
    void tearDownReport(){
        extent.flush();
    }
}
