package com.epam.edp;

import com.epam.edp.util.PropertyReader;
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
        RestAssured.baseURI = PropertyReader.getProperty("keycloak.host.name");
        RestAssured.useRelaxedHTTPSValidation();
        requestSpecification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new RequestLoggingFilter()).build();
    }

    protected static String getAccessToken() {
        String response =
                given()
                        .auth()
                        .preemptive()
                        .basic(PropertyReader.getProperty("keycloak.client_id"), PropertyReader.getProperty("keycloak.client_secret"))
                        .and()
                        .parameters("username", PropertyReader.getProperty("keycloak.username"), "password", PropertyReader.getProperty("keycloak.password"),
                                "grant_type", PropertyReader.getProperty("keycloak.grant_type"))
                        .post("/auth/realms/foobar-realm-sit/protocol/openid-connect/token")
                        .asString();
        JsonPath jsonPath = new JsonPath(response);
        return jsonPath.getString("access_token");
    }

    @AfterClass
    public static void unconfigureRestAssured() {
        RestAssured.reset();
    }
}
