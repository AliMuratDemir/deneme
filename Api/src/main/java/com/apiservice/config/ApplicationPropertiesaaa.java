package com.apiservice.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public enum ApplicationPropertiesaaa {
    INSTANCE;

    private final Properties properties;

    ApplicationPropertiesaaa() {
        properties = new Properties();
        try {
            properties.load(new FileInputStream("src/test/resources/config.properties"));
        } catch (IOException e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }

    public String getConfig(String parameterName) {
        return properties.getProperty(parameterName);
    }
}
