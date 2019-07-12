package com.epam.edp.service.impl;

import com.epam.edp.service.api.CartApi;
import com.epam.edp.util.CartApiUrl;
import com.jayway.restassured.specification.RequestSpecification;

import java.util.Collections;
import java.util.Objects;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.startsWith;

/**
 * @author Roman_Martseniuk
 */
public class CartApiImpl implements CartApi {

    private RequestSpecification requestSpecification;
    private String basePath;

    public CartApiImpl(RequestSpecification requestSpecification) {
        this.requestSpecification = requestSpecification;
        this.basePath = Objects.requireNonNull(System.getProperty("endpoint"),
                "endpoint property should be specified");
    }

    @Override
    public void getServiceStatus() {
        given().spec(requestSpecification)
                .request()
                .get(basePath.concat(CartApiUrl.SERVICE_STATUS))
                .then()
                .assertThat().statusCode(200)
                .and()
                .body(startsWith("OK"));
    }

    @Override
    public void getSendMessage() {
        given().spec(requestSpecification)
                .request()
                .parameters(Collections.singletonMap("msg", "test-message"))
                .get(basePath.concat(CartApiUrl.SEND_MESSAGE))
                .then()
                .assertThat().statusCode(200)
                .and()
                .body(startsWith("Message"));
    }

    @Override
    public void getCallOrderService() {
        given().spec(requestSpecification)
                .request()
                .get(basePath.concat(CartApiUrl.CALL_ORDER_SERVICE))
                .then()
                .assertThat().statusCode(200)
                .and()
                .body(startsWith("Order service returned"));
    }

    @Override
    public void postCarts() {
        given().spec(requestSpecification)
                .request()
                .post(basePath.concat(CartApiUrl.CARTS))
                .then()
                .assertThat().statusCode(200)
                .and()
                .body(startsWith("Cart"));
    }

    @Override
    public void getCartsById() {
        given().spec(requestSpecification)
                .request()
                .pathParam("id", 1001)
                .get(basePath.concat(CartApiUrl.CARTS_BY_ID))
                .then()
                .assertThat().statusCode(500);
    }

}
