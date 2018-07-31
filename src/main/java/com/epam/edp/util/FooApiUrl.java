package com.epam.edp.util;

/**
 * @author Roman_Martseniuk
 */
public class FooApiUrl {

    public static final String DEFAULT_CONFIG = "/foo/api/config/default";
    public static final String PROFILE_CONFIG = "/foo/api/config/profile";
    public static final String MOUNT_CONFIG = "/foo/api/config/mount";
    public static final String RELOAD_CONFIG = "/foo/api/config/reload";
    public static final String DYNAMIC_CONFIG = "/foo/api/config/dynamic";
    public static final String SECRET_CONFIG = "/foo/api/config/secret";
    public static final String CALL_DUMB_CLIENT = "/foo/api/rpc/dumb-client";
    public static final String CALL_FEIGN_CLIENT = "/foo/api/rpc/feign-client";
    public static final String POST_MESSAGE = "/foo/api/async/message/";

    private FooApiUrl() {
        //NOT IMPL
    }
}
