package com.epam.edp.steps;

import com.epam.edp.service.api.FooApi;
import com.epam.edp.service.impl.FooApiImpl;
import com.jayway.restassured.specification.RequestSpecification;

/**
 * @author Roman_Martseniuk
 */
public class FooServiceSteps {

    private FooApi fooApi;

    public FooServiceSteps(RequestSpecification requestSpecification, String token) {
        this.fooApi = new FooApiImpl(requestSpecification, token);
    }

    public void shouldGetDefaultConfig() {
        fooApi.getDefaultConfig();
    }

    public void shouldGetProfileConfig() {
        fooApi.getProfileConfig();
    }

    public void shouldGetMountConfig() {
        fooApi.getMountConfig();
    }

    public void shouldGetReloadConfig() {
        fooApi.getReloadConfig();
    }

    public void shouldGetDynamicConfig() {
        fooApi.getDynamicConfig();
    }

    public void shouldGetSecretConfig() {
        fooApi.getSecretConfig();
    }

    public void shouldCallDumbClient() {
        fooApi.callDumbClient();
    }

    public void shouldCallFeignClient() {
        fooApi.callFeignClient();
    }

    public void shouldPostMessage(String setting) {
        fooApi.postMessage(setting);
    }
}
