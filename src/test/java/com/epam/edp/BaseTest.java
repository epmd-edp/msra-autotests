package com.epam.edp;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.filter.log.RequestLoggingFilter;
import com.jayway.restassured.filter.log.ResponseLoggingFilter;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static com.jayway.restassured.RestAssured.given;

/**
 * @author Roman_Martseniuk
 */
public class BaseTest {

    protected static RequestSpecification requestSpecification;

    @BeforeClass
    public static void configureRestAssured() {
        RestAssured.useRelaxedHTTPSValidation();
        requestSpecification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new RequestLoggingFilter()).build();
    }

    @AfterClass
    public static void unconfigureRestAssured() {
        RestAssured.reset();
    }
}
