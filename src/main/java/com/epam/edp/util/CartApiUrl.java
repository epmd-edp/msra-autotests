package com.epam.edp.util;

/**
 * @author Roman_Martseniuk
 */
public class CartApiUrl {

    public static final String BASE_CART_SERVICE_PATH = "/cart-service/cart-service";

    public static final String SERVICE_STATUS = BASE_CART_SERVICE_PATH + "/service-status";
    public static final String SEND_MESSAGE = BASE_CART_SERVICE_PATH + "/send-message";
    public static final String CALL_ORDER_SERVICE = BASE_CART_SERVICE_PATH + "/call-order-service";
    public static final String CARTS = BASE_CART_SERVICE_PATH + "/carts";
    public static final String CARTS_BY_ID = BASE_CART_SERVICE_PATH + "/carts/{id}";

    private CartApiUrl() {
        //NOT IMPL
    }
}
