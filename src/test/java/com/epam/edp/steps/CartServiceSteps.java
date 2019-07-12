package com.epam.edp.steps;

import com.epam.edp.service.api.CartApi;
import com.epam.edp.service.impl.CartApiImpl;
import com.jayway.restassured.specification.RequestSpecification;

/**
 * @author Roman_Martseniuk
 */
public class CartServiceSteps {

    private CartApi cartApi;

    public CartServiceSteps(RequestSpecification requestSpecification) {
        this.cartApi = new CartApiImpl(requestSpecification);
    }

    public void shouldGetServiceStatus() {
        cartApi.getServiceStatus();
    }

    public void shouldGetSendMessage() {
        cartApi.getSendMessage();
    }

    public void shouldGetCallOrderService() {
        cartApi.getCallOrderService();
    }

    public void shouldPostCarts() {
        cartApi.postCarts();
    }

    public void shouldGetCartsById() {
        cartApi.getCartsById();
    }
}
