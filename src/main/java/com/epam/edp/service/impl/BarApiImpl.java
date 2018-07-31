package com.epam.edp.service.impl;

import com.epam.edp.service.api.BarApi;
import com.epam.edp.util.BarApiUrl;
import com.epam.edp.util.PropertyReader;
import com.jayway.restassured.specification.RequestSpecification;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.startsWith;

/**
 * @author Roman_Martseniuk
 */
public class BarApiImpl implements BarApi {

    private RequestSpecification requestSpecification;
    private String token;
    private String basePath;

    public BarApiImpl(RequestSpecification requestSpecification, String token) {
        this.requestSpecification = requestSpecification;
        this.token = token;
        this.basePath = PropertyReader.getProperty("host.name");
    }

    public void getSetting() {
        given().spec(requestSpecification)
                .auth().preemptive().oauth2(token)
                .request()
                    .get(basePath.concat(BarApiUrl.GET_SETTING))
                .then()
                    .assertThat().statusCode(200)
                .and()
                    .body(startsWith("Hello World!"));
    }
}