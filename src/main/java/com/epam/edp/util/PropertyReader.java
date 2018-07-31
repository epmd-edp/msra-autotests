package com.epam.edp.util;

import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

/**
 * @author Roman_Martseniuk
 */
public class PropertyReader {

    public static String getProperty(String key) {
        try {
            Properties props = new Properties();
            props.load(PropertyReader.class.getResourceAsStream("/config.properties"));

            String property = props.getProperty(key);
            if (Objects.isNull(property)) {
                throw new IllegalArgumentException("Could not read property with key " + key);
            }
            return property;
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
