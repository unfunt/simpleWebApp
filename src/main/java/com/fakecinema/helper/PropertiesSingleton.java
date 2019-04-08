package com.fakecinema.helper;

import java.io.*;
import java.util.Properties;

/**
 * Created by Vova on 01.04.2019.
 */
public class PropertiesSingleton {

    private static PropertiesSingleton propertiesSingleton = null;
    private String driver;
    private String jdbcUrl;
    private String user;
    private String password;

    private PropertiesSingleton () {
        initializeProperties();
    }

    public static PropertiesSingleton getInstance () {
        if (propertiesSingleton == null) {
            propertiesSingleton = new PropertiesSingleton();
        }
        return propertiesSingleton;
    }

    private void initializeProperties() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("F:\\java-webapp\\src\\main\\resources\\application.properties"));
            driver = properties.getProperty("driver");
            jdbcUrl = properties.getProperty("jdbcUrl");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getDriver () {
        return driver;
    }

    public String getJdbcUrl () {
        return jdbcUrl;
    }

    public String getUser () {
        return user;
    }

    public String getPassword () {
        return password;
    }
}
