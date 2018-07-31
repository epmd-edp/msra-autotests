package com.epam.edp.service.impl;

import com.epam.edp.service.api.FooApi;
import com.epam.edp.util.FooApiUrl;
import com.epam.edp.util.PropertyReader;
import com.jayway.restassured.specification.RequestSpecification;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.startsWith;

/**
 * @author Roman_Martseniuk
 */
public class FooApiImpl implements FooApi {

    private RequestSpecification requestSpecification;
    private String token;
    private String basePath;

    public FooApiImpl(RequestSpecification requestSpecification, String token) {
        this.requestSpecification = requestSpecification;
        this.token = token;
        this.basePath = PropertyReader.getProperty("host.name");
    }

    public void getDefaultConfig() {
        given().spec(requestSpecification)
                .auth().preemptive().oauth2(token)
                .request()
                    .get(basePath.concat(FooApiUrl.DEFAULT_CONFIG))
                .then()
                    .assertThat().statusCode(200)
                .and()
                    .body(startsWith("config:foo.config.default, src:application.yml"));
    }

    public void getProfileConfig() {
        given().spec(requestSpecification)
                .auth().preemptive().oauth2(token)
                .request()
                    .get(basePath.concat(FooApiUrl.PROFILE_CONFIG))
                .then()
                    .assertThat().statusCode(200)
                .and()
                    .body(startsWith("config:foo.config.profile, src:application-prod.yml"));;
    }

    public void getMountConfig() {
        given().spec(requestSpecification)
                .auth().preemptive().oauth2(token)
                .request()
                    .get(basePath.concat(FooApiUrl.MOUNT_CONFIG))
                .then()
                    .assertThat().statusCode(200)
                .and()
                    .body(startsWith("config:foo.config.mount, src:foo-mount"));
    }

    public void getReloadConfig() {
        given().spec(requestSpecification)
                .auth().preemptive().oauth2(token)
                .request()
                    .get(basePath.concat(FooApiUrl.RELOAD_CONFIG))
                .then()
                    .assertThat().statusCode(200)
                .and()
                    .body(startsWith("config:foo.config.reload, src:foo-reload"));
    }

    public void getDynamicConfig() {
        given().spec(requestSpecification)
                .auth().preemptive().oauth2(token)
                .request()
                    .get(basePath.concat(FooApiUrl.DYNAMIC_CONFIG))
                .then()
                    .assertThat().statusCode(200)
                .and()
                    .body(startsWith("config:foo.config.dynamic,src:foo-dynamic"));
    }

    public void getSecretConfig() {
        given().spec(requestSpecification)
                .auth().preemptive().oauth2(token)
                .request()
                    .get(basePath.concat(FooApiUrl.SECRET_CONFIG))
                .then()
                    .assertThat().statusCode(200)
                .and()
                    .body(startsWith("config:foo.config.secret, src:foo-secret"));
    }

    public void callDumbClient() {
        given().spec(requestSpecification)
                .auth().preemptive().oauth2(token)
                .request()
                    .get(basePath.concat(FooApiUrl.CALL_DUMB_CLIENT))
                .then()
                    .assertThat().statusCode(200)
                .and()
                    .body(startsWith("Angie"));
    }

    public void callFeignClient() {
        given().spec(requestSpecification)
                .auth().preemptive().oauth2(token)
                .request()
                    .get(basePath.concat(FooApiUrl.CALL_FEIGN_CLIENT))
                .then()
                    .assertThat().statusCode(200)
                .and()
                    .body(startsWith("Angie"));
    }

    public void postMessage(String setting) {
        given().spec(requestSpecification)
                .auth().preemptive().oauth2(token)
                .request()
                    .get(basePath.concat(FooApiUrl.POST_MESSAGE).concat(setting))
                .then()
                    .assertThat().statusCode(200);
    }
}
