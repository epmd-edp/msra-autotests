package com.epam.edp;

import com.epam.edp.steps.CartServiceSteps;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author Roman_Martseniuk
 */
public class CartTest extends BaseTest {

    private CartServiceSteps cartServiceSteps;

    @BeforeMethod
    public void init() {
        cartServiceSteps = new CartServiceSteps(requestSpecification);
    }

    @Test
    public void testGetServiceStatus() {
        cartServiceSteps.shouldGetServiceStatus();
    }

    @Test
    public void testGetSendMessage() {
        cartServiceSteps.shouldGetSendMessage();
    }

    @Test
    public void testGetCallOrderService() {
        cartServiceSteps.shouldGetCallOrderService();
    }

    @Test
    public void testPostCarts() {
        cartServiceSteps.shouldPostCarts();
    }

    @Test
    public void testGetCartByID() {
        cartServiceSteps.shouldGetCartsById();
    }

}
