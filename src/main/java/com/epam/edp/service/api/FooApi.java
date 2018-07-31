package com.epam.edp.service.api;

/**
 * @author Roman_Martseniuk
 */
public interface FooApi {

    void getDefaultConfig();

    void getProfileConfig();

    void getMountConfig();

    void getReloadConfig();

    void getDynamicConfig();

    void getSecretConfig();

    void callDumbClient();

    void callFeignClient();

    void postMessage(String setting);
}
