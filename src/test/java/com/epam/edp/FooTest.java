package com.epam.edp;

import com.epam.edp.steps.FooServiceSteps;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author Roman_Martseniuk
 */
public class FooTest extends BaseTest {

    private FooServiceSteps fooServiceSteps;

    @BeforeMethod
    public void init() {
        String token = getAccessToken();
        fooServiceSteps = new FooServiceSteps(requestSpecification, token);
    }

    @Test
    public void testGetDefaultConfig() {
        fooServiceSteps.shouldGetDefaultConfig();
    }

    @Test
    public void testGetProfileConfig() {
        fooServiceSteps.shouldGetProfileConfig();
    }

    @Test
    public void testGetMountConfig() {
        fooServiceSteps.shouldGetMountConfig();
    }

    @Test
    public void testGetReloadConfig() {
        fooServiceSteps.shouldGetReloadConfig();
    }

    @Test
    public void testGetDynamicConfig() {
        fooServiceSteps.shouldGetDynamicConfig();
    }

    @Test
    public void testGetSecretConfig() {
        fooServiceSteps.shouldGetSecretConfig();
    }

    @Test
    public void testCallDumbClient() {
        fooServiceSteps.shouldCallDumbClient();
    }

    @Test
    public void testCallFeignClient() {
        fooServiceSteps.shouldCallFeignClient();
    }

    @Test
    public void testPostMessge() {
        fooServiceSteps.shouldPostMessage("?setting=Angie");
    }
}
