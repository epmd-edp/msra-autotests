package com.epam.edp;

import com.epam.edp.steps.BarServiceSteps;
import com.epam.edp.steps.FooServiceSteps;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author Roman_Martseniuk
 */
public class BarTest extends BaseTest {

    private FooServiceSteps fooServiceSteps;
    private BarServiceSteps barServiceSteps;

    @BeforeMethod
    public void init() {
        String token = getAccessToken();
        fooServiceSteps = new FooServiceSteps(requestSpecification, token);
        barServiceSteps = new BarServiceSteps(requestSpecification, token);
    }

    @Test
    public void testGetSetting() {
        fooServiceSteps.shouldPostMessage("?setting=Hello World!");
        barServiceSteps.shouldGetSetting();
        fooServiceSteps.shouldPostMessage("?setting=Angie");
    }
}