package com.epam.edp.steps;

import com.epam.edp.service.api.BarApi;
import com.epam.edp.service.impl.BarApiImpl;
import com.jayway.restassured.specification.RequestSpecification;

/**
 * @author Roman_Martseniuk
 */
public class BarServiceSteps {

    private BarApi barApi;

    public BarServiceSteps(RequestSpecification requestSpecification, String token) {
        this.barApi = new BarApiImpl(requestSpecification, token);
    }

    public void shouldGetSetting() {
        barApi.getSetting();
    }
}